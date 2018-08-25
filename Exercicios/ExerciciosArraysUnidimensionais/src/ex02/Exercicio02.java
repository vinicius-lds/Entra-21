package ex02;

import javax.swing.JOptionPane;

public class Exercicio02 {

	public static void main(String[] args) {
		
		int[] numeros = new int[11];
		String str = "";
		
		for (int i = 0; i < numeros.length; i++) {
			while(numeros[i] == 0) {
				try {
					numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Um numero"));
					str += numeros[i] + " ";
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "O número inserido é inválido!");
				}
			}
		}
		
		int aux;
		String strInvertida = "";
		for (int i = 0, j = numeros.length - 1; i < (numeros.length / 2); i++, j--) {
			aux = numeros[j];
			numeros[j] = numeros[i];
			numeros[i] = aux;
			strInvertida += numeros[i] + " ";
		}
		
		for (int i = (numeros.length / 2); i < numeros.length; i++) {
			strInvertida += numeros[i] + " ";
		}
		
		JOptionPane.showMessageDialog(null, str + "\n" + strInvertida);
		
	}

}
