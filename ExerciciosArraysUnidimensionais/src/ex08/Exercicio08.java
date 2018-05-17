package ex08;

import javax.swing.JOptionPane;

public class Exercicio08 {

	public static void main(String[] args) {

		String[] usuarios = new String[]{"user1", "user2", "user3"};
		String[] senhas	  = new String[]{"12345", "12345", "12345"};
		String usuario;
		String senha;
		boolean login = false;
		
		while(!login) {
			usuario = JOptionPane.showInputDialog("Usuário");
			senha = JOptionPane.showInputDialog("Senha");
			for (int i = 0; i < usuarios.length; i++) {
				if((usuario.equals(usuarios[i])) && (senha.equals(senhas[i]))) {
					login = true;
					break;
				}
			}
			if(!login) {
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
			}
		}
		
		JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
		
	}

}
