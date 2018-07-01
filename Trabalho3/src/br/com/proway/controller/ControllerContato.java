package br.com.proway.controller;

import br.com.proway.bean.ContatosBean;
import br.com.proway.dao.Condicao;
import br.com.proway.main.Main;
import br.com.proway.view.Contato;
import javax.swing.text.MaskFormatter;

/**
 * @author Vinícius Luis da Silva
 */
public class ControllerContato {

    private final Contato view;
    private int idPessoa;
    private MaskFormatter maskTelefone;
    private MaskFormatter maskCelular;
    private final ControllerUsuario controllerUsuario;
    private ContatosBean cb;

    public ControllerContato(Contato view, int idPessoa, ControllerUsuario controllerUsuario) {
        this.view = view;
        this.idPessoa = idPessoa;
        this.controllerUsuario = controllerUsuario;
        try {
            this.maskTelefone = new MaskFormatter("(##) #### ####");
            this.maskCelular = new MaskFormatter("(##) ##### ####");
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.atualizarMask();
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }

    public ControllerContato(Contato view, ContatosBean cb, ControllerUsuario controllerUsuario) {
        this.view = view;
        this.cb = cb;
        this.controllerUsuario = controllerUsuario;
        try {
            this.maskTelefone = new MaskFormatter("(##) #### ####");
            this.maskCelular = new MaskFormatter("(##) ##### ####");
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (cb.getConteudoContato().length()) {
            case 14:
                this.view.getCb_tipoContato().setSelectedIndex(0);
                this.atualizarMask();
                this.view.getTf_conteudoContato().setText(cb.getConteudoContato());
                break;
            case 15:
                this.view.getCb_tipoContato().setSelectedIndex(1);
                this.atualizarMask();
                this.view.getTf_conteudoContato().setText(cb.getConteudoContato());
                break;
            default:
                this.view.getCb_tipoContato().setSelectedIndex(2);
                this.atualizarMask();
                this.view.getTf_emailContato().setText(cb.getConteudoContato());
                break;
        }
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }

    public void atualizarMask() {
        String tipoContato = this.view.getCb_tipoContato().getSelectedItem().toString();
        if (tipoContato.equals("Telefone")) {
            this.view.getTf_conteudoContato().setVisible(true);
            this.view.getTf_emailContato().setVisible(false);
            this.view.getTf_conteudoContato().requestFocus();
            this.maskCelular.uninstall();
            this.maskTelefone.install(this.view.getTf_conteudoContato());
        } else if (tipoContato.equals("Celular")) {
            this.view.getTf_conteudoContato().setVisible(true);
            this.view.getTf_emailContato().setVisible(false);
            this.view.getTf_conteudoContato().requestFocus();
            this.maskTelefone.uninstall();
            this.maskCelular.install(this.view.getTf_conteudoContato());
        } else {
            this.view.getTf_conteudoContato().setVisible(false);
            this.view.getTf_emailContato().setVisible(true);
            this.view.getTf_emailContato().requestFocus();
        }
    }

    public void cadastrarContato() {
        try {
            if (this.idPessoa > 0) {
                Main.CONEXAO.insert(
                        "contatos",
                        new String[]{
                            "conteudoContato",
                            "idPessoa"
                        },
                        new String[][]{{
                            (this.view.getCb_tipoContato().getSelectedItem().equals("E-mail") ? this.view.getTf_emailContato().getText() : this.view.getTf_conteudoContato().getText()),
                            this.idPessoa + ""
                        }});
                this.controllerUsuario.buscarContatos(this.idPessoa);
            } else {
                Condicao c = new Condicao();
                c.addWhere();
                c.addEquals("idContato", this.cb.getIdContato() + "");
                Main.CONEXAO.update(
                        "contatos",
                        new String[]{
                            "conteudoContato",
                            "idPessoa"
                        },
                        new String[]{
                            (this.view.getCb_tipoContato().getSelectedItem().equals("E-mail") ? this.view.getTf_emailContato().getText() : this.view.getTf_conteudoContato().getText()),
                            this.cb.getIdPessoa() + ""
                        },
                        c
                );
                this.controllerUsuario.buscarContatos(this.cb.getIdPessoa());
            }
            this.view.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
