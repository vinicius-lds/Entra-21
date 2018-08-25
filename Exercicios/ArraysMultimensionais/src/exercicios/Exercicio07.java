package exercicios;

import javax.swing.JOptionPane;

public class Exercicio07 {

	public static void main(String[] args) {
		
		String[][] produtos = new String[][]   {{"Arroz 5 KG", 					"9,50" },
												{"Arroz 1 KG",					"2,75" },
												{"Feijão 3 KG", 				"5,60" },
												{"Feijão 1 KG", 				"3,10" },
												{"Macarrão 500 GR", 			"1,90" },
												{"Farinha de Trigo 2 KG", 		"3,21" },
												{"Ketchup 370 GR", 				"5,50" },
												{"Maionese 480 GR", 			"7,30" },
												{"Gelatina 50 GR", 				"0,65" },
												{"Macarrão Instantâneo 120 GR", "1,19" },
												{"Creme de Leite 150 GR", 		"1,89" },
												{"Leite Condensado 150 GR", 	"2,88" },
												{"Leite 1 L", 					"2,06" },
												{"Chocolate em Pó 500 GR", 		"9,67" },
												{"Pepino em Conserva 600 GR", 	"11,99"},
												{"Vinagre 550 ML", 				"1,94" },
												{"Sal 500 GR", 					"3,34" },
												{"Açúcar 550 GR", 				"4,89" },
												{"Fermento 150 FR", 			"2,19" },
												{"Biscoito de Chocolate 70 GR", "2,09" }};
		int[][] compras = new int[20][2];
		int codigo = Integer.MIN_VALUE;
		int qtd = 0;
		int index = 0;
		double valor;
		double valorTotal = 0.0;
		String strProdutos = "";
		String strCompras = "";
		
		for(int i = 0; i < produtos.length; i++) {
			strProdutos += i + 1 + " ";
			strProdutos += produtos[i][0] + " ";
			strProdutos += "R$" + produtos[i][1] + "\n";
		}
		
		while(codigo < 1) {
			
			while(codigo == Integer.MIN_VALUE) {
				
				try {
					codigo = Integer.parseInt(JOptionPane.showInputDialog(null, strProdutos, "Digite o Código do Produto. (0 para SAIR)", JOptionPane.QUESTION_MESSAGE));
					if(codigo == 0) {
						break;
					}
					if(codigo > 20 || codigo < 1) {
						JOptionPane.showMessageDialog(null, "O CÓDIGO DIGITADO É INVÁLIDO!");
						codigo = Integer.MIN_VALUE;
					}
				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "O CÓDIGO DIGITADO É INVÁLIDO!");
					codigo = Integer.MIN_VALUE;
				}
				
			}
			
			if(codigo == 0) {
				break;
			}
			
			while(qtd == 0) {
				
				try {
					qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
					if(qtd < 1) {
						qtd = 0;
						JOptionPane.showMessageDialog(null, "Quantidade Inválida!");
					}
				} catch (Exception e) {
					qtd = 0;
					JOptionPane.showMessageDialog(null, "Quantidade Inválida!");
				}
				
			}
			
			compras[index][0] = codigo - 1;
			compras[index][1] = qtd;
			index++;
			
			codigo = Integer.MIN_VALUE;
			qtd = 0;
				
		}
			
		for (int j = 0; j < index; j++) {
			strCompras += compras[j][0] + 1 + " ";
			strCompras += produtos[compras[j][0]][0] + "\n";
			strCompras += "Quantidade: " + compras[j][1] + "\n";
			strCompras += "Valor Unitário: R$" + produtos[compras[j][0]][1] + "\n";
			valor = Double.parseDouble(produtos[compras[j][0]][1].replaceAll(",", ".")) * compras[j][1];
			valorTotal += valor;
			strCompras += "Valor Total: R$" + valor + "\n------------------------------------\n";
		}
		
		strCompras += "\nValor Total pela Compra: R$" + valorTotal;
		
		JOptionPane.showMessageDialog(null, strCompras);
	}
		
		
}
