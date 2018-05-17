package exercicio07;

import java.util.ArrayList;

public class JogoDaForca {
	
	private String palavra;
	private String palavraJogo;
	private int chances;
	private boolean jogoGanho;
	private ArrayList<Character> letrasTestadas;
	
	public JogoDaForca(String palavra) {
		this.palavra = palavra.toUpperCase();
		this.chances = 3;
		this.palavraJogo = "";
		this.jogoGanho = false;
		for (int i = 0; i < this.palavra.length(); i++) {
			this.palavraJogo += "_";
		}
		this.letrasTestadas = new ArrayList<>();
	}
	
	public boolean jogar(char letra) {
		
		if(this.chances < 1) {
			throw new IllegalArgumentException("Você não tem mais chances");
		}
		
		letra = (char) ((letra > 96) ? letra - 32 : letra);
		
		if(this.letrasTestadas.contains(letra)) {
			throw new IllegalArgumentException("Você já jogou essa letra");
		}
		
		this.letrasTestadas.add(letra);
		boolean achou = false;
		StringBuilder strb = new StringBuilder(palavraJogo);
		
		
		for (int i = 0; i < palavra.length(); i++) {
			if(palavra.charAt(i) == letra) {
				strb.setCharAt(i, letra);
				achou = true;
			}
		}
		
		this.palavraJogo = strb.toString();
		
		if(this.palavra.equals(this.palavraJogo)) {
			this.jogoGanho = true;
		}
		
		if(!achou) {
			this.chances--;
		}
		
		return achou;
	}
	
	public String getPalavraJogo() {
		return this.palavraJogo;
	}
	
	public int getChances() {
		return this.chances;
	}
	
	public String getCaracteresJogados() {
		
		String aux = "";
		for(Character letra: this.letrasTestadas) {
			aux += letra + " ";
		}
		return aux;
		
	}
	
	public boolean isJogoGanho() {
		return this.jogoGanho;
	}
	
}
