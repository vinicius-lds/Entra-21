package exercicio04;

import javax.swing.JOptionPane;
import util.PedeDados;

public class Principal {

	public static Avaliacao[] avaliacoes = new Avaliacao[] {
			Excelente.getInstance(),
			Otimo.getInstance(),
			Bom.getInstance(),
			Regular.getInstance(),
			Ruim.getInstance()
	};
	public static Avaliacao avaliacao;
	
	public static void main(String[] args) {
		
		do {
			
			avaliacao = (Avaliacao) PedeDados.getComboBox("Qual � sua avalia��o do filme?", avaliacoes);
			avaliacao.incQuantidade();
			avaliacao.incFaixaEtaria(PedeDados.getInt("Qual � sua idade?", 0, 101));
			
		} while(PedeDados.perguntaBooleana("Deseja cadastrar mais uma avalia��o?"));
		
		String aux = "Dados resultantes da pesquisa:";
		
		for(Avaliacao a: avaliacoes) {
			aux += "\n\n" + a.toString() + " " + a.getPorcentagemFormatada()
				+  "\n"   + a.getPorcentagemFaixaEtarias();
		}
		
		JOptionPane.showMessageDialog(null, aux);
		
	}

}
