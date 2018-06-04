/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.view;

import br.controller.ControllerEditarPerfil;
import br.view.SubPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author vinic
 */
public class InternalFrameEditarPerfil extends javax.swing.JInternalFrame {

    private ControllerEditarPerfil controller;
    private SubPanel root;

    public SubPanel getRoot() {
        return root;
    }

    public void setRoot(SubPanel root) {
        this.root = root;
    }

    /**
     * Creates new form InternalFrameEditarPerfil
     */
    public InternalFrameEditarPerfil(PanelFuncionario root) {
        initComponents();
        this.controller = new ControllerEditarPerfil();
        this.controller.setView(this);
        this.setRoot(root);
        this.controller.inicializaDados();
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
        tf_codigo = new javax.swing.JFormattedTextField();
        tf_salario = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_nomeUsuario = new javax.swing.JTextField();
        tf_senha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_confirmaSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        cb_pergunta = new javax.swing.JComboBox<>();
        tf_resposta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_cadastrarUsuario = new javax.swing.JButton();
        btn_redefinirUsuario = new javax.swing.JButton();

        setClosable(true);
        setTitle("Editar Perfil");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome");

        cb_codigo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPF", "CNPJ" }));
        cb_codigo.setEnabled(false);
        cb_codigo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_codigoItemStateChanged(evt);
            }
        });

        tf_codigo.setEnabled(false);
        tf_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_codigoActionPerformed(evt);
            }
        });

        tf_salario.setEditable(false);
        tf_salario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        tf_salario.setEnabled(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Salário");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nome de Usuário");

        tf_nomeUsuario.setEditable(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Senha");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Confirmar Senha");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Pergunta");

        cb_pergunta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Qual é o nome do seu melhor amigo de infância?", "Qual o nome do hospital em que você nasceu?", "Qual era o nome do seu primeiro animal de estimação?", "Qual o destino da sua primeira viagem de avião?", "Qual era o nome do seu professor favorito no entra-21?" }));
        cb_pergunta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_perguntaItemStateChanged(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Resposta");

        btn_cadastrarUsuario.setText("Salvar Alterações");
        btn_cadastrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarUsuarioActionPerformed(evt);
            }
        });

        btn_redefinirUsuario.setText("Redefinir");
        btn_redefinirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_redefinirUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_codigo, 0, 97, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tf_codigo, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tf_salario)
                                .addComponent(tf_nome)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tf_confirmaSenha)
                                .addComponent(tf_nomeUsuario)
                                .addComponent(tf_senha)
                                .addComponent(cb_pergunta, 0, 425, Short.MAX_VALUE)
                                .addComponent(tf_resposta)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btn_cadastrarUsuario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_redefinirUsuario)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 352, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tf_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tf_salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tf_nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(tf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tf_confirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cb_pergunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(tf_resposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_cadastrarUsuario)
                        .addComponent(btn_redefinirUsuario))
                    .addContainerGap(18, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_codigoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_codigoItemStateChanged

    }//GEN-LAST:event_cb_codigoItemStateChanged

    private void tf_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_codigoActionPerformed

    private void cb_perguntaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_perguntaItemStateChanged
        this.controller.cb_pergunta_itemStateChanged();
    }//GEN-LAST:event_cb_perguntaItemStateChanged

    private void btn_cadastrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarUsuarioActionPerformed
        this.controller.cadastrarUsuario();
    }//GEN-LAST:event_btn_cadastrarUsuarioActionPerformed

    private void btn_redefinirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_redefinirUsuarioActionPerformed
        this.controller.redefinir();
    }//GEN-LAST:event_btn_redefinirUsuarioActionPerformed

    public ControllerEditarPerfil getController() {
        return controller;
    }

    public void setController(ControllerEditarPerfil controller) {
        this.controller = controller;
    }

    public JButton getBtn_cadastrarUsuario() {
        return btn_cadastrarUsuario;
    }

    public void setBtn_cadastrarUsuario(JButton btn_cadastrarUsuario) {
        this.btn_cadastrarUsuario = btn_cadastrarUsuario;
    }

    public JButton getBtn_redefinirUsuario() {
        return btn_redefinirUsuario;
    }

    public void setBtn_redefinirUsuario(JButton btn_redefinirUsuario) {
        this.btn_redefinirUsuario = btn_redefinirUsuario;
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

    public JLabel getjLabel7() {
        return jLabel7;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.jLabel7 = jLabel7;
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

    public JFormattedTextField getTf_salario() {
        return tf_salario;
    }

    public void setTf_salario(JFormattedTextField tf_salario) {
        this.tf_salario = tf_salario;
    }

    public JPasswordField getTf_senha() {
        return tf_senha;
    }

    public void setTf_senha(JPasswordField tf_senha) {
        this.tf_senha = tf_senha;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrarUsuario;
    private javax.swing.JButton btn_redefinirUsuario;
    private javax.swing.JComboBox<String> cb_codigo;
    private javax.swing.JComboBox<String> cb_pergunta;
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