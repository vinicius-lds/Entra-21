package jlabel;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {
		
		//Instancia JFrame
		JFrame formulario = new JFrame();
		formulario.setVisible(true);
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setSize(500, 300);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Exemplo JFrame");
		formulario.setLayout(null);
		
		//Instancia JLabel		
		JLabel rotulo = new JLabel();
		rotulo.setText("Olá Mundo!");
		//margin-top, margin-left, width, height
		rotulo.setBounds(0, 0, 300, 20);
		
		formulario.add(rotulo);
		
	}

}
