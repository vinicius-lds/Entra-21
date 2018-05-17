package jtextfield;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		
		//Instancia JFrame
		JFrame formulario = new JFrame();
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setSize(320, 90);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Exemplo JFrame");
		formulario.setLayout(null);
		
		//JLabel
		JLabel rotulo = new JLabel("Informe seu nome");
		rotulo.setBounds(10, 10, 150, 20);
		
		//JTextField
		JTextField campo = new JTextField();
		campo.setBounds(140, 10, 150, 20);
		
		formulario.add(rotulo);
		formulario.add(campo);
		
		formulario.setVisible(true);
		
	}

}
