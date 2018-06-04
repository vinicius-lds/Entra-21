/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo;

import br.vo.Historico;
import br.vo.financeiro.Dispesa;
import br.vo.financeiro.Receita;
import java.util.ArrayList;

/**
 *
 * @author 104884
 */
public class Financeiro {

    private static Financeiro obj = null;
    
    public static Financeiro getInstance() {
        if(obj == null) {
            obj = new Financeiro();
        }
        return obj;
    }
    
    private Financeiro() {}
    
    private double saldo = 0.0;
    private ArrayList<Dispesa> dispesas = new ArrayList<>();
    private ArrayList<Receita> receitas = new ArrayList<>();

    public double getSaldo() {
        return saldo;
    }
    
    public void incSaldo(double valor, String descricao) {
        this.saldo += valor;
        Historico.addHistoric(new Historico(descricao));
        this.receitas.add(new Receita(descricao, valor));
    }
    
    public void decSaldo(double valor, String descricao) {
        this.saldo -= valor;
        Historico.addHistoric(new Historico(descricao));
        this.dispesas.add(new Dispesa(descricao, valor));
    }

    public ArrayList<Dispesa> getDispesas() {
        return dispesas;
    }

    public void setDispesas(ArrayList<Dispesa> dispesas) {
        this.dispesas = dispesas;
    }

    public ArrayList<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(ArrayList<Receita> receitas) {
        this.receitas = receitas;
    }
    
    
    
}
