/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo.produto;

import br.util.Formato;
import br.util.Arquivo;
import br.vo.Financeiro;
import br.vo.financeiro.Dispesa;
import java.time.LocalDate;

/**
 *
 * @author vinic
 */
public class ProdutoUnidade extends Produto {

    private int quantidade;
    
    public ProdutoUnidade(String nome, double precoCompra, double precoVenda, int quantidade, LocalDate validade) {
        super(nome, precoCompra, precoVenda, validade);
        this.setQuantidade(quantidade);
        Financeiro.getInstance().getDispesas().add(new Dispesa(("Foi gasto " + (precoCompra * quantidade) + " em " + nome), precoCompra * quantidade));
    }

    public Object getQuantidade() {
        return quantidade;
    }
    
    public void atualizarProduto(String nome, double precoCompra, double precoVenda, Object quantidade) {
        this.setNome(nome);
        this.setPrecoCompra(precoCompra);
        this.setPrecoVenda(precoVenda);
        this.setQuantidade(quantidade);
        Arquivo.gravarAlteracoesProdutos();
    }

    public void setQuantidade(Object quantidade) {
        if(((Number)quantidade).intValue() < 0) {
            throw new IllegalArgumentException("A quantidade " + quantidade + " é inválida!");
        }
        if(((Number)quantidade).intValue() < (int)this.getQuantidade()) {
            throw new IllegalArgumentException("Não é possível diminuir a quantidade de items que estão em estoque!");
        }
        int quantidaAMais = ((Number)quantidade).intValue() - (int)this.getQuantidade();
        this.quantidade = ((Number)quantidade).intValue();
        Financeiro.getInstance().decSaldo(quantidaAMais, "Foram comprados " + quantidaAMais + " unidades de " + this.getNome() + " por R$" + Formato.DECIMAL.format(this.getPrecoCompra() * quantidaAMais) + ".");
    }

    public void decQuantidade(String quantidade) {
        this.quantidade -= Integer.parseInt(quantidade);
    }
    
}
