/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.util.Formato;
import br.util.PedeDados;
import br.view.PanelFinanceiro;
import br.vo.Financeiro;
import br.vo.financeiro.Dispesa;
import br.vo.financeiro.Receita;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinic
 */
public class ControllerFinanceiro {
    
    private PanelFinanceiro view;

    public PanelFinanceiro getView() {
        return view;
    }

    public void setView(PanelFinanceiro view) {
        this.view = view;
    }
    
    public void iniciaTabela() {
        this.iniciaDispesas();
        this.iniciaReceitas();
    }
    
    public void atualizaSaldo() {
        if(Financeiro.getInstance().getSaldo() >= 0) {
            this.getView().getjLabel1().setText("R$" + Formato.DECIMAL.format(Financeiro.getInstance().getSaldo()));
            this.getView().getjLabel1().setForeground(Color.GREEN);
        } else {
            this.getView().getjLabel1().setText("R$" + Formato.DECIMAL.format(Financeiro.getInstance().getSaldo() * (-1)));
            this.getView().getjLabel1().setForeground(Color.RED);
        }
    }
    
    public void injetarCapital() {
        double aux = PedeDados.getDouble("Valor a ser investido", 0.01, Double.MAX_VALUE);
        Financeiro.getInstance().incSaldo(aux, "Foram investido R$" + Formato.DECIMAL.format(aux) + ".");
        this.filtraTabela();
        this.atualizaSaldo();
    }
    
    public void filtraTabela() {
        ((DefaultTableModel)this.getView().getjTable1().getModel()).setRowCount(0);
        if(this.getView().getCb_financeiro().getSelectedItem().equals("Tudo")) {
            iniciaTabela();
        } else if(this.getView().getCb_financeiro().getSelectedItem().equals("Dispesas")) {
            iniciaDispesas();
        } else {
            iniciaReceitas();
        }
    }
    
    private void iniciaDispesas() {
        for(Dispesa d: Financeiro.getInstance().getDispesas()) {
            ((DefaultTableModel)this.getView().getjTable1().getModel()).addRow(new Object[] {"Dispesa", d.getDescricao(), "R$" + Formato.DECIMAL.format(d.getValor())});
        }
    }
    
    private void iniciaReceitas() {
        for(Receita r: Financeiro.getInstance().getReceitas()) {
            ((DefaultTableModel)this.getView().getjTable1().getModel()).addRow(new Object[] {"Receita", r.getDescricao(), "R$" + Formato.DECIMAL.format(r.getValor())});
        }
    }
    
}
