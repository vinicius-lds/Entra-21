package ex03;

import javax.swing.JOptionPane;

public class Exercicio03 {

	public static void main(String[] args) {

		int[] ints = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		int numeroEncontrar = Integer.MIN_VALUE;
		
		for (int i = 0; i < ints.length; i++) {
			while(ints[i] == Integer.MIN_VALUE) {
				try {
					ints[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira um n�mero"));
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "N�mero inserido � inv�lido!");
				}
			}
		}
		
		while(numeroEncontrar == Integer.MIN_VALUE) {
			try {
				numeroEncontrar = Integer.parseInt(JOptionPane.showInputDialog("Qual n�mero deseja encontrar?"));
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "O n�mero que deseja encontrar � inv�lido");
			}
		}
		
		String instancias = "O n�mero " + numeroEncontrar + " foi encontrado nas seguintes posi��es: \n";
		
		for (int i = 0; i < ints.length; i++) {
			instancias += (ints[i] == numeroEncontrar) ? (i + 1) + " " : "";
		}
		
		if(instancias.charAt(instancias.length() - 1) == '\n') {
			JOptionPane.showMessageDialog(null, "O n�mero " + numeroEncontrar + " n�o foi encontrado!");
		} else {
			JOptionPane.showMessageDialog(null, instancias);
		}
		
	}

}
