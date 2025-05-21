package br.imt.pimaua.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

public class CriarTelaBiblioteca extends JFrame {
    private JButton btnAdicionarBaralho;
    private JButton btnVoltar;
    private JButton btnAtualizar;
    private JPanel painelPrincipal;
    private JPanel painelBaralhosProprios;
    private JPanel painelBaralhosCompartilhados;

    public CriarTelaBiblioteca() {
        setTitle("Biblioteca de Flashcards");
        setBounds(100, 100, 770, 490);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        painelPrincipal = new FundoBibliotecaPanel();
        painelPrincipal.setLayout(null);
        painelPrincipal.setBounds(0, 0, 770, 490);

        btnAdicionarBaralho = new JButton("Adicionar Baralho");
        btnAdicionarBaralho.setBounds(40, 55, 170, 36);
        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(310, 55, 170, 36);
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(580, 55, 120, 36);

        painelPrincipal.add(btnAdicionarBaralho);
        painelPrincipal.add(btnAtualizar);
        painelPrincipal.add(btnVoltar);

        adicionarBaralhos();

        painelBaralhosProprios.setBounds(40, 110, 690, 140);
        painelBaralhosCompartilhados.setBounds(40, 260, 690, 140);
        painelPrincipal.add(painelBaralhosProprios);
        painelPrincipal.add(painelBaralhosCompartilhados);

        setContentPane(painelPrincipal);
    }

    private void adicionarBaralhos() {
        painelBaralhosProprios = new JPanel();
        painelBaralhosProprios.setBorder(BorderFactory.createTitledBorder("Baralhos Próprios"));
        painelBaralhosProprios.setLayout(null);
        painelBaralhosProprios.setBounds(40, 110, 690, 140);

        int espacamento = 30;
        int largura = 200;
        int altura = 90;
        for (int i = 1; i <= 3; i++) {
            JButton baralhoBtn = new JButton("<nome_baralho" + i + ">");
            baralhoBtn.setHorizontalAlignment(SwingConstants.LEFT);
            baralhoBtn.setBounds((i - 1) * (largura + espacamento), 30, largura, altura);
            baralhoBtn.setIcon(new JLabel("\uD83D\uDD13").getIcon());
            painelBaralhosProprios.add(baralhoBtn);
        }

        painelBaralhosCompartilhados = new JPanel();
        painelBaralhosCompartilhados.setBorder(BorderFactory.createTitledBorder("Baralhos Compartilhados"));
        painelBaralhosCompartilhados.setLayout(null);
        painelBaralhosCompartilhados.setBounds(40, 260, 690, 140);

        for (int i = 1; i <= 3; i++) {
            JButton baralhoBtn = new JButton("<nome_baralho" + i + ">");
            baralhoBtn.setHorizontalAlignment(SwingConstants.LEFT);
            baralhoBtn.setBounds((i - 1) * (largura + espacamento), 30, largura, altura);
            baralhoBtn.setIcon(new JLabel("\uD83D\uDCBE").getIcon());
            painelBaralhosCompartilhados.add(baralhoBtn);
        }
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CriarTelaBiblioteca().setVisible(true);
        });
    }
}
