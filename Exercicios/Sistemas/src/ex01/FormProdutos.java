package ex01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class FormProdutos {

	private JFrame formulario;
	
	public FormProdutos() {
	
		formulario = new JFrame();
		formulario.setResizable(false);
		formulario.setSize(290, 280);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Cadastrar Produtos");
		formulario.setLayout(null);
		
		JLabel lbl_produto = new JLabel("Produto");
		JLabel lbl_valor = new JLabel("Valor");
		
		JTextField tf_produto = new JTextField();
		JTextField tf_valor = new JTextField();
		
		JButton btn_cadatrar = new JButton("Cadastrar");
		
		lbl_produto.setBounds(10, 10, 65, 20);
		lbl_valor.setBounds(10, 30, 65, 20);
		
		tf_produto.setBounds(80, 10, 200, 20);
		tf_valor.setBounds(80, 30, 200, 20);
		
		btn_cadatrar.setBounds(100, 60, 95, 20);
		
		DefaultTableModel dtm_model = new DefaultTableModel(new String[]{"Produto", "Valor"}, 0);
		JTable tab_produtos = new JTable(dtm_model);
		JScrollPane sp_tabelaProdutos = new JScrollPane(tab_produtos);
		sp_tabelaProdutos.setBounds(10, 90, 265, 150);
		
		for(Produto p: Produto.getProdutos()) {
			dtm_model.addRow(p.getRow());
		}
		
		tf_valor.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		btn_cadatrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				try {
					if(!Produto.alreadyHas(tf_produto.getText())) {
						Produto novo = new Produto(tf_produto.getText(), 
												   Double.parseDouble(tf_valor.getText().replaceAll(",", ".")));
						Produto.addProduto(novo);
						dtm_model.addRow(novo.getRow());
						tf_produto.setText("");
						tf_valor.setText("");
					} else {
						throw new IllegalArgumentException("\"" + tf_produto.getText() + "\" j� est� cadastrado!");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
				}
				
			}
		});
		dtm_model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getColumn() >= 0) {
					try {
						Produto p = Produto.getProdutos().get(e.getLastRow());
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
		tab_produtos.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 127 && Produto.getProdutos().size() > 0){
					Produto.removeProduto(tab_produtos.getSelectedRow());
					dtm_model.setNumRows(0);
					for(int i = 0; i < Produto.getProdutos().size(); i ++) {
						dtm_model.addRow(new Object[] {Produto.getProdutos().get(i).getNome(), 
													   Produto.getProdutos().get(i).getValor()});
					}
					
				}
			}
		});
		
		formulario.add(lbl_produto);
		formulario.add(lbl_valor);
		formulario.add(tf_produto);
		formulario.add(tf_valor);
		formulario.add(btn_cadatrar);
		formulario.add(sp_tabelaProdutos);
		formulario.setVisible(true);
		
	
		
	}
	
	public JFrame getFormulario() {
		return formulario;
	}
	
}
