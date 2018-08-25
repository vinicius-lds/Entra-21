package br.com.proway.view;

import br.com.proway.bean.ContatosBean;
import br.com.proway.controller.ControllerContato;
import br.com.proway.controller.ControllerUsuario;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 * @author Vinícius Luis da Silva
 */
public class Contato extends javax.swing.JFrame {

    private ControllerContato controller;
    
    public Contato(int idPessoa, ControllerUsuario controllerUsuario) {
        initComponents();
        this.controller = new ControllerContato(this, idPessoa, controllerUsuario);
    }
    
    public Contato(ContatosBean cb, ControllerUsuario controllerUsuario) {
        initComponents();
        this.controller = new ControllerContato(this, cb, controllerUsuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_conteudoContato = new javax.swing.JFormattedTextField();
        cb_tipoContato = new javax.swing.JComboBox<>();
        btn_cadastrar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        tf_emailContato = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_conteudoContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_conteudoContatoMouseClicked(evt);
            }
        });
        getContentPane().add(tf_conteudoContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 9, 250, -1));

        cb_tipoContato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Telefone", "Celular", "E-mail" }));
        getContentPane().add(cb_tipoContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 38, -1, -1));

        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 38, -1, -1));
        getContentPane().add(tf_emailContato, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 250, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void tf_conteudoContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_conteudoContatoMouseClicked
        this.controller.atualizarMask();
    }//GEN-LAST:event_tf_conteudoContatoMouseClicked

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
        this.controller.cadastrarContato();
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    public ControllerContato getController() {
        return controller;
    }

    public void setController(ControllerContato controller) {
        this.controller = controller;
    }

    public JButton getBtn_cadastrar() {
        return btn_cadastrar;
    }

    public void setBtn_cadastrar(JButton btn_cadastrar) {
        this.btn_cadastrar = btn_cadastrar;
    }

    public JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public JTextField getTf_emailContato() {
        return tf_emailContato;
    }

    public void setTf_emailContato(JTextField tf_emailContato) {
        this.tf_emailContato = tf_emailContato;
    }

    public void setBtn_cancelar(JButton btn_cancelar) {
        this.btn_cancelar = btn_cancelar;
    }

    public JComboBox<String> getCb_tipoContato() {
        return cb_tipoContato;
    }

    public void setCb_tipoContato(JComboBox<String> cb_tipoContato) {
        this.cb_tipoContato = cb_tipoContato;
    }

    public JFormattedTextField getTf_conteudoContato() {
        return tf_conteudoContato;
    }

    public void setTf_conteudoContato(JFormattedTextField tf_conteudoContato) {
        this.tf_conteudoContato = tf_conteudoContato;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JComboBox<String> cb_tipoContato;
    private javax.swing.JFormattedTextField tf_conteudoContato;
    private javax.swing.JTextField tf_emailContato;
    // End of variables declaration//GEN-END:variables
}
