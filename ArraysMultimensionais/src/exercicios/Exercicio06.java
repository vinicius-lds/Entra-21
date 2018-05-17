package exercicios;

import java.util.Scanner;

public class Exercicio06 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nome do Jogador 1: ");
		String jogador1 = scanner.nextLine();
		System.out.print("Nome do Jogador 2: ");
		String jogador2 = scanner.nextLine();
		String[][] jogo = new String[][]{{"1", "|", "2", "|", "3"},
									     {"-", "+", "-", "+", "-"},
									     {"4", "|", "5", "|", "6"},
									     {"-", "+", "-", "+", "-"},
									     {"7", "|", "8", "|", "9"}};
		boolean vencedor = false;
		boolean isJogador1 = true;
		boolean isValida = false;
		boolean isJogadaRestante;
		int rodada = 1;
		int jogada;
		int iLinha;
		int iColuna;
		int iDiagonalNormal;
		int iDiagonalInvertida;
		int[] linha = new int[3];
		int[] coluna = new int[3];
		int[] diagonalNormal = new int[3];
		int[] diagonalInvertida = new int[3];
		
		while(!vencedor) {
			
			//IMPRIME RODADA
			System.out.println("#### RODADA " + (rodada++) + " ####");
			System.out.println("#JOGADOR " + ((isJogador1) ? jogador1 : jogador2));
			for (int i = 0; i < jogo.length; i++) {
				for (int j = 0; j < jogo[0].length; j++) {
					System.out.print(jogo[i][j]);
				}
				System.out.println();
			}
			
			//Pede a jogada e atualiza o jogo
			while(!isValida) {
				try {
					System.out.print("Qual é sua jogada? ");
					jogada = scanner.nextInt();
					for (int i = 0; i < jogo.length; i += 2) {
						for (int j = 0; j < jogo[0].length; j += 2) {
							if(jogo[i][j].equals(String.valueOf(jogada))) {
								isValida = true;
								jogo[i][j] = (isJogador1) ? "X" : "O";
							}
						}
					}
					if(!isValida) {
						throw new IllegalArgumentException();
					}
				} catch (Exception e) {
					System.out.println("Essa não é uma jogada válida!");
				}
				
			}
			
			//Verifica sem tem um vencedor
			linha[0] = -1;
			linha[1] = -1;
			linha[2] = -1;
			coluna[0] = -1;
			coluna[1] = -1;
			coluna[2] = -1;
			diagonalNormal[0] = -1;
			diagonalNormal[1] = -1;
			diagonalNormal[2] = -1;
			diagonalInvertida[0] = -1;
			diagonalInvertida[1] = -1;
			diagonalInvertida[2] = -1;
			iLinha = 0;
			iColuna = 0;
			iDiagonalNormal = 0;
			iDiagonalInvertida = 0;
			for (int i = 0; i < jogo.length; i += 2) {
				for (int j = 0; j < jogo.length; j += 2) {
					
					if(iLinha == 3 || iColuna == 3) {
						iLinha = 0;
						iColuna = 0;
						linha[0] = -1;
						linha[1] = -1;
						linha[2] = -1;
						coluna[0] = -1;
						coluna[1] = -1;
						coluna[2] = -1;
					}
					if(jogo[i][j].charAt(0) == 'X') {
						linha[iLinha] = 0;
					} else if(jogo[i][j].charAt(0) == 'O') {
						linha[iLinha] = 1;
					}
					
					if(jogo[j][i].charAt(0) == 'X') {
						coluna[iColuna] = 0;
					} else if(jogo[j][i].charAt(0) == 'O') {
						coluna[iColuna] = 1;
					}
					
					iColuna++;
					iLinha++;
					
					if(j == i) {
						if(jogo[i][j].charAt(0) == 'X') {
							diagonalNormal[iDiagonalNormal] = 0; 
						} else if(jogo[i][j].charAt(0) == 'O') {
							diagonalNormal[iDiagonalNormal] = 1;
						}
						iDiagonalNormal++;
					}
					
					if((i + j) == 4) {
						if(jogo[i][j].charAt(0) == 'X') {
							diagonalInvertida[iDiagonalInvertida] = 0; 
						} else if(jogo[i][j].charAt(0) == 'O') {
							diagonalInvertida[iDiagonalInvertida] = 1;
						}
						iDiagonalInvertida++;
					}
					
				}
				if((linha[0] != -1) && (linha[0] == linha[1]) && (linha[0] == linha[2])) {
					vencedor = true;
				}
				
				if((coluna[0] != -1) && (coluna[0] == coluna[1]) && (coluna[0] == coluna[2])) {
					vencedor = true;
				}
				
				if((diagonalInvertida[0] != -1) && (diagonalInvertida[0] == diagonalInvertida[1]) && (diagonalInvertida[0] == diagonalInvertida[2])) {
					vencedor = true;
				}
				
				if((diagonalNormal[0] != -1) && (diagonalNormal[0] == diagonalNormal[1]) && (diagonalNormal[0] == diagonalNormal[2])) {
					vencedor = true;
				}
			}
			
			//Verifica se ainda existem jogadas
			isJogadaRestante = false;
			for (int k = 0; k < jogo.length; k += 2) {
				for (int k2 = 0; k2 < jogo[0].length; k2 += 2) {
					if(Character.isDigit(jogo[k][k2].charAt(0))) {
						isJogadaRestante = true;
					}
				}
			}
			if(!isJogadaRestante) {
				break;
			}
			
			//Atualiza variaveis
			isValida = false;
			isJogador1 = !isJogador1;
			
		}
		
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo[0].length; j++) {
				System.out.print(jogo[i][j]);
			}
			System.out.println();
		}
		if(vencedor) {
			System.out.println("###" + ((!isJogador1) ? jogador1 : jogador2) + " GANHOU!###");
		} else {
			System.out.println("### NINGUÉM GANHOU! ###");
		}
	}

}
