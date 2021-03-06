package ex01;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Main {
	
	public static void main(String[] args) {
		
		JFrame formulario = new JFrame();
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setSize(290, 160);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Exercicio 01");
		formulario.setResizable(false);
		formulario.setLayout(null);
		

		Label lbl_nome   = new Label("Nome: ");
		Label lbl_idade  = new Label("Idade: ");
		Label lbl_cidade = new Label("Cidade: ");
		lbl_nome.setBounds(10, 10, 50, 20);
		lbl_idade.setBounds(10, 40, 50, 20);
		lbl_cidade.setBounds(10, 70, 50, 20);
		
		JTextField tf_nome   = new JTextField();
		JTextField tf_idade  = new JTextField();
		JTextField tf_cidade = new JTextField();
		tf_nome.setBounds(60, 10, 200, 20);
		tf_idade.setBounds(60, 40, 200, 20);
		tf_cidade.setBounds(60, 70, 200, 20);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.setBounds(95, 100, 100, 20);
		
		btn_cadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tf_nome.getText().equals("") || tf_cidade.getText().equals("") || Main.validaIdade(tf_idade.getText())) {
					JOptionPane.showMessageDialog(null, "Os Dados Inseridos s�o inv�lidos!");
				} else {
					JOptionPane.showMessageDialog(null, "Ol� " + tf_nome.getText() + ", voc� tem " + tf_idade.getText() + " anos e mora em " + tf_cidade.getText() + "!");
				}
				
			}
		});

		formulario.add(lbl_nome);
		formulario.add(lbl_idade);
		formulario.add(lbl_cidade);
		formulario.add(tf_nome);
		formulario.add(tf_idade);
		formulario.add(tf_cidade);
		formulario.add(btn_cadastrar);
		formulario.setVisible(true);
		
	}
	
	public static boolean validaIdade(String str) {
		if(str.length() > 2 || str.length() < 1) {
			return true;
		}
		try {
			Double.parseDouble(str);
			return false;
		} catch (Exception e) {
			return true;
		}
	}
	
}
