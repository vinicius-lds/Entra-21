package exemplos;

import javax.swing.JOptionPane;

public class Exemplo01 {

	public static void main(String[] args) {
		
		//Array Multidimensional - Matriz
		String[][] dados = new String[3][3];
		
		//Laço
		for (int i = 0; i < dados.length; i++) {
			
			//Nome
			dados[i][0] = JOptionPane.showInputDialog("Nome");
			
			//Idade
			dados[i][1] = JOptionPane.showInputDialog("Idade");
			
			//Cidade
			dados[i][2] = JOptionPane.showInputDialog("Cidade");
			
		}
		
		//Exibir dados
		String exibir = "Dados informados:\n\n";
		for (int i = 0; i < dados.length; i++) {
			
			exibir += "Nome: " + dados[i][0];
			exibir += "; Idade: " + dados[i][1];
			exibir += "; Cidade: " + dados[i][2] + "\n";
			
		}		
		JOptionPane.showMessageDialog(null, exibir);
		
	}

}
