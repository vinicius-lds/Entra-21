
package br.controller;

import br.view.FormRedefinirSenha;
import br.view.FramePrincipal;
import br.view.FormLogin;
import br.view.FormPrimeiroUsuario;
import br.vo.Login;
import br.vo.pessoa.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author 104884
 */
public class ControllerLogin {
    
    private FormLogin view;

    public void redefinirSenha() {
        this.getView().setVisible(false);
        new FormRedefinirSenha().setVisible(true);
    }
    
    public FormLogin getView() {
        return view;
    }

    public void setView(FormLogin view) {
        this.view = view;
    }

    public void login(JTextField tf_user, JTextField tf_pass) {
        try {
            if(!Usuario.existeUsuario(tf_user.getText())) {
                JOptionPane.showMessageDialog(null, "O usuário não existe!");
            } else {
                Usuario usuario = Usuario.getUsuario(tf_user.getText());
                if(usuario.isPass(tf_pass.getText())) {
                    this.getView().setVisible(false);
                    JFrame frame;
                    Login.getInstance().setUsuario(usuario);
                    if(Login.getInstance().getUsuario().isPass("admin")) {
                        frame = new FormPrimeiroUsuario();
                        ((FormPrimeiroUsuario)frame).getController().setSessao(Login.getInstance());
                        frame.setVisible(true);
                    } else {
                        frame = new FramePrincipal(Login.getInstance());
                        frame.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "A senha do usário está incorreta!");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
