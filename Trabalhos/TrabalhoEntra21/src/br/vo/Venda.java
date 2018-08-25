/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo;

import br.util.Formato;

/**
 *
 * @author 104884
 */
public class Venda {
    
    private String cliente;
    private String vendedor;
    private double valor;
    
    public Venda(double valor, String cliente, String vendedor) {
        this.setCliente(cliente);
        this.setValor(valor);
        this.setVendedor(vendedor);
        Financeiro.getInstance().incSaldo(valor, "Venda no valor de " + Formato.DECIMAL.format(valor) + " feita por " + vendedor + " para o cliente " + cliente + ".");
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
