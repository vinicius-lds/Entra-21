package br.com.proway.controller;

import br.com.proway.bean.CargosBean;
import br.com.proway.bean.ContatosBean;
import br.com.proway.bean.EnderecosBean;
import br.com.proway.bean.PessoasBean;
import br.com.proway.dao.Condicao;
import br.com.proway.main.Main;
import br.com.proway.util.StringUtil;
import br.com.proway.view.Contato;
import br.com.proway.view.Endereco;
import br.com.proway.view.Usuario;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Vinícius Luis da Silva
 */
public class ControllerUsuario {

    private Usuario view;
    private PessoasBean pessoaAtual;
    private CargosBean cb = null;

    public ControllerUsuario(Usuario view) {
        this.view = view;
        this.view.setResizable(false);
        this.view.setLocationRelativeTo(null);
        this.view.setTitle("Usuario");
        this.view.getList_enderecos().setModel(new DefaultListModel<EnderecosBean>());
        this.view.getList_contatos().setModel(new DefaultListModel<ContatosBean>());
        this.atualizarClientes();
        this.atualizarFuncionarios();
        this.atualizarCargos();
        this.view.setVisible(true);
    }

    public void cadastrarCliente() {
        try {
            String[] colunas = new String[]{"nomePessoa", "mascPessoa", "nascPessoa"};
            String[][] valores = new String[][]{
                {
                    this.view.getTf_nomeCliente().getText(),
                    (this.view.getCb_sexoCliente().getSelectedItem().equals("Masculino") ? "1" : "0"),
                    StringUtil.padronizarData(this.view.getTf_nascCliente().getText())
                }
            };
            Main.CONEXAO.insert("pessoas", colunas, valores);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.limparFormCliente();
        this.atualizarClientes();
    }

    public void cadastrarFuncionario() {
        try {
            String[] colunas = new String[]{"nomePessoa", "mascPessoa", "nascPessoa", "idCargo"};
            String[][] valores = new String[][]{
                {
                    this.view.getTf_nomeFuncionario().getText(),
                    (this.view.getCb_sexoFuncionario().getSelectedItem().equals("Masculino") ? "1" : "0"),
                    StringUtil.padronizarData(this.view.getTf_nascFuncionario().getText()),
                    ((CargosBean) this.view.getCb_cargoFuncionario().getSelectedItem()).getIdCargo() + ""
                }
            };
            Main.CONEXAO.insert("pessoas", colunas, valores);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.limparFormFuncionario();
        this.atualizarFuncionarios();
    }

    public void cadastrarCargo() {
        try {
            String[] colunas = new String[]{"nomeCargo", "salarioCargo"};
            String[][] valores = new String[][]{{this.view.getTf_cargo().getText(), this.view.getTf_salario().getText()}};
            if (this.cb == null) {
                Main.CONEXAO.insert("cargos", colunas, valores);
            } else {
                Condicao c = new Condicao();
                c.addWhere();
                c.addEquals("idCargo", this.cb.getIdCargo() + "");
                this.cb = null;
                this.view.getBtn_cadastrarCargo().setText("Cadastrar");
                Main.CONEXAO.update("cargos", colunas, valores[0], c);
            }
            this.view.getTf_cargo().setText("");
            this.view.getTf_salario().setText("");
            this.atualizarCargos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editarFuncionario() {
        try {
            String[] colunas = new String[]{"nomePessoa", "mascPessoa", "nascPessoa", "idCargo"};
            String[] valores = new String[]{
                this.view.getTf_nomeFuncionario().getText(),
                (this.view.getCb_sexoFuncionario().getSelectedIndex() == 0 ? "1" : "0"),
                StringUtil.padronizarData(this.view.getTf_nascFuncionario().getText()),
                ((CargosBean) this.view.getCb_cargoFuncionario().getSelectedItem()).getIdCargo() + ""
            };
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idPessoa", this.pessoaAtual.getIdPessoa() + "");
            Main.CONEXAO.update("pessoas", colunas, valores, c);
            this.limparFormFuncionario();
            this.atualizarFuncionarios();
            this.view.getBtn_cadastrarFuncionario().setEnabled(true);
            this.view.getBtn_salvarFuncionario().setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editarCliente() {
        try {
            String[] colunas = new String[]{"nomePessoa", "mascPessoa", "nascPessoa"};
            String[] valores = new String[]{
                this.view.getTf_nomeCliente().getText(),
                (this.view.getCb_sexoCliente().getSelectedIndex() == 0 ? "1" : "0"),
                StringUtil.padronizarData(this.view.getTf_nascCliente().getText())
            };
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idPessoa", this.pessoaAtual.getIdPessoa() + "");
            Main.CONEXAO.update("pessoas", colunas, valores, c);
            this.limparFormCliente();
            this.atualizarClientes();
            this.view.getBtn_cadastrarCliente().setEnabled(true);
            this.view.getBtn_salvarCliente().setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void limparFormCliente() {
        this.view.getTf_nomeCliente().setText("");
        this.view.getCb_sexoCliente().setSelectedItem(0);
        this.view.getTf_nascCliente().setText("");
        this.view.getTf_nomeCliente().requestFocus();
    }

    public void limparFormFuncionario() {
        this.view.getTf_nomeFuncionario().setText("");
        this.view.getCb_sexoFuncionario().setSelectedItem(0);
        this.view.getCb_cargoFuncionario().setSelectedItem(0);
        this.view.getTf_nascFuncionario().setText("");
        this.view.getTf_nomeFuncionario().requestFocus();
    }

    public void editarEndereco() {
        EnderecosBean eb = this.view.getList_enderecos().getSelectedValue();
        Endereco e = new Endereco(eb, this);
    }

    public void editarContato() {
        ContatosBean cb = this.view.getList_contatos().getSelectedValue();
        Contato c = new Contato(cb, this);
    }

    public void excluirEndereco() {
        try {
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idEndereco", this.view.getList_enderecos().getSelectedValue().getIdEndereco() + "");
            Main.CONEXAO.delete("enderecos", c);
            this.buscarEnderecos(this.pessoaAtual.getIdPessoa());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluirContato() {
        try {
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idContato", this.view.getList_contatos().getSelectedValue().getIdContato() + "");
            Main.CONEXAO.delete("contatos", c);
            this.buscarContatos(this.pessoaAtual.getIdPessoa());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editarCargo() {
        try {
            this.cb = (CargosBean) this.view.getTb_cargos().getValueAt(this.view.getTb_cargos().getSelectedRow(), 0);
            this.view.getTf_cargo().setText(cb.getNomeCargo());
            this.view.getTf_salario().setText(cb.getSalarioCargo() + "");
            this.view.getBtn_cadastrarCargo().setText("SalvarAlterações");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarCargos() {
        try {
            String[] colunas = new String[]{"idCargo", "nomeCargo", "salarioCargo"};
            ResultSet rs = Main.CONEXAO.select(colunas, "cargos", null);
            JComboBox cargos = this.view.getCb_cargoFuncionario();
            cargos.removeAllItems();
            ((DefaultTableModel) this.view.getTb_cargos().getModel()).setRowCount(0);
            CargosBean cb;
            while (rs.next()) {
                cb = new CargosBean(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                cargos.addItem(cb);
                ((DefaultTableModel) this.view.getTb_cargos().getModel()).addRow(new Object[]{cb});
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarClientes() {
        try {
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idCargo", null);
            ResultSet rs = Main.CONEXAO.select(new String[]{"idPessoa", "nomePessoa"}, "pessoas", c);
            ((DefaultTableModel) this.view.getTb_clientes().getModel()).setRowCount(0);
            while (rs.next()) {
                ((DefaultTableModel) this.view.getTb_clientes().getModel()).addRow(new Object[]{rs.getInt(1), rs.getString(2)});
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar o clientes na tabela!");
        }
    }

    public void atualizarFuncionarios() {
        try {
            Condicao c = new Condicao();
            c.addInnerJoin("pessoas", "cargos", "idCargo");
            ResultSet rs = Main.CONEXAO.select(new String[]{"idPessoa", "nomePessoa", "nomeCargo"}, "pessoas", c);
            ((DefaultTableModel) this.view.getTb_funcionarios().getModel()).setRowCount(0);
            while (rs.next()) {
                ((DefaultTableModel) this.view.getTb_funcionarios().getModel()).addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3)});
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar o clientes na tabela!");
        }
    }

    public void vizualizarCliente() {
        int idCliente = (int) this.view.getTb_clientes().getValueAt(this.view.getTb_clientes().getSelectedRow(), 0);
        this.buscarCliente(idCliente);
        this.buscarEnderecos(idCliente);
        this.buscarContatos(idCliente);
        this.setEdicao(true);
        this.view.getjTabbedPane1().setSelectedIndex(0);
    }

    public void vizualizarFuncionario() {
        int idFuncionario = (int) this.view.getTb_funcionarios().getValueAt(this.view.getTb_funcionarios().getSelectedRow(), 0);
        this.buscarFuncionario(idFuncionario);
        this.buscarEnderecos(idFuncionario);
        this.buscarContatos(idFuncionario);
        this.setEdicao(true);
        this.view.getjTabbedPane1().setSelectedIndex(0);
    }

    public void excluirCliente() {
        try {
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idPessoa", this.pessoaAtual.getIdPessoa() + "");
            Main.CONEXAO.delete("enderecos", c);
            Main.CONEXAO.delete("contatos", c);
            Main.CONEXAO.delete("pessoas", c);
            this.atualizarClientes();
            this.atualizarFuncionarios();
            this.limparPrincipal();
            this.setEdicao(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void adicionarContato() {
        new Contato(this.pessoaAtual.getIdPessoa(), this);
    }

    public void adicionarEndereco() {
        new Endereco(this.pessoaAtual.getIdPessoa(), this);
    }

    public void editarPessoa() {
        try {
            if (pessoaAtual.getIdCargo() > 0) {
                //Funcionario
                this.view.getTf_nomeFuncionario().setText(this.pessoaAtual.getNomePessoa());
                this.view.getTf_nascFuncionario().setText(StringUtil.dateToString(this.pessoaAtual.getNascPessoa()));
                this.view.getCb_sexoFuncionario().setSelectedIndex((pessoaAtual.isMascPessoa()) ? 0 : 1);
                Condicao c = new Condicao();
                c.addWhere();
                c.addEquals("idCargo", this.pessoaAtual.getIdCargo() + "");
                ResultSet rs = Main.CONEXAO.select(new String[]{"nomeCargo"}, "cargos", c);
                String cargo = null;
                while (rs.next()) {
                    cargo = rs.getString(1);
                }
                this.view.getCb_cargoFuncionario().setSelectedItem(cargo);
                this.view.getBtn_cadastrarFuncionario().setEnabled(false);
                this.view.getBtn_salvarFuncionario().setEnabled(true);
            } else {
                //Cliente
                this.view.getTf_nomeCliente().setText(this.pessoaAtual.getNomePessoa());
                this.view.getTf_nascCliente().setText(StringUtil.dateToString(this.pessoaAtual.getNascPessoa()));
                this.view.getCb_sexoCliente().setSelectedIndex((pessoaAtual.isMascPessoa()) ? 0 : 1);
                this.view.getBtn_salvarCliente().setEnabled(true);
                this.view.getBtn_cadastrarCliente().setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setEdicao(boolean b) {
        this.view.getBtn_editar().setEnabled(b);
        this.view.getBtn_deletar().setEnabled(b);
        this.view.getBtn_adcContato().setEnabled(b);
        this.view.getBtn_adcEndereco().setEnabled(b);
    }

    private void limparPrincipal() {
        this.view.getLbl_cliente().setText("");
        ((DefaultListModel) this.view.getList_contatos().getModel()).clear();
        ((DefaultListModel) this.view.getList_enderecos().getModel()).clear();
    }

    private void buscarCliente(int idCliente) {
        try {
            Condicao condicao = new Condicao();
            condicao.addWhere();
            condicao.addEquals("idPessoa", idCliente + "");
            ResultSet rs = Main.CONEXAO.select(null, "pessoas", condicao);
            while (rs.next()) {
                pessoaAtual = new PessoasBean(
                        idCliente,
                        rs.getString(2),
                        rs.getBoolean(3),
                        rs.getDate(4)
                );
            }
            GregorianCalendar nascPessoa = new GregorianCalendar();
            nascPessoa.setTime(pessoaAtual.getNascPessoa());
            int idade = new GregorianCalendar().get(Calendar.YEAR) - nascPessoa.get(Calendar.YEAR);
            String str = "<html>Nome: " + pessoaAtual.getNomePessoa()
                    + "<br>Sexo: " + (pessoaAtual.isMascPessoa() ? "Masculino" : "Feminino")
                    + "<br>Idade: " + idade
                    + " anos.</html>";
            this.view.getLbl_cliente().setText(str);
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buscarFuncionario(int idFuncionario) {
        try {
            Condicao condicao = new Condicao();
            condicao.addWhere();
            condicao.addEquals("idPessoa", idFuncionario + "");
            ResultSet rs = Main.CONEXAO.select(null, "pessoas", condicao);
            while (rs.next()) {
                pessoaAtual = new PessoasBean(
                        idFuncionario,
                        rs.getString(2),
                        rs.getBoolean(3),
                        rs.getDate(4),
                        rs.getInt(5)
                );
            }
            condicao = new Condicao();
            condicao.addWhere();
            condicao.addEquals("idCargo", pessoaAtual.getIdCargo() + "");
            rs = Main.CONEXAO.select(new String[]{"nomeCargo"}, "cargos", condicao);
            String cargo = null;
            while (rs.next()) {
                cargo = rs.getString(1);
            }
            GregorianCalendar nascPessoa = new GregorianCalendar();
            nascPessoa.setTime(pessoaAtual.getNascPessoa());
            int idade = new GregorianCalendar().get(Calendar.YEAR) - nascPessoa.get(Calendar.YEAR);
            String str = "<html>Nome: " + pessoaAtual.getNomePessoa()
                    + "<br>Sexo: " + (pessoaAtual.isMascPessoa() ? "Masculino" : "Feminino")
                    + "<br>Idade: " + idade
                    + " anos"
                    + "<br>Cargo: " + cargo;
            this.view.getLbl_cliente().setText(str);
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarEnderecos(int idPessoa) {
        try {
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idPessoa", idPessoa + "");
            ResultSet rs = Main.CONEXAO.select(null, "enderecos", c);
            EnderecosBean e;
            ((DefaultListModel) this.view.getList_enderecos().getModel()).clear();
            while (rs.next()) {
                e = new EnderecosBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
                ((DefaultListModel) this.view.getList_enderecos().getModel()).addElement(e);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buscarContatos(int idPessoa) {
        try {
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idPessoa", idPessoa + "");
            ResultSet rs = Main.CONEXAO.select(null, "contatos", c);
            ContatosBean cb;
            ((DefaultListModel) this.view.getList_contatos().getModel()).clear();
            while (rs.next()) {
                cb = new ContatosBean(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                ((DefaultListModel) this.view.getList_contatos().getModel()).addElement(cb);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
