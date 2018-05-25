package ex01;

import java.util.ArrayList;

public class Pedido {
	
	private static ArrayList<Pedido> pedidos = new ArrayList<>();
	
	public static void addPedido(Pedido p) {
		pedidos.add(p);
	}
	
	public static ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	
	private ArrayList<Produto> produtos;

	public Pedido() {
		super();
		this.produtos = new ArrayList<>();
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
	public void addProduto(Produto p) {
		this.produtos.add(p);
	}
	
}
