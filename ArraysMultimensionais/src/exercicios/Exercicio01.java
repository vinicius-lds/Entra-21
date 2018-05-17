package exercicios;

import javax.swing.JOptionPane;

public class Exercicio01 {

	public static void main(String[] args) {
		
		int[][] inteiros = new int[5][6];
		//pares, media, acima
		double[] aux = new double[] {0, 0, 0};
		String exibicao = "\n";
		
		for (int i = 0; i < inteiros.length; i++) {
			for (int j = 0; j < inteiros[0].length; j++) {
				while(inteiros[i][j] == 0) {
					try {
						inteiros[i][j] = Integer.parseInt(JOptionPane.showInputDialog((i + 1) + "x" + (j + 1)));
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Valor Inválido!");
					}
				}
				if((inteiros[i][j] % 2) == 0) {
					aux[0]++;
				}
				aux[1] += inteiros[i][j];
				exibicao += inteiros[i][j] + " ";
			}
			exibicao += "\n";
		}
		
		aux[1] /= inteiros.length * inteiros[0].length;
		
		for (int i = 0; i < inteiros.length; i++) {
			//System.out.println("0");
			for (int j = 0; j < inteiros[0].length; j++) {
				System.out.println(aux[1] < inteiros[i][j]);
				if(!(aux[1] < inteiros[i][j])) {
					System.out.println("2");
					aux[2]++;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null, "Pares: " + aux[0]
										  + "\nÍmpares: " + ((inteiros.length * inteiros[0].length) - aux[0])
										  + "\nMédia: " + aux[1]
										  + "\nMaiores ou iguais a média: " + aux[2]
										  + exibicao);
		
	}

}
