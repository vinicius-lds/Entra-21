/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.view.FormRedefinirSenha;
import br.view.FramePrincipal;
import br.vo.Login;
import br.vo.pessoa.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class ControllerRedefinirSenha {

    private FormRedefinirSenha view;
    private Usuario u;

    public FormRedefinirSenha getView() {
        return view;
    }

    public void setView(FormRedefinirSenha view) {
        this.view = view;
    }

    public void buscarUsuario() {
        try {
            this.u = Usuario.getUsuario(this.getView().getTf_user().getText());
            Login.getInstance().setUsuario(u);
            this.getView().getTf_user().setEnabled(false);
            this.getView().getTf_resposta().setEnabled(true);
            this.getView().getLbl_pergunta().setText(u.getPergunta());
            this.getView().getBtn_responder().setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void responder() {
        if (!this.u.getResposta().equals(this.getView().getTf_resposta().getText())) {
            this.getView().getTf_resposta().setText("");
            JOptionPane.showMessageDialog(null, "A resposta está errada!");
        } else {
            this.getView().getTf_resposta().setEnabled(false);
            this.getView().getTf_senha().setEnabled(true);
            this.getView().getTf_confirmarSenha().setEnabled(true);
            this.getView().getLbl_senha().setEnabled(true);
            this.getView().getLbl_confirmaSenha().setEnabled(true);
            this.getView().getBtn_redefinir().setEnabled(true);
        }
    }

    public void redefinir() {
        if (!this.getView().getTf_senha().getText().equals(this.getView().getTf_confirmarSenha().getText())) {
            JOptionPane.showMessageDialog(null, "As senhas não batem!");
        } else {
            this.u.atualizaUsuario(
                    u.getNome(),
                    u.getCodigo(),
                    this.getView().getTf_senha().getText(),
                    u.getPergunta(),
                    u.getResposta());
            this.getView().setVisible(false);

            Login.getInstance().setUsuario(u);
            
            JFrame frame = new FramePrincipal(Login.getInstance());
            frame.setVisible(true);
        }
    }

}
