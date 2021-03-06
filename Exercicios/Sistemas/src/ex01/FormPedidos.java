package ex01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class FormPedidos {

	public static JFrame formulario;

	public FormPedidos() {

		ControllerFormPedidos.iniciaPedido();

		formulario = new JFrame();
		formulario.setResizable(false);
		formulario.setSize(575, 320);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Fazer Pedido");
		formulario.setLayout(null);

		JLabel lbl_produto = new JLabel("Produto", SwingConstants.CENTER);
		JLabel lbl_preco = new JLabel("Preco", SwingConstants.CENTER);
		JLabel lbl_quantidade = new JLabel("Quantidade", SwingConstants.CENTER);
		JLabel lbl_precoTotal = new JLabel("Pre�o Total", SwingConstants.CENTER);

		JComboBox<Produto> cb_produtos = new JComboBox<Produto>(new Vector<Produto>(Produto.getProdutos()));
		JLabel lbl_exibirPreco = new JLabel("R$0,00", SwingConstants.CENTER);
		SpinnerModel sm = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		JSpinner spn_quantidade = new JSpinner(sm);
		JLabel lbl_exibirPrecoTotal = new JLabel("R$0,00", SwingConstants.CENTER);
		JButton btn_addCarrinho = new JButton("ADD");

		lbl_produto.setBounds(10, 10, 250, 20);
		lbl_preco.setBounds(260, 10, 65, 20);
		lbl_quantidade.setBounds(335, 10, 65, 20);
		lbl_precoTotal.setBounds(410, 10, 65, 20);

		cb_produtos.setBounds(10, 30, 250, 20);
		lbl_exibirPreco.setBounds(260, 30, 65, 20);
		spn_quantidade.setBounds(335, 30, 65, 20);
		lbl_exibirPrecoTotal.setBounds(410, 30, 65, 20);
		btn_addCarrinho.setBounds(485, 30, 65, 20);

		DefaultTableModel dtm_model = new DefaultTableModel(
				new String[] { "Produto", "Pre�o", "Quantidade", "Pre�o Total" }, 0);
		JTable tab_carrinho = new JTable(dtm_model) {
			boolean[] canEdit = new boolean[] { false, false, true, false };

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		};

		JScrollPane sp_tabelaProdutos = new JScrollPane(tab_carrinho);
		sp_tabelaProdutos.setBounds(10, 90, 540, 150);

		JLabel lbl_exibirPrecoPedido = new JLabel("", SwingConstants.LEFT);
		JButton btn_finalizarPedido = new JButton("Finalizar Pedido");

		lbl_exibirPrecoPedido.setBounds(10, 250, 100, 20);
		btn_finalizarPedido.setBounds(425, 250, 123, 20);

		cb_produtos.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				ControllerFormPedidos.atualizaNovoProduto(cb_produtos, lbl_exibirPreco, lbl_exibirPrecoTotal,
						spn_quantidade);
			}

			@Override
			public void focusGained(FocusEvent arg0) {

			}
		});

		spn_quantidade.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				ControllerFormPedidos.atualizaQuantidadeProduto(cb_produtos, lbl_exibirPrecoTotal, spn_quantidade);
			}

		});

		btn_addCarrinho.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {

				ControllerFormPedidos.adicionaProdutoTabela(cb_produtos, dtm_model, spn_quantidade);
				ControllerFormPedidos.atualizarTotal(lbl_exibirPrecoPedido);

			}

		});
		dtm_model.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getColumn() >= 0 && (!ControllerFormPedidos.boolAux)) {
					ControllerFormPedidos.alteraProduto(dtm_model, e.getLastRow(), lbl_exibirPrecoPedido);
				} else {
					ControllerFormPedidos.boolAux = false;
				}
			}

		});

		tab_carrinho.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 127 && ControllerFormPedidos.getPedido().getProdutos().size() > 0) {
					ControllerFormPedidos.getPedido().removeProduto(tab_carrinho.getSelectedRow());
					dtm_model.setNumRows(0);
					for (int i = 0; i < ControllerFormPedidos.getPedido().getProdutos().size(); i++) {
						dtm_model.addRow(ControllerFormPedidos.getPedido().getProdutos().get(i).getRow());
					}
					ControllerFormPedidos.atualizarTotal(lbl_exibirPrecoPedido);
				}
			}
		});

		btn_finalizarPedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerFormPedidos.finalizarPedido(formulario, dtm_model);
			}
		});

		formulario.add(lbl_produto);
		formulario.add(lbl_exibirPreco);
		formulario.add(lbl_exibirPrecoTotal);
		formulario.add(lbl_preco);
		formulario.add(lbl_produto);
		formulario.add(lbl_quantidade);
		formulario.add(lbl_precoTotal);
		formulario.add(lbl_exibirPrecoPedido);
		formulario.add(cb_produtos);
		formulario.add(spn_quantidade);
		formulario.add(btn_addCarrinho);
		formulario.add(btn_finalizarPedido);
		formulario.add(sp_tabelaProdutos);
		formulario.setVisible(true);

	}

	public JFrame getFormulario() {
		return this.formulario;
	}

}
