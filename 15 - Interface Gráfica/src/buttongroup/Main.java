package buttongroup;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Main {

	public static void main(String[] args) {

		// Instancia JFrame
		JFrame formulario = new JFrame();
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setSize(320, 130);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Exemplo JFrame");
		formulario.setLayout(null);
		
		// JRadioButton
		JRadioButton rbtMatutino = new JRadioButton("Matutino");
		rbtMatutino.setBounds(10, 10, 100, 20);

		JRadioButton rbtVespertino = new JRadioButton("Vespertino");
		rbtVespertino.setBounds(110, 10, 100, 20);
		
		JRadioButton rbtNoturno = new JRadioButton("Noturno");
		rbtNoturno.setBounds(210, 10, 100, 20);

		//ButtonGroup
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbtNoturno);
		grupo.add(rbtVespertino);
		grupo.add(rbtMatutino);
		
		formulario.add(rbtMatutino);
		formulario.add(rbtVespertino);
		formulario.add(rbtNoturno);
		
		formulario.setVisible(true);

	}

}
