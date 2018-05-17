package exercicio05;

import javax.swing.JOptionPane;

import util.PedeDados;

public class Principal {
	
	public static void main(String[] args) {
		
		Produto p;
		do {
			p = Produto.getInstance(PedeDados.getString("Nome do Produto"), PedeDados.getDouble("Pre�o do Produto", 0.01));
			JOptionPane.showMessageDialog(null, p.getPrimeirosDez());
		} while(PedeDados.perguntaBooleana("Deseja ver a tabela de pre�os de mais algum produto?"));
		
	}
	
}
