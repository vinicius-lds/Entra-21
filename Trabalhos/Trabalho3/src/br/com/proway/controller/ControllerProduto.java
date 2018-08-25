package br.com.proway.controller;

import br.com.proway.bean.MarcasBean;
import br.com.proway.bean.ProdutosBean;
import br.com.proway.bean.PromocoesBean;
import br.com.proway.bean.SaidaDosProdutosBean;
import br.com.proway.bean.SetoresBean;
import br.com.proway.dao.Condicao;
import br.com.proway.main.Main;
import br.com.proway.view.Produto;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Vinícius Luis da Silva
 */
public class ControllerProduto {

    private Produto view;
    private SetoresBean sb;
    private MarcasBean mb;
    private ProdutosBean pb;
    private PromocoesBean promob;
    private SaidaDosProdutosBean saidab;

    public ControllerProduto(Produto view) {
        this.view = view;
        this.view.setResizable(false);
        this.view.setLocationRelativeTo(null);
        this.atualizarSetores();
        this.atualizarMarcas();
        this.atualizarProdutos();
        this.atualizarPromocoes();
        this.atualizarSaidas();
        this.view.setVisible(true);
    }

    public void cadastrarSetor() {
        try {
            String[] colunas = new String[]{"nomeDoSetor"};
            String[][] valores = new String[][]{{this.view.getTf_setor().getText()}};
            if (sb == null) {
                Main.CONEXAO.insert("setores", colunas, valores);
            } else {
                Condicao c = new Condicao();
                c.addWhere();
                c.addEquals("idSetor", sb.getIdSetor() + "");
                Main.CONEXAO.update("setores", colunas, valores[0], c);
                this.view.getBtn_cadastrarSetor().setText("Cadastrar");
                this.sb = null;
            }
            this.view.getTf_setor().setText("");
            this.atualizarSetores();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarSetores() {
        try {
            ResultSet rs = Main.CONEXAO.select(new String[]{"idSetor", "nomeDoSetor"}, "setores", null);
            SetoresBean s;
            ((DefaultTableModel) this.view.getTb_setores().getModel()).setRowCount(0);
            this.view.getCb_setorProduto().removeAllItems();
            while (rs.next()) {
                s = new SetoresBean(rs.getInt(1), rs.getString(2));
                ((DefaultTableModel) this.view.getTb_setores().getModel()).addRow(new Object[]{s});
                this.view.getCb_setorProduto().addItem(s);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editarSetor() {
        try {
            this.sb = (SetoresBean) this.view.getTb_setores().getValueAt(this.view.getTb_setores().getSelectedRow(), 0);
            this.view.getTf_setor().setText(this.sb.getNomeDoSetor());
            this.view.getBtn_cadastrarSetor().setText("Salvar Alterações");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluirSetor() {
        try {
            SetoresBean s = (SetoresBean) this.view.getTb_setores().getValueAt(this.view.getTb_setores().getSelectedRow(), 0);
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idSetor", s.getIdSetor() + "");
            Main.CONEXAO.delete("setores", c);
            this.atualizarSetores();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrarMarca() {
        try {
            String[] colunas = new String[]{"nomeMarca"};
            String[][] valores = new String[][]{{this.view.getTf_marca().getText()}};
            if (mb == null) {
                Main.CONEXAO.insert("marcas", colunas, valores);
            } else {
                Condicao c = new Condicao();
                c.addWhere();
                c.addEquals("idMarca", mb.getIdMarca() + "");
                Main.CONEXAO.update("marcas", colunas, valores[0], c);
                this.view.getBtn_cadastrarSetor().setText("Cadastrar");
                this.mb = null;
            }
            this.view.getTf_marca().setText("");
            this.atualizarMarcas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarMarcas() {
        try {
            ResultSet rs = Main.CONEXAO.select(new String[]{"idMarca", "nomeMarca"}, "marcas", null);
            MarcasBean m;
            ((DefaultTableModel) this.view.getTb_marcas().getModel()).setRowCount(0);
            this.view.getCb_marcaProduto().removeAllItems();
            while (rs.next()) {
                m = new MarcasBean(rs.getInt(1), rs.getString(2));
                ((DefaultTableModel) this.view.getTb_marcas().getModel()).addRow(new Object[]{m});
                this.view.getCb_marcaProduto().addItem(m);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editarMarca() {
        try {
            this.mb = (MarcasBean) this.view.getTb_marcas().getValueAt(this.view.getTb_marcas().getSelectedRow(), 0);
            this.view.getTf_marca().setText(this.mb.getNomeMarca());
            this.view.getBtn_cadastrarMarca().setText("Salvar Alterações");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluirMarca() {
        try {
            MarcasBean m = (MarcasBean) this.view.getTb_marcas().getValueAt(this.view.getTb_marcas().getSelectedRow(), 0);
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idMarca", m.getIdMarca() + "");
            Main.CONEXAO.delete("marcas", c);
            this.atualizarMarcas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrarProduto() {
        try {
            String[] colunas = new String[]{"nomeProduto", "valorProduto", "quantidadeProduto", "idMarca", "idSetor"};
            String[][] valores = new String[][]{
                {
                    this.view.getTf_nomeProduto().getText(),
                    this.view.getTf_valorProduto().getText(),
                    this.view.getTf_qtdProduto().getText(),
                    ((MarcasBean) this.view.getCb_marcaProduto().getSelectedItem()).getIdMarca() + "",
                    ((SetoresBean) this.view.getCb_setorProduto().getSelectedItem()).getIdSetor() + ""
                }
            };
            if (pb == null) {
                Main.CONEXAO.insert("produtos", colunas, valores);
            } else {
                Condicao c = new Condicao();
                c.addWhere();
                c.addEquals("idProduto", pb.getIdProduto() + "");
                Main.CONEXAO.update("produtos", colunas, valores[0], c);
                this.view.getBtn_cadastrarProduto().setText("Cadastrar");
                this.pb = null;
            }
            this.view.getTf_nomeProduto().setText("");
            this.view.getTf_valorProduto().setText("");
            this.view.getTf_qtdProduto().setText("");
            this.view.getCb_marcaProduto().setSelectedItem(0);
            this.view.getCb_setorProduto().setSelectedItem(0);
            this.atualizarProdutos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarProdutos() {
        try {
            ResultSet rs = Main.CONEXAO.select(new String[]{"idProduto", "nomeProduto", "valorProduto", "quantidadeProduto", "idMarca", "idSetor"}, "produtos", null);
            ProdutosBean s;
            ((DefaultTableModel) this.view.getTb_setores().getModel()).setRowCount(0);
            this.view.getCb_produtosSaida().removeAllItems();
            this.view.getCb_proPromo().removeAllItems();
            ((DefaultTableModel) this.view.getTb_produtos().getModel()).setRowCount(0);
            while (rs.next()) {
                s = new ProdutosBean(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                ((DefaultTableModel) this.view.getTb_produtos().getModel()).addRow(new Object[]{s.getIdProduto(), s.getNomeProduto(), s.getValorProduto(), s.getQuantidadeProduto()});
                this.view.getCb_produtosSaida().addItem(s);
                this.view.getCb_proPromo().addItem(s);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editarProduto() {
        try {
            int idProduto = (int) this.view.getTb_produtos().getValueAt(this.view.getTb_produtos().getSelectedRow(), 0);
            String[] colunas = new String[]{"idProduto", "nomeProduto", "valorProduto", "quantidadeProduto", "idMarca", "idSetor"};
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idProduto", idProduto + "");
            ResultSet rs = Main.CONEXAO.select(colunas, "produtos", c);
            while(rs.next()) {
                this.pb = new ProdutosBean(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(5), rs.getInt(6), rs.getInt(4));
            }
            rs.close();
            this.view.getTf_nomeProduto().setText(this.pb.getNomeProduto());
            this.view.getTf_qtdProduto().setText(this.pb.getQuantidadeProduto() + "");
            this.view.getTf_valorProduto().setText(this.pb.getValorProduto() + "");
            /*
            c = new Condicao();
            c.addWhere();
            c.addEquals("idSetor", this.pb.getIdSetor() + "");
            rs = Main.CONEXAO.select(new String[] {"idSetor", "nomeDoSetor"}, "setores", c);
            SetoresBean s = null;
            while(rs.next()) {
                s = new SetoresBean(rs.getInt(1), rs.getString(2));
            }
            
            c = new Condicao();
            c.addWhere();
            c.addEquals("idMarca", this.pb.getIdMarca() + "");
            rs = Main.CONEXAO.select(new String[] {"idMarca", "nomeMarca"}, "marcas", c);
            MarcasBean m = null;
            while(rs.next()) {
                m = new MarcasBean(rs.getInt(1), rs.getString(2));
            }
            
            this.view.getCb_setorProduto().setSelectedItem(s);
            this.view.getCb_marcaProduto().setSelectedItem(m);*/
            this.view.getBtn_cadastrarProduto().setText("Salvar Alterações");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluirProduto() {
        try {
            int idProduto = (int) this.view.getTb_produtos().getValueAt(this.view.getTb_produtos().getSelectedRow(), 0);
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idProduto", idProduto + "");
            Main.CONEXAO.delete("produtos", c);
            this.atualizarProdutos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cadastrarPromo() {
        try {
            String[] colunas = new String[]{"percentualDesconto", "idProduto"};
            String[][] valores = new String[][]{{this.view.getTf_desconto().getText(), ((ProdutosBean)this.view.getCb_proPromo().getSelectedItem()).getIdProduto() + ""}};
            if(Double.parseDouble(this.view.getTf_desconto().getText()) < 0 || Double.parseDouble(this.view.getTf_desconto().getText()) > 99) {
                JOptionPane.showMessageDialog(null, "Valor inválido!");
                return;
            }
            if (promob == null) {
                Condicao c = new Condicao();
                c.addWhere();
                c.addEquals("idProduto", ((ProdutosBean)this.view.getCb_proPromo().getSelectedItem()).getIdProduto() + "");
                ResultSet rs = Main.CONEXAO.select(null, "promocoes", c);
                while(rs.next()) {
                    rs.close();
                    JOptionPane.showMessageDialog(null, "Já exite uma promoção com esse produtos");
                    return;
                }
                
                Main.CONEXAO.insert("promocoes", colunas, valores);
            } else {
                Condicao c = new Condicao();
                c.addWhere();
                c.addEquals("idPromocao", promob.getIdPromocao()+ "");
                Main.CONEXAO.update("promocoes", colunas, valores[0], c);
                this.view.getBtn_cadastrarPromo().setText("Cadastrar");
                this.promob = null;
            }
            this.view.getTf_desconto().setText("");
            this.view.getCb_proPromo().setSelectedIndex(0);
            this.atualizarPromocoes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarPromocoes() {
        try {
            ResultSet rs = Main.CONEXAO.select(null, "promocoes", null);
            PromocoesBean m;
            ((DefaultTableModel) this.view.getTb_promo().getModel()).setRowCount(0);
            while (rs.next()) {
                m = new PromocoesBean(rs.getInt(1), rs.getInt(2), rs.getDouble(3));
                ((DefaultTableModel) this.view.getTb_promo().getModel()).addRow(new Object[]{m});
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editarPromo() {
        try {
            this.promob = (PromocoesBean) this.view.getTb_promo().getValueAt(this.view.getTb_promo().getSelectedRow(), 0);
            this.view.getTf_desconto().setText(this.promob.getPercentualDesconto() + "");
            this.view.getBtn_cadastrarMarca().setText("Salvar Alterações");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluirPromo() {
        try {
            PromocoesBean m = (PromocoesBean) this.view.getTb_promo().getValueAt(this.view.getTb_promo().getSelectedRow(), 0);
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idPromocao", m.getIdPromocao()+ "");
            Main.CONEXAO.delete("promocoes", c);
            this.atualizarPromocoes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cadastrarSaida() {
        try {
            String[] colunas = new String[]{"valorSaida", "quantidadeSaida", "idProduto"};
            ProdutosBean prod = ((ProdutosBean)this.view.getCb_proPromo().getSelectedItem());
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idProduto", prod.getIdProduto() + "");
            System.out.println("prod.getIdProduto() " + prod.getValorProduto());
            ResultSet rs = Main.CONEXAO.select(null, "promocoes", c);
            double desconto = 0.0;
            while(rs.next()) {
                desconto = rs.getDouble("percentualDesconto");
            }
            desconto /= 100;
            String[][] valores = new String[][]{{
                (prod.getValorProduto() - (prod.getValorProduto() * desconto)) + "", 
                this.view.getTf_qtdSaida().getText(),
                ((ProdutosBean)this.view.getCb_produtosSaida().getSelectedItem()).getIdProduto() + ""
            }};
            if(prod.getQuantidadeProduto() < Integer.parseInt(valores[0][1])) {
                JOptionPane.showMessageDialog(null, "Não tem essa quantidade de produtos");
                return;
            }
            Main.CONEXAO.insert("saidaDosProdutos", colunas, valores);
            this.view.getTf_qtdSaida().setText("");
            this.view.getCb_produtosSaida().setSelectedIndex(0);
            this.view.getCb_proPromo().setSelectedIndex(0);
            this.atualizarSaidas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarSaidas() {
        try {
            ResultSet rs = Main.CONEXAO.select(null, "saidaDosProdutos", null);
            SaidaDosProdutosBean m;
            ((DefaultTableModel) this.view.getTb_saidaProdutos().getModel()).setRowCount(0);
            while (rs.next()) {
                m = new SaidaDosProdutosBean(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4));
                ((DefaultTableModel) this.view.getTb_saidaProdutos().getModel()).addRow(new Object[]{m.getIdSaida(), m.getValorSaida()});
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
