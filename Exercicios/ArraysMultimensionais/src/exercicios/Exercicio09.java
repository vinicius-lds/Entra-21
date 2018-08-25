package exercicios;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Exercicio09 {

	public static final DecimalFormat FORMATO_DECIMAL = new DecimalFormat("#0,00");
	
	public static void main(String[] args) {
		
		String[] strArrAux;
		String strAux = "";
		int intAux = 0;
		double doubleAux = 0.0;
		boolean boolAux = false;
		
		int indexFilme = 0;
		int indexUsuario = 0;
		int indexLocacoes = 0;
		
		//nome, genero, valor
		String[][] filmes = new String[10][3];
		//nome (primary_key), idade, endereco, telefone, email
		String[][] usuarios = new String[10][5];
		//usuario, filme, qtd dias, valor filmes, total a pagar
		String[][] locacoes = new String[10][5];
		
		String[] generos = new String[10];
		String[] opcoes = new String[] {"Cadastrar filme", 
										"Cadastrar usuário", 
										"Locar filme", 
										"Excluir filme", 
										"Excluir usuário", 
										"Filmes locados",
										"Encerrar programa"};
		String opcao = "";
		
		while(!opcao.equals("Encerrar programa")) {
			
			opcao = (String) JOptionPane.showInputDialog(null,
									                     "Selecione uma ação!",
									                     "", 
									                     JOptionPane.PLAIN_MESSAGE,
									                     null,
									                     opcoes,
									                     "");
			
			switch (opcao) {
				case "Cadastrar filme":
					
					while(filmes[indexFilme][0] == null) {
						filmes[indexFilme][0] = JOptionPane.showInputDialog("Nome do Filme");
						if(filmes[indexFilme][0].equals("")) {
							filmes[indexFilme][0] = null;
							JOptionPane.showMessageDialog(null, "Nome Inválido!");
						}
					}
					
					filmes[indexFilme][1] = (String) JOptionPane.showInputDialog(null,
															                     "Selecione uma gênero!",
															                     "", 
															                     JOptionPane.PLAIN_MESSAGE,
															                     null,
															                     generos,
															                     "");
					
					while(filmes[indexFilme][2] == null) {
						try {
							filmes[indexFilme][2] = String.valueOf(FORMATO_DECIMAL.format(Double.parseDouble(JOptionPane.showInputDialog("Valor do Aluguel do Filme").replace(',', '.')))).replace('.', ',');
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "O Valor inserido é inválido");
						}
					}
					
					indexFilme++;
					
					break;
				case "Cadastrar usuário":
					
					while(usuarios[indexUsuario][0] == null) {
						
						usuarios[indexUsuario][0] = JOptionPane.showInputDialog("Nome do Usuário");
						
						if(usuarios[indexUsuario][0].equals("")) {
							usuarios[indexUsuario][0] = null;
							JOptionPane.showMessageDialog(null, "Nome Inserido é Inválido!");
							continue;
						}
						
						for (int i = 0; i < indexUsuario; i++) {
							if(usuarios[i][0].equals(usuarios[indexUsuario][0])) {
								usuarios[indexUsuario][0] = null;
							}
						}
						
					}
					
					while(usuarios[indexUsuario][1] == null) {
						
						try {
							intAux = Integer.valueOf(JOptionPane.showInputDialog("Idade do usário"));
							if(intAux > 120 || intAux < 0) {
								throw new IllegalArgumentException();
							}
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Idade Inválida!");
						}
						
						usuarios[indexUsuario][1] = String.valueOf(intAux);
						intAux = 0;
						
					}
					
					usuarios[indexUsuario][2] = JOptionPane.showInputDialog("Endereço");
					usuarios[indexUsuario][3] = JOptionPane.showInputDialog("Telefone");
					usuarios[indexUsuario][4] = JOptionPane.showInputDialog("E-mail");
					
					indexUsuario++;
					
					break;
				case "Locar filme":
					
					if(indexUsuario < 1 || indexFilme < 1) {
						JOptionPane.showMessageDialog(null, "Não a dados suficientes para tal operação.");
					} else {
						
						strArrAux = new String[10];
						for (int i = 0; i < usuarios.length; i++) {
							strArrAux[i] = usuarios[i][0];
						}
						strAux = (String) JOptionPane.showInputDialog(null,
													                     "Selecione um cliente!",
													                     "", 
													                     JOptionPane.PLAIN_MESSAGE,
													                     null,
													                     strArrAux,
													                     "");
						locacoes[indexLocacoes][0] = strAux;
						
						strArrAux = new String[10];
						for (int i = 0; i < filmes.length; i++) {
							strArrAux[i] = filmes[i][0];
						}
						strAux = (String) JOptionPane.showInputDialog(null,
													                     "Selecione um filme!",
													                     "", 
													                     JOptionPane.PLAIN_MESSAGE,
													                     null,
													                     strArrAux,
													                     "");
						locacoes[indexLocacoes][1] = strAux;
						
						while(intAux == 0) {
							
							try {
								intAux = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Dias"));
								if(intAux < 1) {
									intAux = 0;
									throw new IllegalArgumentException();
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Quantidade de Dias Inválida!");
							}
							
						}
						
						locacoes[indexLocacoes][2] = String.valueOf(intAux);
						intAux = 0;
						
						for (int i = 0; i < indexFilme; i++) {
							if(filmes[i][0].equals(locacoes[indexLocacoes][0])) {
								intAux = i;
							}
						}
						
						System.out.println(intAux);
						
						locacoes[indexLocacoes][3] = filmes[intAux][2];
						System.out.println("assca");
						System.out.println(filmes[intAux][2]);
						System.out.println(filmes[intAux][2].replace('.', ','));
						System.out.println(Integer.parseInt(locacoes[indexLocacoes][2]));
						locacoes[indexLocacoes][4] = String.valueOf(Integer.parseInt(locacoes[indexLocacoes][2]) * Integer.parseInt(filmes[intAux][2].replace('.', ',')));
						
						indexLocacoes++;
						
					}
					
					break;
				case "Excluir filme":
					
					break;
				case "Excluir usuário":
					
					break;
				case "Filmes locados":
					
					for (int i = 0; i < indexLocacoes; i++) {
						strAux += locacoes[i][0]
								+ "\n" + locacoes[i][1]
								+ "\n" + locacoes[i][2]
								+ "\n" + locacoes[i][3]
								+ "\n" + locacoes[i][4]
								+ "--------------------";
					}
					JOptionPane.showMessageDialog(null, strAux);
					strAux = "";
					
					break;
				case "Encerrar programa":
					                                                     
					break;
	
				default:
					throw new IllegalArgumentException();
			}
			
		}
		
	}

}
