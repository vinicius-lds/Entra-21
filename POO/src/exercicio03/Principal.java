package exercicio03;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import util.PedeDados;

public class Principal {
	
	public static final DecimalFormat FORMATO_DECIMAL = new DecimalFormat("#0.00");
	public static int codigo = 0;
	public static int quantidade = 0;
	public static double precoTotal = 0;
	public static double precoPago = 0;
	public static ArrayList<Pedido> pedidos = new ArrayList<>();
	
	public static void main(String[] args) {
		
		do {
			
			while(codigo > Cardapio.PEDIDOS.length + 1 || codigo < 1) {
				
				codigo = PedeDados.getInt("Digite o c�digo do produto desejado:\n" + Cardapio.getCardapio(), true);
				
			}
			
			while(quantidade < 1) {
				
				quantidade = PedeDados.getInt("Qual a quantidade desses produto voc� deseja?", true);
				
			}
			
			pedidos.add(new Pedido(codigo, quantidade));
			
			codigo = 0;
			quantidade = 0;
			
		} while(PedeDados.perguntaBooleana("Deseja fazer mais um pedido?"));
		
		for(Pedido p: pedidos) {
		
			precoTotal += p.getPrecoTotal();
		
		}
		
		precoPago = PedeDados.getDouble("Pre�o Total: R$" + FORMATO_DECIMAL.format(precoTotal) + "\nQuanto ser� seu pagamento?" , precoTotal);
		
		
		JOptionPane.showMessageDialog(null, "Troco de R$" + FORMATO_DECIMAL.format((precoPago - precoTotal)));
		
	}

}
