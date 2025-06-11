/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.imt.pimaua.telas ;
import br.imt.pimaua.Flashcard;
import br.imt.pimaua.persistencia.FlashcardDAO;
import java.util.*;
import javax.swing.*;

public class FlashCardTela extends javax.swing.JFrame {
    private List<Flashcard> flashcards;
    private int indexAtual = 0;
    
    public FlashCardTela() {
        initComponents();
        setLocationRelativeTo(null);
        respostaTextArea.setVisible(false);
        carregarFlashcards();
        mostrarFlashcardAtual();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        respostaTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        enunciadoTextArea = new javax.swing.JTextArea();
        visualizarButtom = new javax.swing.JButton();
        proximoButtom = new javax.swing.JButton();
        voltarButtom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 198, 76));

        jPanel3.setBackground(new java.awt.Color(255, 229, 174));

        respostaTextArea.setColumns(20);
        respostaTextArea.setRows(5);
        jScrollPane1.setViewportView(respostaTextArea);

        enunciadoTextArea.setColumns(20);
        enunciadoTextArea.setRows(5);
        jScrollPane2.setViewportView(enunciadoTextArea);

        visualizarButtom.setText("visualizar");
        visualizarButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(visualizarButtom)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(visualizarButtom)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
        );

        proximoButtom.setBackground(new java.awt.Color(30, 180, 195));
        proximoButtom.setText("proximo");
        proximoButtom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        proximoButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximoButtomActionPerformed(evt);
            }
        });

        voltarButtom.setBackground(new java.awt.Color(30, 180, 195));
        voltarButtom.setText("voltar");
        voltarButtom.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        voltarButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(proximoButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(voltarButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(voltarButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(proximoButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 119, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proximoButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoButtomActionPerformed
        if (flashcards != null && !flashcards.isEmpty()) {
        indexAtual = (indexAtual + 1) % flashcards.size();
        mostrarFlashcardAtual();
        } 
    }//GEN-LAST:event_proximoButtomActionPerformed

    private void voltarButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtomActionPerformed
        this.setVisible(false);
        
    }//GEN-LAST:event_voltarButtomActionPerformed

    private void visualizarButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarButtomActionPerformed
        respostaTextArea.setVisible(!respostaTextArea.isVisible());
    }//GEN-LAST:event_visualizarButtomActionPerformed
    private void carregarFlashcards() {
        System.out.println(">>> ENTROU NO MÉTODO carregarFlashcards()");
    try {
        FlashcardDAO dao = new FlashcardDAO();
        flashcards = dao.obterFlashcard();
        
        System.out.println("QTD Flashcards: " + flashcards.size());
        
        for (Flashcard f : flashcards){
            System.out.println(">>> " + f.getResposta() + " | " + f.getPergunta());
        }
        
        if (flashcards.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum flashcard encontrado ");
            proximoButtom.setEnabled(false);
            visualizarButtom.setEnabled(false);
        }
    } catch (Exception e) {
    e.printStackTrace(); // <-- ESSENCIAL para ver o erro real no console
    JOptionPane.showMessageDialog(this, "Erro ao carregar flashcards: " + e.getMessage());
}

    System.out.println("Flashcards carregados: " + flashcards.size());
    for (Flashcard f : flashcards) {
        System.out.println(f.getResposta() + " | " + f.getPergunta());
    }
    
    }

    private void mostrarFlashcardAtual() {
        if (flashcards != null && !flashcards.isEmpty()) {
            Flashcard atual = flashcards.get(indexAtual);
            enunciadoTextArea.setText(atual.getResposta());
            respostaTextArea.setText(atual.getPergunta());
            respostaTextArea.setVisible(false);
        }
    }
    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlashCardTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea enunciadoTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton proximoButtom;
    private javax.swing.JTextArea respostaTextArea;
    private javax.swing.JButton visualizarButtom;
    private javax.swing.JButton voltarButtom;
    // End of variables declaration//GEN-END:variables
}