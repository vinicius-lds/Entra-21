package exemplo01;

import javax.swing.JOptionPane;

public class Pessoa {
	
	private String nome;
	private int idade;
	private double peso;
	private double altura;
	
	public void apresentacao() {
		JOptionPane.showMessageDialog(null, "Boa Tarde! Meu nome é " + this.getNome());;
	}
	
	public double calculoIMC() {
		return this.getPeso() / Math.pow(this.getAltura(), 2);
	}
	
	public String condicaoIMC() {
		double imc = this.calculoIMC();
		if(imc < 17) {
			return "Muito Abaixo do Peso!";
		} else if (imc < 18.5) {
			return "Abaixo do Peso!";
		} else if (imc < 25) {
			return "Peso Normal!";
		} else if (imc < 30) {
			return "Acima do Peso!";
		} else if (imc < 35) {
			return "Obesidade I!";
		} else if (imc < 40) {
			return "Obesidade II!";
		} else {
			return "Obesidade III!";
		}
	}
	
	public void exibirIMC() {
		String aux  = "---IMC---";
			   aux += "Seu IMC é de: " + String.format("%.2f", calculoIMC()) + ".\n";
			   aux += "Sua condição é " + condicaoIMC();
	    JOptionPane.showMessageDialog(null, aux);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
}
