package exercicio03;

public class Pedido extends Cardapio {
	
	private String nome;
	private double valor;
	private int quantidade;
	
	public Pedido(int codigo, int quantidade) {
		this.setNome(super.PEDIDOS[codigo - 1][0]);
		this.setValor(Double.parseDouble(super.PEDIDOS[codigo - 1][1]));
		this.setQuantidade(quantidade);
	}
	
	public double getPrecoTotal() {
		return this.getValor() * this.getQuantidade();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
