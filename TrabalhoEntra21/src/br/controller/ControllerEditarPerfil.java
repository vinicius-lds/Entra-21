/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.util.Formato;
import br.view.InternalFrameEditarPerfil;
import br.vo.pessoa.Funcionario;
import br.vo.pessoa.Usuario;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author vinic
 */
public class ControllerEditarPerfil {

    private InternalFrameEditarPerfil view;
    private MaskFormatter maskCpf;
    private MaskFormatter maskCnpj;

    public ControllerEditarPerfil() {
        try {
            this.maskCpf = new MaskFormatter("###.###.###-##");
            this.maskCnpj = new MaskFormatter("##.###.###/####-##");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InternalFrameEditarPerfil getView() {
        return view;
    }

    public void setView(InternalFrameEditarPerfil view) {
        this.view = view;
    }

    public void cb_pergunta_itemStateChanged() {
        if (this.getView().getCb_pergunta().getSelectedIndex() == (this.getView().getCb_pergunta().getItemCount() - 1)) {
            this.getView().getCb_pergunta().setEditable(true);
        } else {
            this.getView().getCb_pergunta().setEditable(false);
        }
    }

    public void cadastrarUsuario() {
        if (!this.getView().getTf_senha().getText().equals(this.getView().getTf_confirmaSenha().getText())) {
            JOptionPane.showMessageDialog(null, "As senhas não batem!");
        } else {
            try {
                Usuario u = Usuario.getUsuario(this.getView().getTf_nomeUsuario().getText());
                u.atualizaUsuario(
                        this.getView().getTf_nome().getText(),
                        this.getView().getTf_codigo().getText(),
                        this.getView().getTf_senha().getText(),
                        this.getView().getCb_pergunta().getSelectedItem().toString(),
                        this.getView().getTf_resposta().getText());
                this.getView().setClosed(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
    public void redefinir() {
        this.getView().getTf_confirmaSenha().setText("");
        this.getView().getTf_nome().setText("");
        this.getView().getTf_resposta().setText("");
        this.getView().getTf_senha().setText("");
        this.getView().getCb_pergunta().setSelectedIndex(0);
    }
    
    public void inicializaDados() {
        Usuario u = this.getView().getRoot().getRoot().getController().getSessao().getUsuario();
        int i;
        for (i = 0; i < this.getView().getCb_pergunta().getItemCount(); i++) {
            if (this.getView().getCb_pergunta().getItemAt(i).equals(u.getPergunta())) {
                this.getView().getCb_pergunta().setSelectedIndex(i);
                break;
            }
        }
        if (i == this.getView().getCb_pergunta().getItemCount()) {
            this.getView().getCb_pergunta().setSelectedIndex(this.getView().getCb_pergunta().getItemCount() - 1);
            this.getView().getCb_pergunta().setEditable(true);
            this.getView().getCb_pergunta().setSelectedItem(u.getPergunta());
        }
        this.getView().getCb_codigo().setSelectedIndex((u.getCodigo().length() == 14) ? 0 : 1);
        this.getView().getTf_codigo().setText(u.getCodigo());
        this.getView().getTf_confirmaSenha().setText(u.getPass());
        this.getView().getTf_senha().setText(u.getPass());
        this.getView().getTf_nome().setText(u.getNome());
        this.getView().getTf_nomeUsuario().setText(u.getUser());
        this.getView().getTf_resposta().setText(u.getResposta());
        this.getView().getTf_salario().setText("R$" + Formato.DECIMAL.format(((Funcionario)u).getSalario()));
        
    }

}
