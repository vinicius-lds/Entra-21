/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.util.Formato;
import br.util.PedeDados;
import br.view.PanelVendas;
import br.vo.Venda;
import br.vo.pessoa.Usuario;
import br.vo.produto.Produto;
import br.vo.produto.ProdutoUnidade;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author vinic
 */
public class ControllerVendas {

    private PanelVendas view;
    private MaskFormatter maskCpf;
    private MaskFormatter maskCnpj;
    private double precoCompra = 0.0;

    public ControllerVendas() {
        try {
            this.maskCpf = new MaskFormatter("###.###.###-##");
            this.maskCnpj = new MaskFormatter("##.###.###/####-##");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void excluirProduto() {
        String produto = (String)this.getView().getTb_carrinho().getValueAt(this.getView().getTb_carrinho().getSelectedRow(), 0);
        double preco = (double)this.getView().getTb_carrinho().getValueAt(this.getView().getTb_carrinho().getSelectedRow(), 2);
        String validade = (String)this.getView().getTb_carrinho().getValueAt(this.getView().getTb_carrinho().getSelectedRow(), 3);
        Produto p = Produto.getProduto(produto, LocalDate.parse(validade, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.getView().getCb_produtos().addItem(p);
        ((DefaultTableModel)this.getView().getTb_carrinho().getModel()).removeRow(this.getView().getTb_carrinho().getSelectedRow());
        this.precoCompra -= preco;
        this.atualizaLabel();
    }
    
    public void finalizarCompra() {
        if((this.getView().getTf_codigo().getText().length() != 14 && this.getView().getTf_codigo().getText().length() != 18)
                || this.getView().getCb_cliente().getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Você deve preencher os campos de Código e Nome!");
        } else {
            new Venda(
                    precoCompra, 
                    this.getView().getCb_cliente().getSelectedItem().toString(), 
                    this.getView().getRoot().getController().getSessao().getUsuario().getNome()
            );
            for(int i = 0; i < ((DefaultTableModel)this.getView().getTb_carrinho().getModel()).getRowCount(); i++) {
                Produto p = Produto.getProduto(
                        ((DefaultTableModel)this.getView().getTb_carrinho().getModel()).getValueAt(i, 0).toString(), 
                        LocalDate.parse(
                                (((DefaultTableModel)this.getView().getTb_carrinho().getModel()).getValueAt(i, 3).toString()), 
                                DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        ));
                p.decQuantidade(((DefaultTableModel)this.getView().getTb_carrinho().getModel()).getValueAt(i, 1).toString());
            }
            this.getView().getRoot().getController().getView().getjButton1().getActionListeners()[0].actionPerformed(null);
            this.getView().getRoot().getController().getView().getjButton2().getActionListeners()[0].actionPerformed(null);
        }
    }

    public PanelVendas getView() {
        return view;
    }

    public void setView(PanelVendas view) {
        this.view = view;
    }
    
    public void cb_clientes_carregarClientes() {
        this.getView().getCb_cliente().removeAllItems();
        this.getView().getCb_cliente().addItem("");
        if(this.getView().getCb_cliente().getSelectedIndex() == 0) {
            this.getView().getCb_cliente().setEditable(true);
        }
        for(Usuario u: Usuario.getUsuarios()) {
            this.getView().getCb_cliente().addItem(u.getUser());
        }
    }
    
    public void addCarinho() {
        Produto p = (Produto)this.getView().getCb_produtos().getSelectedItem();
        double preco;
        if(p instanceof ProdutoUnidade) {
            int qtd = PedeDados.getInt("Quantidade", 1, ((int) p.getQuantidade()));
            preco = qtd * p.getPrecoVenda();
            ((DefaultTableModel)this.getView().getTb_carrinho().getModel()).addRow(
                new Object[] {
                    p.getNome(),
                    qtd,
                    preco,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy").format(p.getValidade())
                });
        } else {
            double qtd = PedeDados.getDouble("Quantidade", 1, ((double) p.getQuantidade()));
            preco = qtd * p.getPrecoVenda();
            ((DefaultTableModel)this.getView().getTb_carrinho().getModel()).addRow(
                new Object[] {
                    p.getNome(),
                    qtd,
                    preco,
                    DateTimeFormatter.ofPattern("dd/MM/yyyy").format(p.getValidade())
                });
        }
        this.precoCompra += preco;
        this.atualizaLabel();
        this.getView().getCb_produtos().removeItem(p);
    }
    
    private void atualizaLabel() {
        this.getView().getjLabel3().setText("R$" + Formato.DECIMAL.format(precoCompra));
    }
    
    public void cb_produtos_carregarProdutos() {
        this.getView().getCb_produtos().removeAllItems();
        for(Produto p: Produto.getProdutos()) {
            this.getView().getCb_produtos().addItem(p);
        }
    }
    
    public void cb_clientes_itemStateChanged() {
        System.out.println(this.getView().getCb_cliente().getSelectedIndex());
        if (this.getView().getCb_cliente().getSelectedIndex() > 0) {
            this.getView().getCb_cliente().setEditable(false);
            this.getView().getTf_codigo().setEditable(false);
            this.getView().getCb_codigo().setEnabled(false);
            Usuario u = Usuario.getUsuario(this.getView().getCb_cliente().getSelectedItem().toString());
            if(u.getCodigo().length() == 14) {
                this.getView().getCb_codigo().setSelectedIndex(0);
            } else {
                this.getView().getCb_codigo().setSelectedIndex(1);
            }
            this.getView().getTf_codigo().setText(u.getCodigo());
        } else {
            this.getView().getCb_codigo().setSelectedIndex(0);
            this.getView().getCb_codigo().setEnabled(true);
            this.getView().getTf_codigo().setEditable(true);
            this.getView().getCb_cliente().setEditable(true);
        }
    }
    
    public void cb_codigo_itemStateChanged() {
        if (this.getView().getCb_codigo().getSelectedItem().equals("CNPJ")) {
            maskCpf.uninstall();
            maskCnpj.install(this.getView().getTf_codigo());
        } else {
            maskCnpj.uninstall();
            maskCpf.install(this.getView().getTf_codigo());
        }
    }
    
    public void atualizaCbClientes() {
        Usuario u = Usuario.getPorCodigo(this.getView().getTf_codigo().getText());
        if(u != null) {
            this.getView().getCb_cliente().setSelectedItem(u.getUser());
        } else {
            this.getView().getCb_cliente().setSelectedIndex(0);
        }
    }
    
}
