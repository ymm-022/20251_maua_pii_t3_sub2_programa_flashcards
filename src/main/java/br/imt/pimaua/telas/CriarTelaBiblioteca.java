package br.imt.pimaua.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;
import javax.swing.border.BorderFactory;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CriarTelaBiblioteca extends JFrame {
    private JButton btnAdicionarBaralho;
    private JButton btnVoltar;
    private JButton btnAtualizar;
    private JPanel painelPrincipal;
    private JPanel painelBaralhosProprios;
    private JPanel painelBaralhosCompartilhados;
    private JButton btnHome;
    private JTextField barraPesquisa;
    private JButton btnPesquisar;
    private JLabel fotoPerfil;
    private JPanel painelCentral;
    private JLabel iconeLupa;
    private JPanel painelPesquisa;

    public CriarTelaBiblioteca() {
        setTitle("Biblioteca de Flashcards");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Tela cheia
        setLocationRelativeTo(null);

        painelPrincipal = new FundoBibliotecaPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBounds(0, 0, 1920, 1080); // Ajuste para tela cheia

        // Seta de voltar (canto superior esquerdo)
        btnVoltar = new JButton();
        btnVoltar.setBounds(30, 55, 40, 40);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setBorderPainted(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setIcon(new ImageIcon(getSetaIcone(32, 32)));
        painelPrincipal.add(btnVoltar);

        // Botão Home (com ícone e texto destacado)
        btnHome = new JButton("  Home");
        btnHome.setFont(new Font("Arial", Font.BOLD, 16));
        btnHome.setBounds(80, 55, 120, 40);
        btnHome.setBackground(new Color(255, 128, 102));
        btnHome.setForeground(Color.WHITE);
        btnHome.setFocusPainted(false);
        btnHome.setBorder(new LineBorder(new Color(255, 128, 102), 1, true));
        btnHome.setIcon(new ImageIcon(getHomeIcone(24, 24)));
        btnHome.setHorizontalAlignment(SwingConstants.LEFT);
        painelPrincipal.add(btnHome);

        // Barra de pesquisa mais longa e centralizada
        painelPesquisa = new JPanel(new BorderLayout());
        painelPesquisa.setBounds(320, 55, 700, 40);
        painelPesquisa.setBackground(new Color(255, 255, 255));
        painelPesquisa.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));

        barraPesquisa = new JTextField();
        barraPesquisa.setFont(new Font("Arial", Font.PLAIN, 18));
        barraPesquisa.setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 36)); // Espaço para a lupa
        painelPesquisa.add(barraPesquisa, BorderLayout.CENTER);

        iconeLupa = new JLabel(new ImageIcon(getLupaIcone(24, 24)));
        iconeLupa.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 8));
        iconeLupa.setHorizontalAlignment(SwingConstants.RIGHT);
        painelPesquisa.add(iconeLupa, BorderLayout.EAST);

        painelPrincipal.add(painelPesquisa);

        // Ícone de perfil (canto superior direito, circular)
        int perfilSize = 48;
        fotoPerfil = new JLabel("", SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(237, 45, 84));
                g2.fillOval(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
                g2.dispose();
            }
        };
        fotoPerfil.setOpaque(false);
        fotoPerfil.setBounds(1400, 50, perfilSize, perfilSize); // Mais no canto direito
        fotoPerfil.setBorder(null);
        fotoPerfil.setIcon(new ImageIcon(getPerfilIcone(32, 32)));
        fotoPerfil.setHorizontalAlignment(SwingConstants.CENTER);
        fotoPerfil.setVerticalAlignment(SwingConstants.CENTER);
        painelPrincipal.add(fotoPerfil);

        // Título Baralhos Próprios
        JLabel tituloProprios = new JLabel("Baralhos Próprios");
        tituloProprios.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 28));
        tituloProprios.setBounds(120, 120, 400, 40);
        painelPrincipal.add(tituloProprios);

        // Cards Baralhos Próprios (3 colunas, centralizados)
        int cardWidth = 320, cardHeight = 160, cardSpacing = 40;
        int startX = 120;
        int startY = 180;
        for (int i = 0; i < 3; i++) {
            JPanel card = criarCard("<nome_baralho" + (i+1) + ">", "proprio");
            card.setBounds(startX + i * (cardWidth + cardSpacing), startY, cardWidth, cardHeight);
            painelPrincipal.add(card);
        }

        // Título Baralhos Compartilhados
        JLabel tituloCompartilhados = new JLabel("Baralhos Compartilhados");
        tituloCompartilhados.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 28));
        tituloCompartilhados.setBounds(120, 380, 500, 40);
        painelPrincipal.add(tituloCompartilhados);

        // Cards Baralhos Compartilhados (3 colunas, centralizados)
        int startYCompartilhados = 440;
        for (int i = 0; i < 3; i++) {
            JPanel card = criarCard("<nome_baralho" + (i+1) + ">", "compartilhado");
            card.setBounds(startX + i * (cardWidth + cardSpacing), startYCompartilhados, cardWidth, cardHeight);
            painelPrincipal.add(card);
        }

        setContentPane(painelPrincipal);
    }

    private JPanel criarCard(String nome, String tipo) {
        JPanel card = new JPanel(null);
        card.setBackground(Color.WHITE);
        card.setBorder(new LineBorder(new Color(220, 220, 220), 1, true));
        card.setOpaque(true);
        JLabel nomeLabel = new JLabel(nome);
        nomeLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
        nomeLabel.setBounds(10, 10, 180, 30);
        card.add(nomeLabel);
        JLabel icon = new JLabel();
        if ("proprio".equals(tipo)) {
            icon.setIcon(new ImageIcon(getCadeadoIcone(32, 32)));
        } else {
            icon.setIcon(new ImageIcon(getDisqueteIcone(32, 32)));
        }
        // Posicionar no canto inferior direito
        int iconSize = 32;
        int margin = 12;
        card.setPreferredSize(new Dimension(320, 160)); // Garante tamanho para cálculo
        icon.setBounds(320 - iconSize - margin, 160 - iconSize - margin, iconSize, iconSize);
        card.add(icon);
        card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(220, 220, 220), 1, true),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        card.setBackground(Color.WHITE);
        card.setOpaque(true);
        card.setFocusable(false);
        return card;
    }

    private class FundoBibliotecaPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Topo cinza claro
            g.setColor(new Color(240, 240, 240));
            g.fillRect(0, 0, getWidth(), 40);
            // Área principal amarela
            g.setColor(new Color(255, 198, 76));
            g.fillRect(0, 40, getWidth(), getHeight() - 140);
            // Faixa vermelha
            g.setColor(new Color(237, 45, 84));
            g.fillRect(0, getHeight() - 140, getWidth(), 20);
            // Base azul
            g.setColor(new Color(30, 180, 195));
            g.fillRect(0, getHeight() - 120, getWidth(), 120);
        }
    }

    // Métodos utilitários para ícones desenhados
    private Image getSetaIcone(int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(120, 120, 120));
        g2.setStroke(new BasicStroke(5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        int margin = 8;
        int centerY = h / 2;
        // Haste da seta
        g2.drawLine(margin, centerY, w - margin, centerY);
        // Ponta superior
        g2.drawLine(margin, centerY, margin + 14, margin);
        // Ponta inferior
        g2.drawLine(margin, centerY, margin + 14, h - margin);
        g2.dispose();
        return img;
    }
    private Image getHomeIcone(int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Telhado
        g2.setColor(new Color(255, 255, 255));
        int[] xPoints = {w/2, 4, w-4};
        int[] yPoints = {6, h/2, h/2};
        g2.fillPolygon(xPoints, yPoints, 3);
        // Corpo da casa
        g2.fillRect(w/4, h/2, w/2, h/2-4);
        // Porta
        g2.setColor(new Color(200, 200, 200));
        int portaW = w/7;
        int portaH = h/5;
        g2.fillRect(w/2 - portaW/2, h - portaH - 4, portaW, portaH);
        // Contorno
        g2.setColor(new Color(220, 120, 120));
        g2.setStroke(new BasicStroke(2f));
        g2.drawPolygon(xPoints, yPoints, 3);
        g2.drawRect(w/4, h/2, w/2, h/2-4);
        g2.drawRect(w/2 - portaW/2, h - portaH - 4, portaW, portaH);
        g2.dispose();
        return img;
    }
    private Image getLupaIcone(int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(120, 120, 120));
        g2.setStroke(new BasicStroke(3f));
        g2.drawOval(2, 2, w-10, h-10);
        g2.drawLine(w-8, h-8, w-2, h-2);
        g2.dispose();
        return img;
    }
    private Image getPerfilIcone(int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Cabeça (maior, mais acima)
        g2.setColor(Color.BLACK);
        int headDiameter = (int)(w * 0.50);
        int headX = w/2 - headDiameter/2;
        int headY = (int)(h * 0.13);
        g2.fillOval(headX, headY, headDiameter, headDiameter);
        // Tronco (mais abaixo, separado da cabeça)
        int bodyW = (int)(w * 1.00);
        int bodyH = (int)(h * 0.60);
        int bodyX = w/2 - bodyW/2;
        int bodyY = (int)(h * 0.60); // Espaço entre cabeça e tronco
        g2.fillArc(bodyX, bodyY, bodyW, bodyH, 0, 180);
        g2.dispose();
        return img;
    }
    private Image getCadeadoIcone(int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3f));
        g2.drawRoundRect(6, 16, w-12, h-20, 8, 8);
        g2.drawArc(10, 4, w-20, h/2-2, 0, 180);
        g2.dispose();
        return img;
    }
    private Image getDisqueteIcone(int w, int h) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        int arc = 6;
        // Corpo do disquete
        g2.drawRoundRect(3, 3, w-7, h-7, arc, arc);
        // Janela do disquete
        g2.drawRect(w/5, h/2, w/2, h/3);
        // Recorte do topo
        g2.drawLine(w-8, 3, w-8, h/3);
        g2.drawLine(w-8, h/3, w-3, h/3);
        // Linha do topo
        g2.drawLine(3, h/3, w-3, h/3);
        g2.dispose();
        return img;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CriarTelaBiblioteca().setVisible(true);
        });
    }
}