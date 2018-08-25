package ex06;

import javax.swing.JOptionPane;

public class Exercicio06 {

	public static void main(String[] args) {

		String[] jogadores = new String[10];
		int[] acertos = new int[10];
		String[] perguntas = new String[] {"Pergunta 1", "Pergunta 2", "Pergunta 3", "Pergunta 4", "Pergunta 5", 
										   "Pergunta 6", "Pergunta 7", "Pergunta 8", "Pergunta 9", "Pergunta 10"};
		boolean[] respostas = new boolean[] {true, true, true, true, true, true, true, true, true, true};
		boolean continua = true;
		
		int index = 0;
		int resp;
		while(continua) {
			
			jogadores[index] = JOptionPane.showInputDialog("Nome do Jogador");
			
			for (int i = 0; i < perguntas.length; i++) {
				resp = JOptionPane.showConfirmDialog(null, perguntas[i], "Pergunta " + (i + 1), JOptionPane.YES_NO_OPTION);
				if((resp == JOptionPane.YES_OPTION) && respostas[i]) {
					acertos[index]++;
				}
			}
			
			continua = (JOptionPane.showInputDialog(null,
							                        "Deseja continuar jogando?",
							                        "", 
							                        JOptionPane.PLAIN_MESSAGE,
							                        null,
							                        new String[]{"Sim", "Não"},
							                        "").equals("Sim")) ? true : false;
			index++;
		}
		
		String aux;
		for (int i = 0; i < acertos.length; i++) {
			for (int j = i; j > 0; j--) {
				if(acertos[j] > acertos[j - 1]) {
					resp = acertos[j];
					acertos[j] = acertos[j - 1];
					acertos[j - 1] = resp;
					
					aux = jogadores[j];
					jogadores[j] = jogadores[j - 1];
					jogadores[j - 1] = aux;
				}
			}
		}
		
		aux = "";
		for (int i = 0; i < jogadores.length; i++) {
			if(jogadores[i] != null) {
				aux += jogadores[i] + " " + acertos[i] + " acertos.\n";
			}
		}
		JOptionPane.showMessageDialog(null, aux);
		
	}

}
