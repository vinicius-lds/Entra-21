package exercicios;

import java.util.Random;

import javax.swing.JOptionPane;

public class Exercicio04 {

	public static void main(String[] args) {
		
		String[][] matriz = new String[5][15];
		String exbicao = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if(j == 0 || j == 14 || i == 0 || i == 4) {
					matriz[i][j] = "*";
				}
				if(i == 2 && j == 7) {
					Random r = new Random();
					matriz[i][j] = String.valueOf(r.nextInt(9));
				}
				exbicao += (matriz[i][j] == null) ? " " : matriz[i][j];
			}
			exbicao += "\n";
		}
		System.out.println(exbicao);
	}

}
