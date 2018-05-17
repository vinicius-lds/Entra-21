package exemplo02;

import javax.swing.JOptionPane;

public class Aluno {
	
	String nome;
	double[] notas;
	
	public Aluno() {
		notas = new double[3];
	}
	
	public void obterDados() {
		nome = JOptionPane.showInputDialog("Informe seu nome");
		
		for (int i = 0; i < notas.length; i++) {
			notas[i] = Double.parseDouble(JOptionPane.showInputDialog((i + 1) + "ª nota"));
		}
		
	}
	
	public void laco() {
		
		int continuar = 0;
		
		do {
			
			this.obterDados();
			continuar = JOptionPane.showConfirmDialog(null, "Continuar?");
			
		} while(continuar == 0);
		
	}
	
}
