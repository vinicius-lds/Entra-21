package ex01;

import javax.swing.JOptionPane;

public class Exercicio01 {

	public static void main(String[] args) {

		int[] vetor1 = new int[10];
		int[] vetor2 = new int[10];
		int[] vetor3 = new int[10];
		
		for (int i = 0; i < vetor1.length; i++) {
			while(vetor1[i] == 0) {
				try {
					vetor1[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira um número diferente de 0"));
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Número Inválido!");
				}
			}
		}
		
		for (int i = 0; i < vetor2.length; i++) {
			while(vetor2[i] == 0) {
				try {
					vetor2[i] = Integer.parseInt(JOptionPane.showInputDialog("Insira um número diferente de 0"));
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Número Inválido!");
				}
			}
		}
		
		char operador = 0;
		while(operador == 0) {
			try{
				operador = JOptionPane.showInputDialog("Digite o operador").charAt(0);
				if((operador != '+') && (operador != '-') && (operador != '*') && (operador != '/')) {
					operador = 0;
					JOptionPane.showMessageDialog(null, "Operador é inválido!");
				}
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Operador é inválido!");
			}
		}
		
		String str = "Operação sobre vetores";
		for (int i = 0; i < vetor3.length; i++) {
			switch (operador) {
			case '+':
				vetor3[i] = vetor1[i] + vetor2[i];
				break;
			case '-':
				vetor3[i] = vetor1[i] - vetor2[i];
				break;
			case '*':
				vetor3[i] = vetor1[i] * vetor2[i];
				break;
			case '/':
				vetor3[i] = vetor1[i] / vetor2[i];
				break;
			default:
				break;
			}
			str += "\n" + vetor1[i] + " " + operador + " " + vetor2[i] + " = " + vetor3[i];
		}
		
		JOptionPane.showMessageDialog(null, str);
		
	}

}
