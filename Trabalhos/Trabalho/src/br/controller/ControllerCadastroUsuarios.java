
package br.controller;

import br.view.panel.crud.PanelCadastroUsuarios;
import br.vo.pessoa.Caixa;
import br.vo.pessoa.Cliente;
import br.vo.pessoa.Funcionario;
import br.vo.pessoa.Usuario;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 * @author 104884
 */
public class ControllerCadastroUsuarios {

    private PanelCadastroUsuarios view;
    private MaskFormatter maskCpf;
    private MaskFormatter maskCnpj;
    
    public ControllerCadastroUsuarios() {
        try {
            this.maskCpf = new MaskFormatter("###.###.###-##");
            this.maskCnpj = new MaskFormatter("##.###.###/####-##");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public PanelCadastroUsuarios getView() {
        return view;
    }

    public void setView(PanelCadastroUsuarios view) {
        this.view = view;
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
    
    public void cadastrar() {
        if(Usuario.existeUsuario(this.getView().getTf_nomeUsuario().getText())) {
            throw new IllegalArgumentException("O usário " + this.getView().getTf_nomeUsuario().getText() + " já está cadastrado!");
        } 
        
        if(!this.getView().getTf_senha().getText().equals(this.getView().getTf_confirmaSenha())) {
            throw new IllegalArgumentException("As senhas não batem!");
        }
        
        switch (this.getView().getCb_tipoUsuario().toString()) {
            case "Cliente":
                Usuario.addUsuario(new Cliente(
                        this.getView().getTf_nome().getText(), 
                        this.getView().getTf_codigo().getText(), 
                        this.getView().getTf_nomeUsuario().getText(), 
                        this.getView().getTf_senha().getText(), 
                        this.getView().getCb_pergunta().getSelectedItem().toString(), 
                        this.getView().getTf_resposta().getText()));
                break;
            case "Funcionario":
                Usuario.addUsuario(new Funcionario(
                        this.getView().getTf_nome().getText(), 
                        this.getView().getTf_codigo().getText(), 
                        this.getView().getTf_nomeUsuario().getText(), 
                        this.getView().getTf_senha().getText(), 
                        this.getView().getCb_pergunta().getSelectedItem().toString(), 
                        this.getView().getTf_resposta().getText(),
                        Double.parseDouble(this.getView().getTf_resposta().getText().replaceAll(",", "."))));                
                break;
            case "Caixa":
                Usuario.addUsuario(new Caixa(
                        this.getView().getTf_nome().getText(), 
                        this.getView().getTf_codigo().getText(), 
                        this.getView().getTf_nomeUsuario().getText(), 
                        this.getView().getTf_senha().getText(), 
                        this.getView().getCb_pergunta().getSelectedItem().toString(), 
                        this.getView().getTf_resposta().getText(),
                        Double.parseDouble(this.getView().getTf_resposta().getText().replaceAll(",", "."))));                
                break;
            default:
                JOptionPane.showMessageDialog(null, "Você não pode criar um usário do tipo " + this.getView().getCb_tipoUsuario().toString());
        }
    }
    
    public void trocarMask() {
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
