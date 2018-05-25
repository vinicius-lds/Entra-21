package ex01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FormPrincipal {
	
	public static JFrame frameAberto = new JFrame();
	
	public static void main(String[] args) {
		
		JFrame form = new JFrame("Lanchonete");
		form.setResizable(false);
		form.setAlwaysOnTop(true);
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.setBounds(0, 6, 520, 70);
		form.setLayout(null);
		
		JButton btn_cadastrarProdutos = new JButton("Cadastrar Produtos");
		btn_cadastrarProdutos.setBounds(10, 10, 146, 20);
		
		JButton btn_realizarPedidos = new JButton("Realizar Pedido");
		btn_realizarPedidos.setBounds(166, 10, 122, 20);
		
		JButton btn_historico = new JButton("Histórico");
		btn_historico.setBounds(298, 10, 85, 20);
		
		JButton btn_estatisticas = new JButton("Estatísticas");
		btn_estatisticas.setBounds(393, 10, 101, 20);
		
		btn_cadastrarProdutos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameAberto.dispose();
				frameAberto = new FormProdutos().getFormulario();
			}
			
		});
		
		btn_realizarPedidos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameAberto.dispose();
				if(Produto.getProdutos().size() > 0) {
					frameAberto = new FormPedidos().getFormulario();
				} else {
					JOptionPane.showMessageDialog(null, "Não existe nenhum produto cadastrado!");
				}
			}
			
		});
		
		btn_historico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frameAberto.dispose();
				frameAberto = new FormHistorico().getFormulario();
			}
		});
		
		form.add(btn_cadastrarProdutos);
		form.add(btn_realizarPedidos);
		form.add(btn_historico);
		form.add(btn_estatisticas);
		form.setVisible(true);
		
	}
	
}
