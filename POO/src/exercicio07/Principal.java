package exercicio07;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		JogoDaForca jogo = new JogoDaForca("java");
		Scanner s = new Scanner(System.in);
		
		do {
			
			System.out.println("Caracteres jogados: " + jogo.getCaracteresJogados());
			System.out.println("Chances restantes: " + jogo.getChances());
			System.out.println(jogo.getPalavraJogo());
			try {
				jogo.jogar(s.nextLine().charAt(0));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} while(jogo.getChances() > 0 && !jogo.isJogoGanho());
		
		System.out.println(jogo.getPalavraJogo());
		if(jogo.isJogoGanho()) {
			System.out.println("Parabéns você ganhou!");
		} else {
			System.out.println("Você ficou sem chances!");
		}
		
	}
	
}
