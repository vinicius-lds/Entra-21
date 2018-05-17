package exercicio03;

public abstract class Cardapio {
	
	public static final String[][] PEDIDOS = new String[][] {{"Hamb�rguer + Suco de Laranja", "5.00"}, 
															 {"Sandu�che natural + Suco de Uva", "4.50"}, 
															 {"Prato do dia", "8.00"}, 
															 {"Pizza", "12.00"}, 
															 {"Lasanha", "16.50"}, 
															 {"P�o de queijo", "1.00"}, 
															 {"Bolo", "2.50"}};
															 
    public static String getCardapio() {
    	String aux = "";
    	for (int i = 0; i < PEDIDOS.length; i++) {
    		aux += i + 1 + " - ";
			for (int j = 0; j < PEDIDOS[0].length; j++) {
				 aux += (j == 1 ? "R$" : "") + PEDIDOS[i][j] + " ";
			}
			aux += "\n";
		}
    	return aux.replace('.', ',');
    }
		 
}
