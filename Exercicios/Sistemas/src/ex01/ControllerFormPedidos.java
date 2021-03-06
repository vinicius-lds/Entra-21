package ex01;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

public class ControllerFormPedidos {
	
	public static final DecimalFormat FORMATO_DECIMAL = new DecimalFormat("#0.00");
	public static Pedido pedido;
	public static boolean boolAux = false;
	
	public static void iniciaPedido() {
		pedido = new Pedido();
	}
	
	public static Pedido getPedido() {
		return pedido;
	}
	
	public static void atualizarTotal(JLabel lbl_total) {
		double aux = 0.0;
		for(Produto produto: pedido.getProdutos()) {
			aux += produto.getValor() * produto.getQuantidade();
		}
		lbl_total.setText("R$ " + FORMATO_DECIMAL.format(aux));
	}
	
	public static void atualizaNovoProduto(JComboBox<Produto> cb_produtos, JLabel lbl_exibirPreco, JLabel lbl_exibirPrecoTotal, JSpinner spn_quantidade) {
		Produto p = (Produto) cb_produtos.getSelectedItem();
		lbl_exibirPreco.setText("R$" + FORMATO_DECIMAL.format(p.getValor()));
		lbl_exibirPrecoTotal.setText("R$" + FORMATO_DECIMAL.format(p.getValor() * ((int) spn_quantidade.getValue())));
	}
	
	public static void atualizaQuantidadeProduto(JComboBox<Produto> cb_produtos, JLabel lbl_exibirPrecoTotal, JSpinner spn_quantidade) {
		Produto p = (Produto) cb_produtos.getSelectedItem();
		lbl_exibirPrecoTotal.setText("R$" + FORMATO_DECIMAL.format(p.getValor() * ((int) spn_quantidade.getValue())));
	}
	
	public static void adicionaProdutoTabela(JComboBox<Produto> cb_produtos, DefaultTableModel dtm_model, JSpinner spn_quantidade) {
		Produto p = (Produto) cb_produtos.getSelectedItem();
		boolean aux = false;
		for (int i = 0; i < dtm_model.getRowCount(); i++) {
			if(dtm_model.getValueAt(i, 0).equals(p.getNome())) {
				dtm_model.setValueAt(Integer.parseInt(dtm_model.getValueAt(i, 2).toString()) + (Integer.parseInt(spn_quantidade.getValue().toString())) , i, 2);
				dtm_model.setValueAt((Double)dtm_model.getValueAt(i, 1) * (Integer)dtm_model.getValueAt(i, 2), i, 3);
				aux = true;
				break;
			}
		}
		if(!aux) {
			p = p.getNewInstance((int) spn_quantidade.getValue());
			pedido.addProduto(p);
			dtm_model.addRow(p.getRow());
		}
	}
	
	public static void alteraProduto(DefaultTableModel dtm_model, int linha, JLabel lbl_exibirPrecoPedido) {
		Produto p = pedido.getProduto(dtm_model.getValueAt(linha, 0).toString());
		try {
			int qtdNova = Integer.parseInt(dtm_model.getValueAt(linha, 2).toString());
			if(qtdNova < 1) {
				throw new IllegalArgumentException("O valor " + qtdNova + " � inv�lido!");
			}
			p.setQuantidade(qtdNova);
			boolAux = true;
			dtm_model.setValueAt(((Double.parseDouble(dtm_model.getValueAt(linha, 1).toString())) * 
								  (Double.parseDouble(dtm_model.getValueAt(linha, 2).toString()))), linha, 3);
			ControllerFormPedidos.atualizarTotal(lbl_exibirPrecoPedido);
		} catch (Exception err) {
			dtm_model.setValueAt(p.getQuantidade(), linha, 2);
			JOptionPane.showMessageDialog(null, "Erro: Aqui " + err.getMessage());
		}
	}
	
	public static void removeProdutoTabela(DefaultTableModel dtm_model, JTable tab_carrinho, JLabel lbl_exibirPrecoPedido) {
		pedido.removeProduto(tab_carrinho.getSelectedRow());
		dtm_model.setNumRows(0);
		for(int i = 0; i < pedido.getProdutos().size(); i ++) {
			dtm_model.addRow(pedido.getProdutos().get(i).getRow());
		}
		ControllerFormPedidos.atualizarTotal(lbl_exibirPrecoPedido);
	}
	
	public static void finalizarPedido(JFrame formulario, DefaultTableModel dtm_model) {
		if(dtm_model.getRowCount() > 0) {
			String nomeCliente = JOptionPane.showInputDialog("Qual � o nome do cliente?");
			for(Produto p: pedido.getProdutos()) {
				Historico.addHistorico(new Historico(nomeCliente, LocalDateTime.now(), p));
			}
			formulario.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "N�o � poss�vel finalizar um pedido sem nenhum produto!");
		}
	}
	
}
