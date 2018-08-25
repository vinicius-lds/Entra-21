package ex04;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Exercicio04 {

	public static void main(String[] args) {
		
		char[] gabarito = new char[10];
		ArrayList<String> nomes = new ArrayList<String>();
		ArrayList<Integer> acertos = new ArrayList<Integer>(); 
		char resposta = 0;
		
		for(int i = 0; i < gabarito.length; i++) {
			while(gabarito[i] == 0) {
				try {
					gabarito[i] = JOptionPane.showInputDialog("Insira a resposta da questão " + (i + 1) + ".").toUpperCase().charAt(0);
					if((gabarito[i] < 65) || (gabarito[i] > 68)) {
						gabarito[i] = 0;
						JOptionPane.showMessageDialog(null, "A resposta inserida é inválida!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "A resposta dada é inválida!");
				}
			}
		}
		
		nomes.add(JOptionPane.showInputDialog("Nome do aluno"));
		while(!nomes.get(nomes.size() - 1).equalsIgnoreCase("SAIR")) {
			acertos.add(0);
			for(int i = 0; i < gabarito.length; i++) {
				while(resposta == 0) {
					try {
						resposta = JOptionPane.showInputDialog("Resposta do aluno para a questão " + (i + 1) + ".").toUpperCase().charAt(0);
						if((resposta < 65) || (resposta > 68)) {
							resposta = 0;
							JOptionPane.showMessageDialog(null, "A resposta inserida é inválida!");
						}
						if(resposta == gabarito[i]) {
							acertos.set(acertos.size() -1, acertos.get(acertos.size() -1) + 1);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "A resposta dada é inválida!");
					}
				}
				resposta = 0;
			}
			
			Object aux;
			for (int i = acertos.size() - 1; i > 0; i--) {
				if(acertos.get(i) > acertos.get(i - 1)) {
					aux = acertos.get(i);
					acertos.set(i, acertos.get(i - 1));
					acertos.set(i - 1, (Integer) aux);
					
					aux = nomes.get(i);
					nomes.set(i, nomes.get(i - 1));
					nomes.set(i - 1, (String) aux);
				} else {
					break;
				}
			}
			
			nomes.add(JOptionPane.showInputDialog("Nome do aluno"));
		}
		
		nomes.remove(nomes.size() - 1);
		
		String saida = "Melhores Alunos:\n";
		for(int i = 0; i < nomes.size(); i++) {
			saida += (i + 1) + "º " + nomes.get(i) + " com " + acertos.get(i) + " acerto(s).\n";
		}
		JOptionPane.showMessageDialog(null, saida);
	}

}
