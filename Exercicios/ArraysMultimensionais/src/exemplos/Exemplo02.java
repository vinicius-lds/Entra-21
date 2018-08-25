package exemplos;

import javax.swing.JOptionPane;

public class Exemplo02 {

	public static void main(String[] args) {
		
		//Matriz
		int[][] valores = new int[5][5];
		
		//Mensagens de exibição
		String texto = "";
		String exibir = "";
		
		for (int i = 0; i < valores.length; i++) {
			for (int j = 0; j < valores[0].length; j++) {
				texto = "Linha: " + (i + 1) + "\nColuna: " + (j + 1);
				while(valores[i][j] == 0) {
					try {
						valores[i][j] = Integer.parseInt(JOptionPane.showInputDialog(texto));
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Valor Inválido!");
					}
				}
				exibir += valores[i][j] + " ";
			}
			exibir += "\n";
		}
		
		JOptionPane.showMessageDialog(null, exibir);
		
	}

}
