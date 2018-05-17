package exercicio01;

import javax.swing.JOptionPane;

import util.PedeDados;

public class Principal {

	public static void main(String[] args) {
		
		int pessoas = 0;
		int homens = 0;
		int menor = 0;
		int[] qtdCargo  = new int[] {0, 0, 0, 0, 0, 0, 0};
		String[] cargos = new String[]{"Gerente", 
									   "Atendente", 
									   "Açougueiro", 
									   "Secretária", 
									   "Almoxarife", 
									   "Padeiro", 
									   "Estagiário"};
		
		do {
			
			if(PedeDados.getComboBox("Sexo", new String[]{"Masculino", "Feminino"}).equals("Masculino")) {
				homens++;
			}
			
			switch (PedeDados.getComboBox("Cargo", cargos)) {
				case "Gerente":
					qtdCargo[0]++;
					break;
				case "Atendente":
					qtdCargo[1]++;
					break;
				case "Açougueiro":
					qtdCargo[2]++;
					break;
				case "Secretária":
					qtdCargo[3]++;
					break;
				case "Almoxarife":
					qtdCargo[4]++;
					break;
				case "Padeiro":
					qtdCargo[5]++;
					break;
				case "Estagiário":
					qtdCargo[6]++;
					break;
				default:
					break;
			}
			
			if(PedeDados.getInt("Idade", true) < 18) {
				menor++;
			}
			
			pessoas++;
			
		} while(PedeDados.perguntaBooleana("Deseja cadastrar mais alguma pessoa?"));
		
		JOptionPane.showMessageDialog(null, "Maiores de Idade: " + (pessoas - menor)
							                +"\nMenores de Idade: " + menor
							                +"\nHomens: " + homens
							                +"\nMulheres: " + (pessoas - homens)
							                +"\n"+cargos[0]+": " + qtdCargo[0]
							                +"\n"+cargos[1]+": " + qtdCargo[1]
							                +"\n"+cargos[2]+": " + qtdCargo[2]
							                +"\n"+cargos[3]+": " + qtdCargo[3]
							                +"\n"+cargos[4]+": " + qtdCargo[4]
							                +"\n"+cargos[5]+": " + qtdCargo[5]
							                +"\n"+cargos[6]+": " + qtdCargo[6]);
		
	}

}
