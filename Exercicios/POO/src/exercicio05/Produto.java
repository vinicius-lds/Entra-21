package exercicio05;

import java.text.DecimalFormat;

public class Produto {
	
	private static Produto object;
	private String nome;
	private double preco;
	private DecimalFormat PORCENTAGEM = new DecimalFormat("#0.00");
	
	private Produto() {}
	
	public static Produto getInstance(String nome, double preco) {
		if(Produto.object == null) {
			Produto.object = new Produto();
		}
		Produto.object.setNome(nome);
		Produto.object.setPreco(preco);
		return Produto.object;
	}
	
	public String getPrimeirosDez() {
		
		String aux = "";
		double comDesconto;
		for(int i = 1; i <= 10; i++) {
			comDesconto = preco - ((preco / 100) * (5 * i));
			aux += (i) + " x R$ " + PORCENTAGEM.format(comDesconto) + " = R$ " + PORCENTAGEM.format(comDesconto * i) + "\n";
		}
		return aux;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getQuantidade() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
