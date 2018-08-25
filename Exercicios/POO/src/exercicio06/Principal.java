package exercicio06;

import javax.swing.JOptionPane;

import util.PedeDados;

public class Principal {

	public static void main(String[] args) {
		
		Aluno a;
		String[] sexos = new String[] {"Masculino", "Feminino"}; 
		
		do {
			
			a = Aluno.getInstance();
			a.setNome(PedeDados.getString("Nome do Aluno"));
			a.setSexo(PedeDados.getComboBox("Sexo", sexos));
			for(int i = 1; i <= 4; i++) {
				a.addNota(PedeDados.getDouble("Nota " + i, 0, 10));
			}
			JOptionPane.showMessageDialog(null, a.getBoletim());
			
		} while(PedeDados.perguntaBooleana("Deseja cadastrar mais algum aluno?"));
		
		JOptionPane.showMessageDialog(null, Aluno.getRelatorioFinal());
		
	}

}
