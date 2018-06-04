/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.view;

import br.controller.ControllerPrimeiroUsuario;
import br.util.Imagem;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author 104884
 */
public class FormPrimeiroUsuario extends javax.swing.JFrame {

    private ControllerPrimeiroUsuario controller;

    public ControllerPrimeiroUsuario getController() {
        return this.controller;
    }

    /**
     * Creates new form FormPrimeiroUsuario
     */
    public FormPrimeiroUsuario() {
        //this.setUndecorated(true);
        this.controller = new ControllerPrimeiroUsuario();
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        /*
        int width = 64;
        int height = 64;
        lbl_iconUsuario.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Imagem.ICON_USUARIO)).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
        */
        Imagem img = new Imagem();
        img.setIcon(lbl_iconUsuario, Imagem.ICON_USUARIO, 64, 64);
        
        
        this.setMinimumSize(new Dimension(this.getWidth(), this.getHeight()));
        this.setTitle("Cadastro do Primeiro Usuário");
        ((JLabel)this.cb_codigo.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT);
        this.getCb_pergunta().addItem("");
        
        this.controller.setView(this);
        this.controller.trocaMask();
        
    }

    public JButton getBtn_redefinir() {
        return btn_redefinir;
    }

    public JButton getBtn_salvar() {
        return btn_salvar;
    }

    public JComboBox<String> getCb_codigo() {
        return cb_codigo;
    }

    public JComboBox<String> getCb_pergunta() {
        return cb_pergunta;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public JLabel getLbl_iconUsuario() {
        return lbl_iconUsuario;
    }

    public JFormattedTextField getTf_codigo() {
        return tf_codigo;
    }

    public JPasswordField getTf_confirmaSenha() {
        return tf_confirmaSenha;
    }

    public JTextField getTf_nome() {
        return tf_nome;
    }

    public JTextField getTf_resposta() {
        return tf_resposta;
    }

    public JPasswordField getTf_senha() {
        return tf_senha;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_nome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cb_codigo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_senha = new javax.swing.JPasswordField();
        tf_confirmaSenha = new javax.swing.JPasswordField();
        cb_pergunta = new javax.swing.JComboBox<>();
        tf_resposta = new javax.swing.JTextField();
        tf_codigo = new javax.swing.JFormattedTextField();
        lbl_iconUsuario = new javax.swing.JLabel();
        btn_salvar = new javax.swing.JButton();
        btn_redefinir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome");

        cb_codigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPF", "CNPJ" }));
        cb_codigo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_codigoItemStateChanged(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Senha");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Confirmar Senha");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Pergunta Secreta");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Resposta");

        cb_pergunta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Qual é o nome do seu melhor amigo de infância?", "Qual o nome do hospital em que você nasceu?", "Qual era o nome do seu primeiro animal de estimação?", "Qual o destino da sua primeira viagem de avião?", "Qual era o nome do seu professor favorito no entra-21?" }));
        cb_pergunta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_perguntaItemStateChanged(evt);
            }
        });

        lbl_iconUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_salvar.setText("Salvar Alterações");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_redefinir.setText("Redefinir");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_pergunta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_resposta)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_codigo)
                            .addComponent(tf_senha)
                            .addComponent(tf_nome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_confirmaSenha, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(lbl_iconUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                .addGap(214, 214, 214))
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(btn_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_redefinir, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbl_iconUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_confirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_pergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_resposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_redefinir))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_redefinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_redefinirActionPerformed
        this.controller.redefinir();
    }//GEN-LAST:event_btn_redefinirActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        this.controller.salvarAdmin();
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void cb_codigoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_codigoItemStateChanged
        this.controller.trocaMask();
    }//GEN-LAST:event_cb_codigoItemStateChanged

    private void cb_perguntaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_perguntaItemStateChanged
        this.controller.cb_pergunta_itemStateChanged();
    }//GEN-LAST:event_cb_perguntaItemStateChanged

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_redefinir;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JComboBox<String> cb_codigo;
    private javax.swing.JComboBox<String> cb_pergunta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_iconUsuario;
    private javax.swing.JFormattedTextField tf_codigo;
    private javax.swing.JPasswordField tf_confirmaSenha;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextField tf_resposta;
    private javax.swing.JPasswordField tf_senha;
    // End of variables declaration//GEN-END:variables
}
