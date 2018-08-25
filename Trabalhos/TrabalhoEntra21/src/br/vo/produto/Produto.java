package br.vo.produto;

import br.vo.Financeiro;
import br.vo.financeiro.Dispesa;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author 104884
 */
public abstract class Produto implements Serializable {
    
    private static ArrayList<Produto> produtosCadastrados = new ArrayList<Produto>();
    
    public static boolean existeProduto(String nome) {
        for(Produto p: produtosCadastrados) {
            if(p.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
    
    public static void addProduto(Produto p) {
        produtosCadastrados.add(p);
    }
    
    public static Produto getProduto(String nome) {
        for(Produto p: produtosCadastrados) {
            if(p.getNome().equals(nome)) {
                return p;
            }
        }
        throw new IllegalArgumentException("O produto " + nome + " não está cadastrado!");
    }
    
    public static Produto getProduto(String nome, LocalDate validade) {
        System.out.println(validade);
        if(validade == null) {
            return Produto.getProduto(nome);
        }
        for(Produto p: produtosCadastrados) {
            if(p.getNome().equals(nome) && validade.equals(p.getValidade())) {
                return p;
            }
        }
        throw new IllegalArgumentException("O produto " + nome + " de validade " + validade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "não está cadastrado!");
    }
    
    public static ArrayList<Produto> getProdutos() {
        return produtosCadastrados;
    }
    
    public static void setProdutos(ArrayList<Produto> p) {
        produtosCadastrados = p;
    }

    private String nome;
    private double precoCompra;
    private double precoVenda;
    private LocalDate validade;

    public Produto(String nome, double precoCompra, double precoVenda, LocalDate validade) {
        this.setNome(nome);
        this.setPrecoCompra(precoCompra);
        this.setPrecoVenda(precoVenda);
        this.setValidade(validade);
        Produto.addProduto(this);
    }
    
    public abstract void atualizarProduto(String nome, double precoCompra, double precoVenda, Object quantidade);
    
    public String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        if(nome.equals("")) {
            throw new IllegalArgumentException("O nome do produto é inválido!");
        }
        this.nome = nome;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    protected void setPrecoCompra(double precoCompra) {
        if(precoCompra < 0) {
            throw new IllegalArgumentException("O preço " + precoCompra + " é inválido!");
        }
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    protected void setPrecoVenda(double precoVenda) {
        if(precoVenda < 0) {
            throw new IllegalArgumentException("O preço " + precoVenda + " é inválido!");
        }
        this.precoVenda = precoVenda;
    }

    public LocalDate getValidade() {
        return validade;
    }

    protected void setValidade(LocalDate validade) {
        if(validade.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Validade é inválida!");
        }
        Produto aux = null;
        try {
            aux = Produto.getProduto(this.getNome());
        } catch(Exception e) {
            
        }
        if(aux != null) {
            if(aux.getValidade().equals(validade)) {
                throw new IllegalArgumentException("Esse produto já foi cadastrado com esta mesma data de validade!");
            }
        }
        this.validade = validade;
    }

    @Override
    public String toString() {
        return this.getNome() + " " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(this.getValidade());
    }
    
    public abstract Object getQuantidade();
    public abstract void setQuantidade(Object quantidade);
    public abstract void decQuantidade(String valor);
    
}
