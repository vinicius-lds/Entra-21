package ex01;

import java.util.ArrayList;

public class Produto {
	
	private static ArrayList<Produto> produtos = new ArrayList<>();
	
	public static ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
	public static void addProduto(Produto p) {
		produtos.add(p);
	}
	
	public static void removeProduto(int index) {
		produtos.remove(index);
	}
	
	public static void removeProdutos(String nome) {
		for(Produto p: produtos) {
			if(p.getNome().equals(nome)) {
				produtos.remove(p);
			}
		}
	}
	
	public static boolean alreadyHas(String produto) {
		for(Produto p: getProdutos()) {
			if(p.getNome().equals(produto)) {
				return true;
			}
		}
		return false;
	}
	
	private String nome;
	private double valor;
	private int quantidade;
	
	public Produto(String nome, double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public Produto(String nome, double valor, int quantidade) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Nome inv�lido!");
		}
		this.nome = nome;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		if(valor < 0) {
			throw new IllegalArgumentException("Valor � inv�lido! " + valor);
		}
		this.valor = valor;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Object[] getRow() {
		return new Object[] {this.getNome(), this.getValor(), this.getQuantidade(), (this.getValor() * this.getQuantidade())};
	}
	
	public Produto getNewInstance(int quantidade) {
		return new Produto(this.nome, this.valor, quantidade);
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
}
