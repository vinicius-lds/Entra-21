package ex07;

import javax.swing.JOptionPane;

public class Exercicio07 {

	public static void main(String[] args) {

		int[] inteiros = new int[7];
		int aux;
		
		for (int i = 0; i < inteiros.length; i++) {
			aux = Integer.MIN_VALUE;
			while(aux == Integer.MIN_VALUE) {
				try {
					aux = Integer.parseInt(JOptionPane.showInputDialog("Insira um número"));
					for (int j = 0; j < i + 1; j++) {
						if(inteiros[j] == aux) {
							aux = Integer.MIN_VALUE;
							throw new IllegalArgumentException("O número inserio é repetido!");
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "O número inserido é inválido!" + ((e.getMessage() != null) ? "\n" + e.getMessage() : ""));
				}
				inteiros[i] = aux;
			}
		}
		
		String str = "";
		for (int i = 0; i < inteiros.length; i++) {
			str += inteiros[i] + " ";
		}
		JOptionPane.showMessageDialog(null, str);
	}

}
