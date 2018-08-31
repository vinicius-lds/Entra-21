/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.view.panel.crud;

import br.controller.ControllerCadastroUsuarios;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author vinic
 */
public class PanelCadastroUsuarios extends javax.swing.JPanel {

    private ControllerCadastroUsuarios controller;
    
    /**
     * Creates new form PanelCadastroUsuarios
     */
    public PanelCadastroUsuarios() {
        initComponents();
        this.controller = new ControllerCadastroUsuarios();
        this.controller.setView(this);
        this.setBounds(0, 0, 720, 420);
        this.getCb_pergunta().addItem("");
        //this.setMinimumSize(new Dimension(718, 362));
        ((JLabel)this.cb_tipoUsuario.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)this.cb_codigo.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_nome = new javax.swing.JTextField();
        cb_codigo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JFormattedTextField();
        tf_nomeUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_senha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tf_confirmaSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        cb_pergunta = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tf_resposta = new javax.swing.JTextField();
        cb_tipoUsuario = new javax.swing.JComboBox<>();
        btn_cadastrar = new javax.swing.JButton();
        btn_redefinir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tf_salario = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(153, 153, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome");

        cb_codigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPF", "CNPJ" }));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nome de Usuário");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Senha");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Confirmar Senha");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Pergunta Secreta");

        cb_pergunta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Qual é o nome do seu melhor amigo de infância?", "Qual o nome do hospital em que você nasceu?", "Qual era o nome do seu primeiro animal de estimação?", "Qual o destino da sua primeira viagem de avião?", "Qual era o nome do seu professor favorito no entra-21?" }));
        cb_pergunta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_perguntaItemStateChanged(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Resposta");

        cb_tipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cliente", "Caixa", "Funcionario" }));

        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });

        btn_redefinir.setText("Redefinir");
        btn_redefinir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_redefinirActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Salário");

        tf_salario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_tipoUsuario, 0, 698, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nomeUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_senha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_confirmaSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb_pergunta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_resposta, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(btn_cadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_redefinir, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addGap(232, 232, 232))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_codigo, 0, 84, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_codigo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_salario))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cb_tipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tf_nome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_confirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_pergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_resposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_redefinir)
                    .addComponent(btn_cadastrar))
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_perguntaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_perguntaItemStateChanged
        this.controller.cb_pergunta_itemStateChanged();
    }//GEN-LAST:event_cb_perguntaItemStateChanged

    private void btn_redefinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_redefinirActionPerformed
        this.controller.redefinir();
    }//GEN-LAST:event_btn_redefinirActionPerformed

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        this.controller.cadastrar();
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    public ControllerCadastroUsuarios getController() {
        return controller;
    }

    public void setController(ControllerCadastroUsuarios controller) {
        this.controller = controller;
    }

    public JButton getBtn_cadastrar() {
        return btn_cadastrar;
    }

    public void setBtn_cadastrar(JButton btn_cadastrar) {
        this.btn_cadastrar = btn_cadastrar;
    }

    public JButton getBtn_redefinir() {
        return btn_redefinir;
    }

    public void setBtn_redefinir(JButton btn_redefinir) {
        this.btn_redefinir = btn_redefinir;
    }

    public JComboBox<String> getCb_codigo() {
        return cb_codigo;
    }

    public void setCb_codigo(JComboBox<String> cb_codigo) {
        this.cb_codigo = cb_codigo;
    }

    public JComboBox<String> getCb_pergunta() {
        return cb_pergunta;
    }

    public void setCb_pergunta(JComboBox<String> cb_pergunta) {
        this.cb_pergunta = cb_pergunta;
    }

    public JComboBox<String> getCb_tipoUsuario() {
        return cb_tipoUsuario;
    }

    public void setCb_tipoUsuario(JComboBox<String> cb_tipoUsuario) {
        this.cb_tipoUsuario = cb_tipoUsuario;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JFormattedTextField getTf_codigo() {
        return tf_codigo;
    }

    public void setTf_codigo(JFormattedTextField tf_codigo) {
        this.tf_codigo = tf_codigo;
    }

    public JPasswordField getTf_confirmaSenha() {
        return tf_confirmaSenha;
    }

    public void setTf_confirmaSenha(JPasswordField tf_confirmaSenha) {
        this.tf_confirmaSenha = tf_confirmaSenha;
    }

    public JTextField getTf_nome() {
        return tf_nome;
    }

    public void setTf_nome(JTextField tf_nome) {
        this.tf_nome = tf_nome;
    }

    public JTextField getTf_nomeUsuario() {
        return tf_nomeUsuario;
    }

    public void setTf_nomeUsuario(JTextField tf_nomeUsuario) {
        this.tf_nomeUsuario = tf_nomeUsuario;
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
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_redefinir;
    private javax.swing.JComboBox<String> cb_codigo;
    private javax.swing.JComboBox<String> cb_pergunta;
    private javax.swing.JComboBox<String> cb_tipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JFormattedTextField tf_codigo;
    private javax.swing.JPasswordField tf_confirmaSenha;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextField tf_nomeUsuario;
    private javax.swing.JTextField tf_resposta;
    private javax.swing.JFormattedTextField tf_salario;
    private javax.swing.JPasswordField tf_senha;
    // End of variables declaration//GEN-END:variables
}