package exercicios;

import java.util.Random;
import java.util.Scanner;

public class Exercicio12 {

	public static void main(String[] args) {
		
		boolean isValida = false;
		boolean ganhou = false;
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		int[][] coordenadas = new int[11][2];
		int[][] jogadas = new int[8][10];
		int x = 0;
		int y = 0;
		int chances = 3;
		char bandeira = 'B';
		char jogadaErrada = 'X';
		char mina = 'M'; 
		String[][] jogo = new String[][] {
			
			{" ", "1", " ", "2", " ", "3", " ", "4", " ", "5", " ", "6", " ", "7", " ", "8", " ", "9", " ", "10"},
			{"1", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "  "},
			{" ", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "--"},
			{"2", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "  "},
			{" ", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "--"},
			{"3", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "  "},
			{" ", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "--"},
			{"4", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "  "},
			{" ", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "--"},
			{"5", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "  "},
			{" ", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "--"},
			{"6", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "  "},
			{" ", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "--"},
			{"7", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "  "},
			{" ", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "-", "+", "--"},
			{"8", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", " ", "|", "  "}
			
		};
		
		//Cria 11 coordenadas diferentes e aleatórias
		for (int i = 0; i < coordenadas.length; i++) {

			coordenadas[i][0] = r.nextInt(8);
			coordenadas[i][1] = r.nextInt(10);

			for (int j = i - 1; j >= 0; j--) {

				if ((coordenadas[j][0] == coordenadas[i][0]) && (coordenadas[j][1] == coordenadas[i][1])) {
					i--;
					break;
				}

			}

		}
		
		for (int i = 0; i < coordenadas.length; i++) {
			System.out.println(i + "   X: " + coordenadas[i][0] + " Y: " + coordenadas[i][1]);
		}
		
		while((chances > 0) && (!ganhou)) {
			
			//Imprime jogo
			for (int i = 0; i < jogo.length; i++) {
				for (int j = 0; j < jogo[0].length; j++) {
					System.out.print(jogo[i][j]);
				}
				System.out.println();
			}
			
			//Pede a jogada
			while(!isValida) {
				x = 0;
				y = 0;
				while(x < 1 || x > 8) {
					System.out.print("Coodenada X: ");
					x = s.nextInt();
				}
				while(y < 1 || y > 10) {
					System.out.print("Coodenada Y: ");
					y = s.nextInt();
				}
				if(jogadas[x - 1][y - 1] == 0) {
					isValida = true;
				}
			}
			
			//Valida Jogada
			boolean isCoordenadaReservada = false;
			for (int i = 0; i < coordenadas.length; i++) {
				if(((coordenadas[i][0] + 1) == x) && ((coordenadas[i][1] + 1) == y)) {
					jogadas[x - 1][y - 1] = 1;
					int aux = x;
					isCoordenadaReservada = true;
					x = 1;
					for (int j = 1; j < aux; j++) {
						x += 2;
					}
					aux = y;
					y = 1;
					for (int j = 1; j < aux; j++) {
						y += 2;
					}
					if(i == 0) {
						jogo[x][y] = String.valueOf(bandeira);
						ganhou = true;
					} else {
						jogo[x][y] = String.valueOf(mina);
						chances--;
					}
				}
			}
			if(!isCoordenadaReservada) {
				jogadas[x - 1][y - 1] = 1;
				int aux = x;
				x = 1;
				for (int j = 1; j < aux; j++) {
					x += 2;
				}
				aux = y;
				y = 1;
				for (int j = 1; j < aux; j++) {
					y += 2;
				}
				jogo[x][y] = String.valueOf(jogadaErrada);
			}
			
			isValida = false;
		
		}
		
		//Imprime jogo
		for (int i = 0; i < jogo.length; i++) {
			for (int j = 0; j < jogo[0].length; j++) {
				System.out.print(jogo[i][j]);
			}
			System.out.println();
		}
		
		if(ganhou) {
			System.out.println("Parabéns você conseguiu achar a Bandeira!");
		} else {
			System.out.println("Você ficou sem chances e perdeu!");
		}
		
	}

}
