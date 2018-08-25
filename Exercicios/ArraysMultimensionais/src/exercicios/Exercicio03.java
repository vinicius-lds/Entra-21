package exercicios;

import javax.swing.JOptionPane;

public class Exercicio03 {

	public static void main(String[] args) {
		
		int[][] valores = new int[3][3];
		String matrizOriginal = "";
		
		for (int i = 0; i < valores.length; i++) {
			for (int j = 0; j < valores[0].length; j++) {
				while(valores[i][j] == 0) {
					try {
						valores[i][j] = Integer.parseInt(JOptionPane.showInputDialog((i + 1) + "x" + (j + 1)));
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Valor Inválido!");
					}
				}
				matrizOriginal += valores[i][j] + " ";
			}
			matrizOriginal += "\n";
		}
		
		String exibicao = "";
		
		for (int i = 0; i < valores[0].length; i++) {
			for (int j = 0; j < valores.length; j++) {
				exibicao += valores[j][i] + " ";
			}
			exibicao += "\n";
		}
		
		JOptionPane.showMessageDialog(null, "Original:\n" + matrizOriginal + "\nTransposta:\n" + exibicao);
		
	}

}
