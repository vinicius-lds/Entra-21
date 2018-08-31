/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.util.Arquivo;
import br.view.FramePrincipal;
import br.view.panel.login.FormPrimeiroUsuario;
import br.vo.Login;
import br.vo.pessoa.Usuario;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author 104884
 */
public class ControllerPrimeiroUsuario {

    private Login sessao;
    private FormPrimeiroUsuario view;
    private String cb_codigo_itemSelecionado;
    private MaskFormatter maskCpf;
    private MaskFormatter maskCnpj;
    
    public ControllerPrimeiroUsuario() {
        try {
            this.maskCpf = new MaskFormatter("###.###.###-##");
            this.maskCnpj = new MaskFormatter("##.###.###/####-##");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public FormPrimeiroUsuario getView() {
        return view;
    }

    public void setView(FormPrimeiroUsuario view) {
        this.view = view;
        this.cb_codigo_itemSelecionado = this.getView().getCb_codigo().getSelectedItem().toString();
    }

    public Login getSessao() {
        return this.sessao;
    }

    public void setSessao(Login sessao) {
        this.sessao = sessao;
    }

    public void salvarAdmin() {
        if (!(this.getView().getTf_senha().getText()
                .equals(this.getView().getTf_confirmaSenha().getText()))) {
            JOptionPane.showMessageDialog(null, "As senhas digitadas não batem!");
        } else if (this.getView().getTf_senha().getText().equals("admin")) {
            JOptionPane.showMessageDialog(null, "Você deve dar uma senha diferente da padrão!");
        } else {
            try {
                Usuario u = this.getSessao().getUsuario();
                u.setNome(this.getView().getTf_nome().getText());
                u.setCodigo(this.getView().getTf_codigo().getText());
                u.setPass(this.getView().getTf_senha().getText());
                u.setPergunta(this.getView().getCb_pergunta().getSelectedItem().toString());
                u.setResposta(this.getView().getTf_resposta().getText());
                Arquivo.gravarAlteracoesUsuarios();

                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso! Obrigado pela preferencia " + u.getNome() + "!");

                this.getView().setVisible(false);

                JFrame frame = new FramePrincipal();
                ((FramePrincipal) frame).getController().setSessao(Login.getInstance());
                frame.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
    public void redefinir() {
        this.getView().getTf_codigo().setText("");
        this.getView().getTf_confirmaSenha().setText("");
        this.getView().getTf_nome().setText("");
        this.getView().getTf_resposta().setText("");
        this.getView().getTf_senha().setText("");
        this.getView().getCb_codigo().setSelectedIndex(0);
        this.getView().getCb_pergunta().setSelectedIndex(0);
    }
    
    public void trocaMask() {
        if(this.getView().getCb_codigo().getSelectedItem().equals("CNPJ")) {
            maskCpf.uninstall();
            maskCnpj.install(this.getView().getTf_codigo());
        } else {
            maskCnpj.uninstall();
            maskCpf.install(this.getView().getTf_codigo());
        }
    }
    
    public void cb_pergunta_itemStateChanged() {
        if(this.getView().getCb_pergunta().getSelectedIndex() == (this.getView().getCb_pergunta().getItemCount() - 1)) {
            this.getView().getCb_pergunta().setEditable(true);
        } else {
            this.getView().getCb_pergunta().setEditable(false);
        }
    }

}
