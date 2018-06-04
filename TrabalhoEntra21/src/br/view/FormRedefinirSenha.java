/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.view;

import br.controller.ControllerRedefinirSenha;
import br.util.Imagem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author vinic
 */
public class FormRedefinirSenha extends javax.swing.JFrame {

    private ControllerRedefinirSenha controller;

    public ControllerRedefinirSenha getController() {
        return controller;
    }
    
    /**
     * Creates new form FormRedefinirSenha
     */
    public FormRedefinirSenha() {
        initComponents();
        this.controller = new ControllerRedefinirSenha();
        this.controller.setView(this);
        
        Imagem img = new Imagem();
        img.setIcon(lbl_iconUsuario, Imagem.ICON_USUARIO, 64, 64);
        this.setResizable(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_iconUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tf_user = new javax.swing.JTextField();
        lbl_pergunta = new javax.swing.JLabel();
        tf_resposta = new javax.swing.JTextField();
        btn_ok = new javax.swing.JButton();
        btn_responder = new javax.swing.JButton();
        tf_senha = new javax.swing.JPasswordField();
        lbl_senha = new javax.swing.JLabel();
        tf_confirmarSenha = new javax.swing.JPasswordField();
        lbl_confirmaSenha = new javax.swing.JLabel();
        btn_redefinir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_iconUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setText("Nome de Usuário");

        lbl_pergunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_pergunta.setText(" ");

        tf_resposta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_resposta.setEnabled(false);

        btn_ok.setText("OK");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        btn_responder.setText("Responder");
        btn_responder.setEnabled(false);
        btn_responder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_responderActionPerformed(evt);
            }
        });

        tf_senha.setEnabled(false);

        lbl_senha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_senha.setText("Nova Senha");
        lbl_senha.setEnabled(false);

        tf_confirmarSenha.setEnabled(false);

        lbl_confirmaSenha.setText("Confimar Senha");
        lbl_confirmaSenha.setEnabled(false);

        btn_redefinir.setText("Redefinir Senha");
        btn_redefinir.setEnabled(false);
        btn_redefinir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_redefinirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_user)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ok))
                            .addComponent(tf_resposta)
                            .addComponent(lbl_pergunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbl_confirmaSenha))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_confirmarSenha)
                            .addComponent(tf_senha)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(btn_responder)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 180, Short.MAX_VALUE)
                .addComponent(btn_redefinir)
                .addGap(174, 174, 174))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(192, 192, 192)
                    .addComponent(lbl_iconUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addGap(193, 193, 193)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ok))
                .addGap(18, 18, 18)
                .addComponent(lbl_pergunta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_resposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_responder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_senha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_confirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_confirmaSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_redefinir)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(lbl_iconUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(259, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        this.controller.buscarUsuario();
    }//GEN-LAST:event_btn_okActionPerformed

    private void btn_responderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_responderActionPerformed
        this.controller.responder();
    }//GEN-LAST:event_btn_responderActionPerformed

    private void btn_redefinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_redefinirActionPerformed
        this.controller.redefinir();
    }//GEN-LAST:event_btn_redefinirActionPerformed

    public JButton getBtn_ok() {
        return btn_ok;
    }

    public void setBtn_ok(JButton btn_ok) {
        this.btn_ok = btn_ok;
    }

    public JButton getBtn_redefinir() {
        return btn_redefinir;
    }

    public void setBtn_redefinir(JButton btn_redefinir) {
        this.btn_redefinir = btn_redefinir;
    }

    public JButton getBtn_responder() {
        return btn_responder;
    }

    public void setBtn_responder(JButton btn_responder) {
        this.btn_responder = btn_responder;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getLbl_confirmaSenha() {
        return lbl_confirmaSenha;
    }

    public void setLbl_confirmaSenha(JLabel lbl_confirmaSenha) {
        this.lbl_confirmaSenha = lbl_confirmaSenha;
    }

    public JLabel getLbl_iconUsuario() {
        return lbl_iconUsuario;
    }

    public void setLbl_iconUsuario(JLabel lbl_iconUsuario) {
        this.lbl_iconUsuario = lbl_iconUsuario;
    }

    public JLabel getLbl_pergunta() {
        return lbl_pergunta;
    }

    public void setLbl_pergunta(JLabel lbl_pergunta) {
        this.lbl_pergunta = lbl_pergunta;
    }

    public JLabel getLbl_senha() {
        return lbl_senha;
    }

    public void setLbl_senha(JLabel lbl_senha) {
        this.lbl_senha = lbl_senha;
    }

    public JPasswordField getTf_confirmarSenha() {
        return tf_confirmarSenha;
    }

    public void setTf_confirmarSenha(JPasswordField tf_confirmarSenha) {
        this.tf_confirmarSenha = tf_confirmarSenha;
    }

    public JTextField getTf_resposta() {
        return tf_resposta;
    }

    public void setTf_resposta(JTextField tf_resposta) {
        this.tf_resposta = tf_resposta;
    }

    public JPasswordField getTf_senha() {
        return tf_senha;
    }

    public void setTf_senha(JPasswordField tf_senha) {
        this.tf_senha = tf_senha;
    }

    public JTextField getTf_user() {
        return tf_user;
    }

    public void setTf_user(JTextField tf_user) {
        this.tf_user = tf_user;
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormRedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRedefinirSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRedefinirSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ok;
    private javax.swing.JButton btn_redefinir;
    private javax.swing.JButton btn_responder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_confirmaSenha;
    private javax.swing.JLabel lbl_iconUsuario;
    private javax.swing.JLabel lbl_pergunta;
    private javax.swing.JLabel lbl_senha;
    private javax.swing.JPasswordField tf_confirmarSenha;
    private javax.swing.JTextField tf_resposta;
    private javax.swing.JPasswordField tf_senha;
    private javax.swing.JTextField tf_user;
    // End of variables declaration//GEN-END:variables
}
