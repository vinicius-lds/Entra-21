package jradiobutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Main {

	public static void main(String[] args) {

		// Instancia JFrame
		JFrame formulario = new JFrame();
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setSize(230, 130);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Exemplo JFrame");
		formulario.setLayout(null);

		// JRadioButton
		JRadioButton rbtMasculino = new JRadioButton("Masculino");
		rbtMasculino.setBounds(10, 10, 100, 20);

		JRadioButton rbtFeminino = new JRadioButton("Feminino");
		rbtFeminino.setBounds(110, 10, 100, 20);

		// JButton
		JButton botao = new JButton();
		botao.setText("Clique Aqui!");
		botao.setBounds(32, 50, 150, 20);
		
		//Ação
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if((rbtMasculino.isSelected() && rbtFeminino.isSelected()) || (!(rbtMasculino.isSelected() || rbtFeminino.isSelected()))) {
					JOptionPane.showMessageDialog(null, "Esta ação não é permitida!");
				}
				rbtFeminino.setSelected(false);
				rbtMasculino.setSelected(false);
				
			}
		});
		
		formulario.add(rbtMasculino);
		formulario.add(rbtFeminino);
		formulario.add(botao);

		formulario.setVisible(true);

	}

}
