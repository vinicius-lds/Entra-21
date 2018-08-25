package exercicio04;

import java.text.DecimalFormat;

public abstract class Avaliacao {
	
	public static int quantidadeTotal = 0;
	public static DecimalFormat PORCENTAGEM = new DecimalFormat("#0.00");
	protected double quantidade = 0;
	private double[] faixaEtaria;
	
	protected String teste;
	
	protected Avaliacao() {
		this.faixaEtaria = new double[3];
		//this.quantidade = 0;
	}
	
	public void incQuantidade() {
		this.quantidade++;
		Avaliacao.quantidadeTotal++;
	}
	
	public double getQuantidade() {
		return this.quantidade;
	}
	
	public double getPorcentagem() {
		return (this.quantidade / Avaliacao.quantidadeTotal) * 100;
	}
	
	public String getPorcentagemFormatada() {
		return PORCENTAGEM.format(this.getPorcentagem()) + "%";
	}
	
	public String getPorcentagemFaixaEtarias() {
		return "Crianças: " + (this.faixaEtaria[0] == 0 ? "0" : PORCENTAGEM.format((this.faixaEtaria[0] / this.quantidade) * 100)) + "%"
			   + "\nAdolescentes: " + (this.faixaEtaria[1] == 0 ? "0" : PORCENTAGEM.format((this.faixaEtaria[1] / this.quantidade) * 100)) + "%"
			   + "\nAdultos: " + (this.faixaEtaria[2] == 0 ? "0" : PORCENTAGEM.format((this.faixaEtaria[2] / this.quantidade) * 100)) + "%";
	}
	
	public void incFaixaEtaria(int idade) {
		if(idade < 10) {
			this.faixaEtaria[0]++;
		} else if (idade < 18) {
			this.faixaEtaria[1]++;
		} else {
			this.faixaEtaria[2]++;
		}
	}
	
}
