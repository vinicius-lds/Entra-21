/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo.financeiro;

import br.util.Arquivo;
import java.io.Serializable;

/**
 *
 * @author vinic
 */
public class Dispesa implements Serializable {
    
    private double valor;
    private String descricao;
    
    public Dispesa(String descricao, double valor) {
        this.setValor(valor);
        this.setDescricao(descricao);
        Arquivo.gravarAlteracoesDispesa();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if(valor < 0) {
            throw new IllegalArgumentException("Valor " + valor + " é inválido!");
        }
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if(descricao.equals("")) {
            throw new IllegalArgumentException("Descrição inválida!");
        }
        this.descricao = descricao;
    }
    
}
