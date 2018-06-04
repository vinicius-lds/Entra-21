/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.view;

import br.controller.ControllerLogin;
import br.util.Arquivo;
import br.util.Imagem;
import br.vo.Financeiro;
import br.vo.Historico;
import br.vo.financeiro.Dispesa;
import br.vo.financeiro.Receita;
import br.vo.pessoa.Gerente;
import br.vo.pessoa.Usuario;
import br.vo.produto.Produto;
import br.vo.produto.ProdutoQuilo;
import br.vo.produto.ProdutoUnidade;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author 104884
 */
public class FormLogin extends javax.swing.JFrame {

    private ControllerLogin controller;

    public ControllerLogin getController() {
        return this.controller;
    }

    /**
     * Creates new form FormLogin
     */
    public FormLogin() {
       
        /*
        try {
            Files.deleteIfExists(Paths.get("data/DefinitivamenteNaoEASenhaELoginDeTodoMundo.dat"));
            Files.createFile(Paths.get("data/DefinitivamenteNaoEASenhaELoginDeTodoMundo.dat"));
            FileOutputStream fos = new FileOutputStream(Paths.get("data/DefinitivamenteNaoEASenhaELoginDeTodoMundo.dat").toFile());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ArrayList<Usuario> al = new ArrayList<>();
            al.add(new Gerente());
            oos.writeObject(al);
            
            Files.deleteIfExists(Paths.get("data/Dispesa.dat"));
            Files.createFile(Paths.get("data/Dispesa.dat"));
            fos = new FileOutputStream(Paths.get("data/Dispesa.dat").toFile());
            oos = new ObjectOutputStream(fos);
            ArrayList<Dispesa> al1 = new ArrayList<>();
            oos.writeObject(al1);
            
            Files.deleteIfExists(Paths.get("data/Receita.dat"));
            Files.createFile(Paths.get("data/Receita.dat"));
            fos = new FileOutputStream(Paths.get("data/Receita.dat").toFile());
            oos = new ObjectOutputStream(fos);
            ArrayList<Receita> al2 = new ArrayList<>();
            oos.writeObject(al2);
            
            Files.deleteIfExists(Paths.get("data/Historico.dat"));
            Files.createFile(Paths.get("data/Historico.dat"));
            fos = new FileOutputStream(Paths.get("data/Historico.dat").toFile());
            oos = new ObjectOutputStream(fos);
            ArrayList<Historico> al3 = new ArrayList<>();
            oos.writeObject(al3);
            
            Files.deleteIfExists(Paths.get("data/Produtos.dat"));
            Files.createFile(Paths.get("data/Produtos.dat"));
            fos = new FileOutputStream(Paths.get("data/Produtos.dat").toFile());
            oos = new ObjectOutputStream(fos);
            ArrayList<Produto> al4 = new ArrayList<>();
            oos.writeObject(al4);
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
       
/**/
        this.setUndecorated(true);
        this.controller = new ControllerLogin();
        this.controller.setView(this);
        Imagem img = new Imagem();

        initComponents();
        img.setIcon(lbl_backgroung, Imagem.LOGIN_BACKGROUND, 600, 600);
        img.setIcon(lbl_close, Imagem.ICON_CLOSE, 30, 30);
        /*        int width = 600;
        int height = 600;
        //lbl_backgroung.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Imagem.LOGIN_BACKGROUND)).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
        
        width = 30;
        height = 30;
        lbl_close.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Imagem.ICON_CLOSE)).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
         */
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_close = new javax.swing.JLabel();
        tf_user = new javax.swing.JTextField();
        tf_pass = new javax.swing.JPasswordField();
        lbl_btnResetPass = new javax.swing.JLabel();
        lbl_btnLogin = new javax.swing.JLabel();
        lbl_backgroung = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbl_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_closeMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_close);
        lbl_close.setBounds(570, 0, 30, 30);

        tf_user.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        tf_user.setText("admin");
        tf_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_userKeyPressed(evt);
            }
        });
        getContentPane().add(tf_user);
        tf_user.setBounds(140, 220, 330, 60);

        tf_pass.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        tf_pass.setText("0Ab*");
        tf_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_passKeyPressed(evt);
            }
        });
        getContentPane().add(tf_pass);
        tf_pass.setBounds(139, 292, 330, 60);

        lbl_btnResetPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnResetPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnResetPassMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_btnResetPass);
        lbl_btnResetPass.setBounds(350, 390, 120, 20);

        lbl_btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_btnLoginMouseClicked(evt);
            }
        });
        getContentPane().add(lbl_btnLogin);
        lbl_btnLogin.setBounds(151, 376, 160, 40);
        getContentPane().add(lbl_backgroung);
        lbl_backgroung.setBounds(0, 0, 600, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_closeMouseClicked

    private void lbl_btnResetPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnResetPassMouseClicked
        controller.redefinirSenha();
    }//GEN-LAST:event_lbl_btnResetPassMouseClicked

    private void lbl_btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_btnLoginMouseClicked
        controller.login(tf_user, tf_pass);
    }//GEN-LAST:event_lbl_btnLoginMouseClicked

    private void tf_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_userKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            controller.login(tf_user, tf_pass);
        }
    }//GEN-LAST:event_tf_userKeyPressed

    private void tf_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_passKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            controller.login(tf_user, tf_pass);
        }
    }//GEN-LAST:event_tf_passKeyPressed

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
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        ArrayList<Usuario> base = Arquivo.lerArquivoUsuarios();
        if (base == null) {
            System.exit(0);
        }
        Usuario.setUsuarios(base);
        Historico.setHistorico(Arquivo.lerArquivoHistorico());
        Financeiro.getInstance().setDispesas(Arquivo.lerArquivoDispesas());
        Financeiro.getInstance().setReceitas(Arquivo.lerArquivoReceitas());
        Produto.setProdutos(Arquivo.lerArquivoProdutos());
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_backgroung;
    private javax.swing.JLabel lbl_btnLogin;
    private javax.swing.JLabel lbl_btnResetPass;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JPasswordField tf_pass;
    private javax.swing.JTextField tf_user;
    // End of variables declaration//GEN-END:variables
}
