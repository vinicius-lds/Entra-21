package exercicio06;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Aluno {
	
	private static Aluno aluno;
	private static double quantidadeTotal = 0;
	private static double masculino = 0;
	private static int[] quantidadeNotas = new int[6];
	public static final DecimalFormat PORCENTAGEM = new DecimalFormat("#0.00");
	
	private String nome;
	private String sexo;
	private ArrayList<Double> notas;
	
	private Aluno() {}
	
	public static Aluno getInstance() {
		if(Aluno.aluno == null) {
			Aluno.aluno = new Aluno();
		}
		Aluno.aluno.clearNotas();
		Aluno.quantidadeTotal++;
		return Aluno.aluno;
	}
	
	public void addNota(double nota) {
		if(this.notas.size() > 4) {
			throw new IndexOutOfBoundsException();
		}
		this.notas.add(nota);
	}
	
	private void clearNotas() {
		this.notas = new ArrayList<>();
	}
	
	public String getBoletim() {
		double media = this.getMedia();
		String boletim = media + " - ";
		if(media < 5) {
			Aluno.quantidadeNotas[0]++;
			return boletim + "Reprovado";
		} else if(media < 7) {
			Aluno.quantidadeNotas[1]++;
			return boletim + "Recuperação";
		} else if(media < 8) {
			Aluno.quantidadeNotas[2]++;
			return boletim + "Satisfatório";
		} else if(media < 9) {
			Aluno.quantidadeNotas[3]++;
			return boletim + "Bom";
		} else if(media < 10) {
			Aluno.quantidadeNotas[4]++;
			return boletim + "Ótimo";
		} else {
			Aluno.quantidadeNotas[5]++;
			return boletim + "Parabéns";
		}
	}
	
	private static String getPercentualGeneros() {
		return PORCENTAGEM.format((Aluno.masculino / Aluno.quantidadeTotal) * 100) + "% de meninos."
				+ "\n" + PORCENTAGEM.format(((Aluno.quantidadeTotal - Aluno.masculino) / Aluno.quantidadeTotal) * 100 )+ "% de meninas.";
	}
	
	public static String getRelatorioFinal() {
		return  "---Relatório Final---"
				+ "\n" + Aluno.getPercentualGeneros() + "\n"
				+ "\n" + Aluno.quantidadeNotas[0] + " Nota(s) entre 0 e 5" 
				+ "\n" + Aluno.quantidadeNotas[1] + " Nota(s) entre 5 e 7"
				+ "\n" + Aluno.quantidadeNotas[2] + " Nota(s) entre 7 e 8"
				+ "\n" + Aluno.quantidadeNotas[3] + " Nota(s) entre 8 e 9"
				+ "\n" + Aluno.quantidadeNotas[4] + " Nota(s) entre 9 e 10"
				+ "\n" + Aluno.quantidadeNotas[5] + " Nota(s) 10";
	}
	
	private double getMedia() {
		double media = 0;
		for(Double nota: this.notas) {
			media += nota;
		}
		return media / 4;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
		if(this.sexo.equals("Masculino")) {
			Aluno.masculino++;
		}
	}
	
}
