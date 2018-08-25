package ex03;

import javax.swing.JOptionPane;

public class Exercicio03 {

	public static void main(String[] args) {

		int[] ints = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		int numeroEncontrar = Integer.MIN_VALUE;
		
		for (int i = 0; i < ints.length; i++) {
			while(ints[i] == Integer.MIN_VALUE) {
				try {
					ints[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira um número"));
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Número inserido é inválido!");
				}
			}
		}
		
		while(numeroEncontrar == Integer.MIN_VALUE) {
			try {
				numeroEncontrar = Integer.parseInt(JOptionPane.showInputDialog("Qual número deseja encontrar?"));
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "O número que deseja encontrar é inválido");
			}
		}
		
		String instancias = "O número " + numeroEncontrar + " foi encontrado nas seguintes posições: \n";
		
		for (int i = 0; i < ints.length; i++) {
			instancias += (ints[i] == numeroEncontrar) ? (i + 1) + " " : "";
		}
		
		if(instancias.charAt(instancias.length() - 1) == '\n') {
			JOptionPane.showMessageDialog(null, "O número " + numeroEncontrar + " não foi encontrado!");
		} else {
			JOptionPane.showMessageDialog(null, instancias);
		}
		
	}

}
