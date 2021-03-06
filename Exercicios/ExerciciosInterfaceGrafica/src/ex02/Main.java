package ex02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main {

	public static DecimalFormat DF = new DecimalFormat("#0.00");
	
	public static void main(String[] args) {
		
		JFrame formulario = new JFrame();
		formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		formulario.setSize(165, 95);
		formulario.setLocationRelativeTo(null);
		formulario.setTitle("Exercicio 02");
		formulario.setResizable(false);
		formulario.setLayout(null);
		
		JLabel lbl_preco = new JLabel("Pre�o Original");
		JTextField tf_preco = new JTextField();
		JLabel lbl_precoDesconto = new JLabel();
		
		lbl_preco.setBounds(5, 0, 150, 20);
		lbl_preco.setHorizontalAlignment(SwingConstants.CENTER);
		tf_preco.setBounds(5, 20, 150, 25);
		tf_preco.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_precoDesconto.setBounds(5, 45, 150, 20);
		lbl_precoDesconto.setHorizontalAlignment(SwingConstants.CENTER);
		
		tf_preco.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				StringBuilder conteudo = new StringBuilder(tf_preco.getText());
				boolean virgula = false;
				for (int i = 0; i < conteudo.length(); i++) {
					if(!Character.isDigit(conteudo.charAt(i))) {
						if(conteudo.charAt(i) == ',') {
							if(!virgula) {	
								virgula = true;
								continue;
							}
						}
						conteudo.setCharAt(i, (char) 0);
						continue;
					}
				}
				int aux = tf_preco.getCaretPosition();
				tf_preco.setText(conteudo.toString());
				tf_preco.setCaretPosition(aux);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					lbl_precoDesconto.setText(getPrecoDesconto(tf_preco.getText()));
					tf_preco.setText("");
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		formulario.add(lbl_preco);
		formulario.add(tf_preco);
		formulario.add(lbl_precoDesconto);
		formulario.setVisible(true);

	}
	
	public static String getPrecoDesconto(String text) {
		double aux;
		try {
			aux = Double.parseDouble(text.replace(',', '.'));
		} catch(Exception e) {
			return "";
		}
		System.out.println(aux);
		System.out.println(aux * 0.9);
		return ("R$" + (DF.format(aux * 0.9).replace('.', ',')));
	}

}
