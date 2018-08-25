package exercicios;

import javax.swing.JOptionPane;

public class Exercicio02 {

	public static void main(String[] args) {
		
		//linha, coluna
		int[][] valores = new int[5][5];
		int somaMatriz = 0;
		int somaQuartaLinha = 0;
		int somaSegundaColuna = 0;
		int somaDiagonalPrimaria = 0;
		int somaDiagonalSecundaria = 0;
		String exibicao = "\n";
		
		for (int i = 0; i < valores.length; i++) {
			for (int j = 0; j < valores[0].length; j++) {
				while(valores[i][j] == 0) {
					try {
						valores[i][j] = Integer.parseInt(JOptionPane.showInputDialog((i + 1) + "x" + (j + 1)));
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Valor Inválido!");
					}
				}
				somaMatriz += valores[i][j];
				exibicao += valores[i][j] + " ";
			}
			exibicao += "\n";
		}
		
		for (int i = 0; i < valores.length; i++) {
			somaQuartaLinha += valores[3][i];
		}
		
		for (int i = 0; i < valores[1].length; i++) {
			somaSegundaColuna += valores[i][1];
		}
		
		for (int i = 0; i < valores.length; i++) {
			somaDiagonalPrimaria += valores[i][i];
		}
		
		for (int i = 0, j = 4; i < valores.length; i++, j--) {
			somaDiagonalSecundaria += valores[j][i];
		}
		
		JOptionPane.showMessageDialog(null, "4ª Linha: " + somaQuartaLinha
										  + "\n2ª Coluna: " + somaSegundaColuna
										  + "\nDiagonal Principal: " + somaDiagonalPrimaria
										  + "\nDiagonal Secundária: " + somaDiagonalSecundaria
										  + "\nSoma Matriz: " + somaMatriz
										  + "\n\n" + exibicao);
		
	}

}
