package ex05;

import javax.swing.JOptionPane;

public class Exercicio05 {

	public static void main(String[] args) {

		int[] inteiros = new int[15];
		//soma, maior, menor, pares, negativo, positivo, acima da media, abaixo da media
		int[] aux = new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0, 0, 0};
		double media = 0.0;
		
		for (int i = 0; i < inteiros.length; i++) {
			while(inteiros[i] == 0) {
				try {
					inteiros[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira um numero na " + (i + 1) + "� posi��o."));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "N�mero inserido � inv�lido!");
				}
			}
			aux[0] += inteiros[i];
			if(aux[1] < inteiros[i]) {
				aux[1] = inteiros[i];
			}
			if(aux[2] > inteiros[i]) {
				aux[2] = inteiros[i];
			}
			if(inteiros[i] % 2 == 0) {
				aux[3]++;
			}
			if(inteiros[i] < 0) {
				aux[4]++;
			}else if(inteiros[i] > 0) {
				aux[5]++;
			}
		}
		
		media = aux[0];
		media /= inteiros.length;
		
		for (int i = 0; i < inteiros.length; i++) {
			if(inteiros[i] > media) {
				aux[6]++;
			} else if(inteiros[i] < media) {
				aux[7]++;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Soma: " + aux[0]
											+ "\nMaior: " + aux[1]
											+ "\nMenor: " + aux[2]
											+ "\nPares: " + aux[3]
											+ "\n�mpares: " + (inteiros.length - aux[3])
											+ "\nNegativos: " + aux[4]
											+ "\nPositivos: " + aux[5]
											+ "\nNeutros: " + (inteiros.length - (aux[4] + aux[5]))
											+ "\nM�dia: " + media
											+ "\nAcima da m�dia: " + aux[6]
											+ "\nAbaixo da m�dia: " + aux[7]
											+ "\nNa m�dia: " + (inteiros.length - (aux[6] + aux[7])));
		
	}

}
