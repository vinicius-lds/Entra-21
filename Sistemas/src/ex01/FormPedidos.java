package ex01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
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
	
	public static final DecimalFormat FORMATO_DECIMAL = new DecimalFormat("#0.00"); 

	public FormPedidos() {
		
		Pedido pedido = new Pedido();
		
		JFrame formulario = new JFrame();
		formulario.setResizable(false);
		formulario.setSize(900, 300);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Fazer Pedido");
		formulario.setLayout(null);
		
		JLabel lbl_produto = new JLabel("Produto", SwingConstants.CENTER);
		JLabel lbl_preco = new JLabel("Preco", SwingConstants.CENTER);
		JLabel lbl_quantidade = new JLabel("Quantidade", SwingConstants.CENTER);
		JLabel lbl_precoTotal = new JLabel("Pre�o Total", SwingConstants.CENTER);
		
		JComboBox<Produto> cb_produtos = new JComboBox<Produto>(new Vector<Produto>(Produto.getProdutos()));
		JLabel lbl_exibirPreco = new JLabel("", SwingConstants.CENTER);
		SpinnerModel sm = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
		JSpinner spn_quantidade = new JSpinner(sm);
		JLabel lbl_exibirPrecoTotal = new JLabel("", SwingConstants.CENTER);
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
		
		DefaultTableModel dtm_model = new DefaultTableModel(new String[]{"Produto", "Pre�o", "Quantidade", "Pre�o Total"}, 0);
		JTable tab_carrinho = new JTable(dtm_model);
		JScrollPane sp_tabelaProdutos = new JScrollPane(tab_carrinho);
		sp_tabelaProdutos.setBounds(10, 90, 265, 150);
		
		cb_produtos.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				Produto p = (Produto) cb_produtos.getSelectedItem();
				lbl_exibirPreco.setText("R$" + FORMATO_DECIMAL.format(p.getValor()));
				lbl_exibirPrecoTotal.setText("R$" + FORMATO_DECIMAL.format(p.getValor() * ((int) spn_quantidade.getValue())));
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				
			}
		});
		
		spn_quantidade.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				Produto p = (Produto) cb_produtos.getSelectedItem();
				lbl_exibirPrecoTotal.setText("R$" + FORMATO_DECIMAL.format(p.getValor() * ((int) spn_quantidade.getValue())));
			}
		
		});
		
		btn_addCarrinho.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				Produto p = (Produto) cb_produtos.getSelectedItem();
				p = p.getNewInstance((int) spn_quantidade.getValue());
				pedido.addProduto(p);
				dtm_model.addRow(p.getRow());
				
			}
		
		});
		/*dtm_model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getColumn() >= 0) {
					try {
						Pedido p = Pedido.getPedidos().get(e.getLastRow());
						p.setNome(dtm_model.getValueAt(e.getLastRow(), 0).toString());
						p.setValor(Double.parseDouble(dtm_model.getValueAt(e.getLastRow(), 1).toString()));
					} catch (Exception err) {
						JOptionPane.showMessageDialog(null, "Erro: " + err.getMessage());
						Produto p = Produto.getProdutos().get(e.getLastRow());
						dtm_model.setValueAt(p.getNome(), e.getLastRow(), 0);
						dtm_model.setValueAt(p.getValor(), e.getLastRow(), 1);
					}
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
				if(e.getKeyCode() == 127 && Produto.getProdutos().size() > 0){
					Produto.removeProduto(tab_carrinho.getSelectedRow());
					dtm_model.setNumRows(0);
					for(int i = 0; i < Produto.getProdutos().size(); i ++) {
						dtm_model.addRow(new Object[] {Produto.getProdutos().get(i).getNome(), 
													   Produto.getProdutos().get(i).getValor()});
					}
					
				}
			}
		});*/
		
		formulario.add(lbl_produto);
		formulario.add(lbl_exibirPreco);
		formulario.add(lbl_exibirPrecoTotal);
		formulario.add(lbl_preco);
		formulario.add(lbl_produto);
		formulario.add(lbl_quantidade);
		formulario.add(lbl_precoTotal);
		formulario.add(cb_produtos);
		formulario.add(spn_quantidade);
		formulario.add(btn_addCarrinho);
		formulario.add(sp_tabelaProdutos);
		formulario.setVisible(true);
		
	}
	
	
	
}
