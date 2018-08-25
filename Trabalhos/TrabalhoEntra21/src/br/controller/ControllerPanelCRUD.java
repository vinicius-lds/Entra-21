package br.controller;

import br.util.Formato;
import br.util.Arquivo;
import br.view.PanelCRUD;
import br.vo.Historico;
import br.vo.pessoa.Caixa;
import br.vo.pessoa.Cliente;
import br.vo.pessoa.Funcionario;
import br.vo.pessoa.Usuario;
import br.vo.produto.Produto;
import br.vo.produto.ProdutoQuilo;
import br.vo.produto.ProdutoUnidade;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 * @author vinic
 */
public class ControllerPanelCRUD {

    private PanelCRUD view;
    private MaskFormatter maskCpf;
    private MaskFormatter maskCnpj;

    public ControllerPanelCRUD() {
        try {
            this.maskCpf = new MaskFormatter("###.###.###-##");
            this.maskCnpj = new MaskFormatter("##.###.###/####-##");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluirUsuarioSelecionado() {
        Usuario u = Usuario.getUsuario(this.getView().getTb_usuarios().getValueAt(this.getView().getTb_usuarios().getSelectedRow(), 0).toString());
        if (u.getUser().equals("admin")) {
            JOptionPane.showMessageDialog(null, "Você não pode excluuir o usuário principal!");
        } else {
            Usuario.getUsuarios().remove(u);
            Arquivo.gravarAlteracoesUsuarios();
            this.filtraTabelaUsuarios();
        }
    }

    public void trocaMask() {
        if (this.getView().getCb_codigo().getSelectedItem().equals("CNPJ")) {
            maskCpf.uninstall();
            maskCnpj.install(this.getView().getTf_codigo());
        } else {
            maskCnpj.uninstall();
            maskCpf.install(this.getView().getTf_codigo());
        }
    }

    public void cadastrarUsuario() {
        if (!this.getView().getTf_senha().getText().equals(this.getView().getTf_confirmaSenha().getText())) {
            JOptionPane.showMessageDialog(null, "As senhas não batem!");
        }
        Usuario u;
        if (this.getView().getCb_tipoUsuario().isEnabled()) {
            try {
                switch (this.getView().getCb_tipoUsuario().getSelectedItem().toString()) {
                    case "Funcionário":
                        u = new Funcionario(
                                this.getView().getTf_nome().getText(),
                                this.getView().getTf_codigo().getText(),
                                this.getView().getTf_nomeUsuario().getText(),
                                this.getView().getTf_senha().getText(),
                                this.getView().getCb_pergunta().getSelectedItem().toString(),
                                this.getView().getTf_resposta().getText(),
                                Double.parseDouble(this.getView().getTf_salario().getText().replaceAll(",", ".")));
                        break;
                    case "Caixa":
                        u = new Caixa(
                                this.getView().getTf_nome().getText(),
                                this.getView().getTf_codigo().getText(),
                                this.getView().getTf_nomeUsuario().getText(),
                                this.getView().getTf_senha().getText(),
                                this.getView().getCb_pergunta().getSelectedItem().toString(),
                                this.getView().getTf_resposta().getText(),
                                Double.parseDouble(this.getView().getTf_salario().getText().replaceAll(",", ".")));
                        break;
                    case "Cliente":
                        u = new Cliente(
                                this.getView().getTf_nome().getText(),
                                this.getView().getTf_codigo().getText(),
                                this.getView().getTf_nomeUsuario().getText(),
                                this.getView().getTf_senha().getText(),
                                this.getView().getCb_pergunta().getSelectedItem().toString(),
                                this.getView().getTf_resposta().getText());
                        break;
                    default:
                        throw new IllegalArgumentException("O tipo de usário " + this.getView().getCb_tipoUsuario().getSelectedItem().toString() + " é inválido!");
                }
                Historico.addHistoric(new Historico("O usuário " + u.getUser() + " foi criado!"));
                Arquivo.gravarAlteracoesUsuarios();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            u = Usuario.getUsuario(this.getView().getTf_nomeUsuario().getText());
            if (u instanceof Cliente) {
                u.atualizaUsuario(
                        this.getView().getTf_nome().getText(),
                        this.getView().getTf_codigo().getText(),
                        this.getView().getTf_senha().getText(),
                        this.getView().getCb_pergunta().getSelectedItem().toString(),
                        this.getView().getTf_resposta().getText());
            } else {
                ((Funcionario) u).atualizaUsuario(
                        this.getView().getTf_nome().getText(),
                        this.getView().getTf_codigo().getText(),
                        this.getView().getTf_senha().getText(),
                        this.getView().getCb_pergunta().getSelectedItem().toString(),
                        this.getView().getTf_resposta().getText(),
                        Double.parseDouble(this.getView().getTf_salario().getText().replaceAll(",", ".")));
            }
            Historico.addHistoric(new Historico("O usuário " + u.getUser() + " foi alterado!"));
            this.getView().getTf_nomeUsuario().setEnabled(true);
            this.getView().getCb_tipoUsuario().setEnabled(true);
            this.getView().getBtn_cadastrarUsuario().setText("Cadastrar Usuário");
        }
        this.filtraTabelaUsuarios();
        this.redefinirFormUsuario();
    }

    public void redefinirFormUsuario() {
        this.getView().getTf_nomeUsuario().setText("");
        this.getView().getTf_nome().setText("");
        this.getView().getTf_codigo().setText("");
        this.getView().getTf_confirmaSenha().setText("");
        this.getView().getTf_senha().setText("");
        this.getView().getTf_resposta().setText("");
        this.getView().getTf_salario().setText("");
        this.getView().getCb_codigo().setSelectedIndex(0);
        this.getView().getCb_pergunta().setSelectedIndex(0);
    }

    public void cb_tipoUsuarioItemStateChanged() {
        if (this.getView().getCb_tipoUsuario().getSelectedItem().equals("Cliente")) {
            this.getView().getTf_salario().setEnabled(false);
        } else {
            this.getView().getTf_salario().setEnabled(true);
        }
    }

    public PanelCRUD getView() {
        return this.view;
    }

    public void setView(PanelCRUD view) {
        this.view = (PanelCRUD) view;
    }

    public void trocaTela(JPanel novaTela) {
        /* this.getView().getPn_usuarios().removeAll();
        System.out.println(novaTela.toString());
        this.getView().getPn_usuarios().add(novaTela);
        this.getView().getPn_usuarios().repaint();
        this.getView().getPn_usuarios().revalidate();
        System.out.println(" a");*/
    }

    public void iniciaTabelaUsuarios() {
        for (Usuario u : Usuario.getUsuarios()) {
            ((DefaultTableModel) this.getView().getTb_usuarios().getModel()).addRow(new Object[]{u.getUser(), u.getNome()});
        }
    }

    public void filtraTabelaUsuarios() {
        ((DefaultTableModel) this.getView().getTb_usuarios().getModel()).setNumRows(0);
        if (this.getView().getTf_pesquisa().equals("")) {
            this.iniciaTabelaUsuarios();
        } else {
            for (Usuario u : Usuario.getUsuarios()) {
                if (u.getUser().contains(this.getView().getTf_pesquisa().getText())) {
                    ((DefaultTableModel) this.getView().getTb_usuarios().getModel()).addRow(new Object[]{u.getUser(), u.getNome()});
                }
            }
        }
    }

    public void iniciaTabelaProdutos() {
        for (Produto p : Produto.getProdutos()) {
            ((DefaultTableModel) this.getView().getTb_produtos().getModel()).addRow(
                    new Object[]{
                        p.getNome(),
                        String.valueOf(p.getPrecoCompra()).replace(".", ","),
                        String.valueOf(p.getPrecoVenda()).replace(".", ","),
                        String.valueOf(p.getQuantidade()).replace(".", ","),
                        p.getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))});
        }
    }

    public void filtraTabelaProdutos() {
        ((DefaultTableModel) this.getView().getTb_produtos().getModel()).setNumRows(0);
        if (this.getView().getTf_pesquisaProdutos().equals("")) {
            this.iniciaTabelaProdutos();
        } else {
            for (Produto p : Produto.getProdutos()) {
                if (p.getNome().contains(this.getView().getTf_pesquisaProdutos().getText())) {
                    ((DefaultTableModel) this.getView().getTb_produtos().getModel()).addRow(
                            new Object[]{
                                p.getNome(),
                                String.valueOf(p.getPrecoCompra()).replace(".", ","),
                                String.valueOf(p.getPrecoVenda()).replace(".", ","),
                                String.valueOf(p.getQuantidade()).replace(".", ","),
                                p.getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))});
                }
            }
        }
    }

    public void editarUsuarioSelecionado() {
        Usuario u = Usuario.getUsuario(this.getView().getTb_usuarios().getValueAt(this.getView().getTb_usuarios().getSelectedRow(), 0).toString());
        this.getView().getTf_nome().setText(u.getNome());
        this.getView().getCb_codigo().setSelectedIndex((u.getCodigo().length() == 14) ? 0 : 1);
        this.getView().getTf_codigo().setText(u.getCodigo());
        if (u instanceof Funcionario) {
            this.getView().getTf_salario().setEnabled(true);
            this.getView().getTf_salario().setText(Formato.DECIMAL.format(((Funcionario) u).getSalario()));
        } else {
            this.getView().getTf_salario().setEnabled(false);
        }
        this.getView().getTf_nomeUsuario().setText(u.getUser());
        this.getView().getTf_nomeUsuario().setEnabled(false);
        this.getView().getTf_senha().setText(u.getPass());
        this.getView().getTf_confirmaSenha().setText(u.getPass());

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

        this.getView().getTf_resposta().setText(u.getResposta());
        this.getView().getCb_tipoUsuario().setEnabled(false);
        this.getView().getBtn_cadastrarUsuario().setText("Salvar Alterações");
        this.getView().getjTabbedPane1().setSelectedIndex(1);
    }

    public void cb_pergunta_itemStateChanged() {
        if (this.getView().getCb_pergunta().getSelectedIndex() == (this.getView().getCb_pergunta().getItemCount() - 1)) {
            this.getView().getCb_pergunta().setEditable(true);
        } else {
            this.getView().getCb_pergunta().setEditable(false);
        }
    }

    public void cadastrarProduto() {
        Produto p;
        if (this.getView().getCb_tipoProduto().isEnabled()) {
            try {
                if (this.getView().getCb_tipoProduto().getSelectedItem().equals("Unidade")) {
                    p = new ProdutoUnidade(
                            this.getView().getTf_nomeProduto().getText(),
                            Double.parseDouble(this.getView().getTf_precoCompra().getText().replaceAll(",", ".")),
                            Double.parseDouble(this.getView().getTf_precoVenda().getText().replaceAll(",", ".")),
                            Integer.parseInt(this.getView().getTf_quantidade().getText().split(",")[0]),
                            ((this.getView().getTf_validade().getText().equals("  /  /    ")) ? null
                            : LocalDate.parse(this.getView().getTf_validade().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                } else {
                    p = new ProdutoQuilo(
                            this.getView().getTf_nomeProduto().getText(),
                            Double.parseDouble(this.getView().getTf_precoCompra().getText().replaceAll(",", ".")),
                            Double.parseDouble(this.getView().getTf_precoVenda().getText().replaceAll(",", ".")),
                            Double.parseDouble(this.getView().getTf_quantidade().getText().replaceAll(",", ".")),
                            ((this.getView().getTf_validade().getText().equals("  /  /    ")) ? null
                            : LocalDate.parse(this.getView().getTf_validade().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                }
                Historico.addHistoric(new Historico("O produto " + p.getNome() + " foi inserido no banco de dados!"));
                Arquivo.gravarAlteracoesProdutos();
                this.redefinirFormProduto();
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Data de validade inválida!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            try {
                p = Produto.getProduto(this.getView().getTf_nomeProduto().getText(),
                        ((this.getView().getTf_validade().getText().equals("  /  /    ")) ? null
                        : LocalDate.parse(this.getView().getTf_validade().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                p.atualizarProduto(
                        this.getView().getTf_nomeProduto().getText(),
                        Double.parseDouble(this.getView().getTf_precoCompra().getText().replaceAll(",", ".")),
                        Double.parseDouble(this.getView().getTf_precoVenda().getText().replaceAll(",", ".")),
                        (p instanceof ProdutoQuilo)
                                ? Double.parseDouble(this.getView().getTf_quantidade().getText().replaceAll(",", "."))
                                : Integer.parseInt(this.getView().getTf_quantidade().getText().split(",")[0]));
                this.getView().getBtn_cadastrarProduto().setText("Cadastrar Produto");
                this.getView().getCb_tipoProduto().setEnabled(true);
                this.getView().getTf_validade().setEnabled(true);
                this.getView().getTf_nomeProduto().setEnabled(true);
                this.getView().getTf_precoCompra().setEnabled(true);
                this.getView().getTf_precoVenda().setEnabled(true);
                this.redefinirFormProduto();
                this.filtraTabelaProdutos();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public void redefinirFormProduto() {
        if (this.getView().getTf_nomeProduto().isEnabled()) {
            this.getView().getTf_nomeProduto().setText("");
            this.getView().getTf_validade().setText("");
            this.getView().getTf_precoCompra().setText("");
        }
        this.getView().getTf_precoVenda().setText("");
        this.getView().getTf_quantidade().setText("");
    }

    public void editarProdutoSelecionado() {
        try {
            Produto p = Produto.getProduto(
                    this.getView().getTb_produtos().getValueAt(this.getView().getTb_produtos().getSelectedRow(), 0).toString(),
                    LocalDate.parse(this.getView().getTb_produtos().getValueAt(this.getView().getTb_produtos().getSelectedRow(), 4).toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            this.getView().getTf_nomeProduto().setText(p.getNome());
            this.getView().getTf_validade().setText(p.getValidade().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            this.getView().getTf_precoCompra().setText(Formato.DECIMAL.format(p.getPrecoCompra()));
            this.getView().getTf_precoVenda().setText(Formato.DECIMAL.format(p.getPrecoVenda()));
            this.getView().getTf_quantidade().setText(Formato.DECIMAL.format(p.getQuantidade()));
            this.getView().getCb_tipoProduto().setEnabled(false);
            this.getView().getTf_validade().setEnabled(false);
            this.getView().getTf_precoCompra().setEnabled(false);
            //this.getView().getTf_precoVenda().setEnabled(false);
            this.getView().getTf_nomeProduto().setEnabled(false);
            this.getView().getBtn_cadastrarProduto().setText("Salvar Alterações");
            this.getView().getjTabbedPane1().setSelectedIndex(3);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado na conversão da data de válidade! Favor entrar em contato com suporte técnico!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void excluirProdutoSelecionado() {

    }

}
