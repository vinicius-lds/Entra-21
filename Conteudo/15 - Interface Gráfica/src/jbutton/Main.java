package jbutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		
		//Instancia JFrame
		JFrame formulario = new JFrame();
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setSize(320, 130);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Exemplo JFrame");
		formulario.setLayout(null);
		
		//JLabel
		JLabel rotulo = new JLabel("Informe seu nome");
		rotulo.setBounds(10, 10, 150, 20);
		
		//JTextField
		JTextField campo = new JTextField();
		campo.setBounds(140, 10, 150, 20);
		
		//JButton
		JButton botao = new JButton();
		botao.setText("Clique Aqui!");
		botao.setBounds(80, 50, 150, 20);
		
		//Adicionar ação a botão
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Olá " + campo.getText() + "!");
				campo.setText("");
				campo.requestFocus();
				
			}
			
		});
		
		formulario.add(rotulo);
		formulario.add(campo);
		formulario.add(botao);
		
		formulario.setVisible(true);
		

	}

}
