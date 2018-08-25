package br.com.proway.view;

import br.com.proway.controller.ControllerPrincipal;
import javax.swing.JLabel;

/**
 * @author Vinícius Luis da Silva
 */
public class Principal extends javax.swing.JFrame {

    private ControllerPrincipal controller;
    
    public Principal() {
        initComponents();
        this.controller = new ControllerPrincipal(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_cliente = new javax.swing.JLabel();
        lbl_produto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_cliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_clienteMouseClicked(evt);
            }
        });

        lbl_produto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_produto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_produtoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(lbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_produtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_produtoMouseClicked
        this.controller.trocarTela(new Produto());
    }//GEN-LAST:event_lbl_produtoMouseClicked

    private void lbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_clienteMouseClicked
        this.controller.trocarTela(new Usuario());
    }//GEN-LAST:event_lbl_clienteMouseClicked

    public ControllerPrincipal getController() {
        return controller;
    }

    public void setController(ControllerPrincipal controller) {
        this.controller = controller;
    }

    public JLabel getLbl_cliente() {
        return lbl_cliente;
    }

    public void setLbl_cliente(JLabel lbl_cliente) {
        this.lbl_cliente = lbl_cliente;
    }

    public JLabel getLbl_produto() {
        return lbl_produto;
    }

    public void setLbl_produto(JLabel lbl_produto) {
        this.lbl_produto = lbl_produto;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JLabel lbl_produto;
    // End of variables declaration//GEN-END:variables
}
