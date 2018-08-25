package jcheckbox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// Instancia JFrame
		JFrame formulario = new JFrame();
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setSize(230, 130);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Exemplo JFrame");
		formulario.setLayout(null);

		// JCheckBox
		JCheckBox cbxMasculino = new JCheckBox("Masculino");
		cbxMasculino.setBounds(10, 10, 100, 20);

		JCheckBox cbxFeminino = new JCheckBox("Feminino");
		cbxFeminino.setBounds(110, 10, 100, 20);

		// JButton
		JButton botao = new JButton();
		botao.setText("Clique Aqui!");
		botao.setBounds(32, 50, 150, 20);

		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if((cbxMasculino.isSelected() && cbxFeminino.isSelected()) || (!(cbxMasculino.isSelected() || cbxFeminino.isSelected()))) {
					JOptionPane.showMessageDialog(null, "Esta ação não é permitida!");
				}
				cbxFeminino.setSelected(false);
				cbxMasculino.setSelected(false);
				
			}
			
		});
		
		formulario.add(cbxMasculino);
		formulario.add(cbxFeminino);
		formulario.add(botao);

		formulario.setVisible(true);

	}

}
