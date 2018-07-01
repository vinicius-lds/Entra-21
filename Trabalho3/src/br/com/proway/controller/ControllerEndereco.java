package br.com.proway.controller;

import br.com.proway.bean.EnderecosBean;
import br.com.proway.dao.Condicao;
import br.com.proway.main.Main;
import br.com.proway.view.Endereco;

/**
 * @author Vinícius Luis da Silva
 */
public class ControllerEndereco {

    private final Endereco view;
    private final ControllerUsuario cu;
    private int idPessoa;
    private EnderecosBean eb;

    public ControllerEndereco(Endereco view, int idPessoa, ControllerUsuario cu) {
        this.view = view;
        this.idPessoa = idPessoa;
        this.cu = cu;
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }

    public ControllerEndereco(Endereco view, ControllerUsuario cu, EnderecosBean eb) {
        this.view = view;
        this.cu = cu;
        this.eb = eb;
        this.view.setLocationRelativeTo(null);
        this.view.getBtn_cadastrar().setText("Salvar Alterações");
        this.view.getTf_rua().setText(eb.getRuaEndereco());
        this.view.getTf_complemento().setText(eb.getComplementoEndereco());
        this.view.getTf_cep().setText(eb.getCepEndereco());
        this.view.setVisible(true);
    }

    public void cadastrarEndereco() {
        try {
            if (this.idPessoa > 0) {
                Main.CONEXAO.insert(
                        "enderecos",
                        new String[]{
                            "ruaEndereco",
                            "cepEndereco",
                            "complementoEndereco",
                            "idPessoa"
                        },
                        new String[][]{
                            {
                                this.view.getTf_rua().getText(),
                                this.view.getTf_cep().getText(),
                                this.view.getTf_complemento().getText(),
                                this.idPessoa + ""
                            }
                        });
                this.cu.buscarEnderecos(this.idPessoa);
            } else {
                Condicao c = new Condicao();
                c.addWhere();
                c.addEquals("idEndereco", this.eb.getIdEndereco() + "");
                Main.CONEXAO.update("enderecos",
                        new String[]{
                            "ruaEndereco",
                            "cepEndereco",
                            "complementoEndereco",
                            "idPessoa"
                        },
                        new String[]{
                            this.view.getTf_rua().getText(),
                            this.view.getTf_cep().getText(),
                            this.view.getTf_complemento().getText(),
                            this.eb.getIdPessoa() + ""
                        },
                        c
                );
                this.cu.buscarEnderecos(this.eb.getIdPessoa());
            }
            this.view.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
