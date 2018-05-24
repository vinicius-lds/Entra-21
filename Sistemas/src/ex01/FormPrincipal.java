package ex01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FormPrincipal {
	
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
				new FormProdutos();
			}
			
		});
		
		btn_realizarPedidos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FormPedidos();
			}
			
		});
		
		form.add(btn_cadastrarProdutos);
		form.add(btn_realizarPedidos);
		form.add(btn_historico);
		form.add(btn_estatisticas);
		form.setVisible(true);
		
	}
	
}
