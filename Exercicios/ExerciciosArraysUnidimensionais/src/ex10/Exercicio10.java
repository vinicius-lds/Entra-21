package ex10;

import javax.swing.JOptionPane;

public class Exercicio10 {

	public static void main(String[] args) {

		String[] opcoes 	= new String[]{"Cadastrar Contato",
										   "Alterar Contato",
										   "Excluir Contato",
										   "Pesquisar Contato",
										   "Cadastrar Categoria",
										   "Alterar Categoria",
										   "Excluir Categoria",
										   "Lembrete de Aniversários",
										   "Encerrar Programa"};
		String[] nomes		= new String[10];
		String[] sobrenomes = new String[10];
		int	  [] diaDN 		= new int	[10];
		int	  [] mesDN 		= new int	[10];
		int	  [] anoDN 		= new int	[10];
		String[] emails		= new String[10];
		String[] celulares 	= new String[10];
		String[] enderecos 	= new String[10];
		String[] categorias = new String[10];
		
		String opcaoSelecionada = "";
		String strAux = "";
		boolean booAux = false;
		int intAux = 0;
		int indexContato = 0;
		int indexCategoria = 0;
		
		while(!opcaoSelecionada.equals("Encerrar Programa")) {
			opcaoSelecionada = (String) JOptionPane.showInputDialog(null,
												                    "Selecione uma ação!",
												                    "", 
												                    JOptionPane.PLAIN_MESSAGE,
												                    null,
												                    opcoes,
												                    "");
			
			switch (opcaoSelecionada) {
				case "Cadastrar Contato":
					if(categorias[0] == null) {
						JOptionPane.showMessageDialog(null, "Para cadastrar um contato é preciso primeiro cadastrar uma categoria!");
						break;
					} else if(indexContato == nomes.length) {
						JOptionPane.showMessageDialog(null, "O limite de cadastros foi atingido!");
					} else {
						nomes[indexContato] = JOptionPane.showInputDialog("Nome");
						sobrenomes[indexContato] = JOptionPane.showInputDialog("Sobrenome");
						while(diaDN[indexContato] == 0) {
							try {
								diaDN[indexContato] = Integer.parseInt(JOptionPane.showInputDialog("Data de Nascimento: Dia"));
								if((diaDN[indexContato] > 31) || (diaDN[indexContato] < 1)) {
									diaDN[indexContato] = 0;
									JOptionPane.showMessageDialog(null, "O Dia Exclohido é Inválido!");
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "O Dia Exclohido é Inválido!");
							}
						}
						while(mesDN[indexContato] == 0) {
							try {
								mesDN[indexContato] = Integer.parseInt(JOptionPane.showInputDialog("Data de Nascimento: Mês"));
								if((mesDN[indexContato] > 12) || (mesDN[indexContato] < 1)) {
									mesDN[indexContato] = 0;
									JOptionPane.showMessageDialog(null, "O Mês Exclohido é Inválido!");
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "O Mês Exclohido é Inválido!");
							}
						}
						while(anoDN[indexContato] == 0) {
							try {
								anoDN[indexContato] = Integer.parseInt(JOptionPane.showInputDialog("Data de Nascimento: Ano"));
								if((anoDN[indexContato] > 2018) || (anoDN[indexContato] < 1900)) {
									anoDN[indexContato] = 0;
									JOptionPane.showMessageDialog(null, "O Ano Exclohido é Inválido!");
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "O Ano Exclohido é Inválido!");
							}
						}
						while(emails[indexContato] == null || emails[indexContato].equals("")) {
							emails[indexContato] = JOptionPane.showInputDialog("E-mail");
						}
						while(celulares[indexContato] == null ||celulares[indexContato].equals("")) {
							celulares[indexContato] = JOptionPane.showInputDialog("Número de celular");
						}
						while(enderecos[indexContato] == null || enderecos[indexContato].equals("")) {
							enderecos[indexContato] = JOptionPane.showInputDialog("Endereço");
						}
						categorias[indexContato] = (String) JOptionPane.showInputDialog(null,
															                     "Selecione uma categoria!",
															                     "", 
															                     JOptionPane.PLAIN_MESSAGE,
															                     null,
															                     categorias,
															                     "");
						indexContato++;
					}
					break;
				case "Alterar Contato":
					if(indexContato == 0) {
						JOptionPane.showMessageDialog(null, "Não existem contatos para alterar!");
					} else {
						strAux = (String) JOptionPane.showInputDialog(null,
											                          "Selecione um contato!",
											                          "Alterar Contato", 
											                          JOptionPane.PLAIN_MESSAGE,
											                          null,
											                          nomes,
											                          "");
						for (int i = 0; i < indexContato; i++) {
							if(nomes[i].equals(strAux)) {
								intAux = i;
								break;
							}
						}
						nomes[intAux] = JOptionPane.showInputDialog("Nome");
						sobrenomes[intAux] = JOptionPane.showInputDialog("Sobrenome");
						diaDN[intAux] = 0;
						mesDN[intAux] = 0;
						anoDN[intAux] = 0;
						emails[intAux] = null;
						celulares[intAux] = null;
						enderecos[intAux] = null;
						while(diaDN[intAux] == 0) {
							try {
								diaDN[intAux] = Integer.parseInt(JOptionPane.showInputDialog("Data de Nascimento: Dia"));
								if((diaDN[intAux] > 31) || (diaDN[intAux] < 1)) {
									diaDN[intAux] = 0;
									JOptionPane.showMessageDialog(null, "O Dia Exclohido é Inválido!");
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "O Dia Exclohido é Inválido!");
							}
						}
						while(mesDN[intAux] == 0) {
							try {
								mesDN[intAux] = Integer.parseInt(JOptionPane.showInputDialog("Data de Nascimento: Mês"));
								if((mesDN[intAux] > 12) || (mesDN[intAux] < 1)) {
									mesDN[intAux] = 0;
									JOptionPane.showMessageDialog(null, "O Mês Exclohido é Inválido!");
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "O Mês Exclohido é Inválido!");
							}
						}
						while(anoDN[intAux] == 0) {
							try {
								anoDN[intAux] = Integer.parseInt(JOptionPane.showInputDialog("Data de Nascimento: Ano"));
								if((anoDN[intAux] > 2018) || (anoDN[intAux] < 1900)) {
									anoDN[intAux] = 0;
									JOptionPane.showMessageDialog(null, "O Ano Exclohido é Inválido!");
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "O Ano Exclohido é Inválido!");
							}
						}
						while(emails[intAux] == null || emails[intAux].equals("")) {
							emails[intAux] = JOptionPane.showInputDialog("E-mail");
						}
						while(celulares[intAux] == null ||celulares[intAux].equals("")) {
							celulares[intAux] = JOptionPane.showInputDialog("Número de celular");
						}
						while(enderecos[intAux] == null || enderecos[intAux].equals("")) {
							enderecos[intAux] = JOptionPane.showInputDialog("Endereço");
						}
						categorias[intAux] = (String) JOptionPane.showInputDialog(null,
															                     "Selecione uma categoria!",
															                     "", 
															                     JOptionPane.PLAIN_MESSAGE,
															                     null,
															                     categorias,
															                     "");
					}
					break;
				case "Excluir Contato":
					if(nomes[0] != null) {
						strAux = (String) JOptionPane.showInputDialog(null,
											                          "Selecione um contato!",
											                          "Excluir Contato", 
											                          JOptionPane.PLAIN_MESSAGE,
											                          null,
											                          nomes,
											                          "");
						for (int i = 0; i < indexContato; i++) {
							if(booAux) {
								nomes[i] = ((i + 1) != nomes.length) ? nomes[i + 1] : null;
								continue;
							}
							if(nomes[i].equals(strAux)) {
								nomes[i] = ((i + 1) != nomes.length) ? nomes[i + 1] : null;
								booAux = true;
							}
						}
						booAux = false;
						strAux = "";
						indexContato--;
					} else {
						JOptionPane.showMessageDialog(null, "Não há nenhum contato cadastrado!");
					}
					break;
				case "Pesquisar Contato":
					if(nomes[0] == null) {
						JOptionPane.showMessageDialog(null, "Não existem contatos para pesquisar!");
					} else {
						strAux = (String) JOptionPane.showInputDialog(null,
											                          "Selecione um contato!",
											                          "Excluir Contato", 
											                          JOptionPane.PLAIN_MESSAGE,
											                          null,
											                          nomes,
											                          "");
						for (int i = 0; i < indexContato; i++) {
							if(nomes[i].equals(strAux)) {
								strAux = nomes[i] + " " + sobrenomes[i]
										+ "\nTelefone celular: " + celulares[i]
										+ "\nE-mail: " + emails[i]
										+ "\nData de Nascimento: " + diaDN[i] + "/" + mesDN[i] + "/" + anoDN[i]
										+ "\nEndereço: " + enderecos[i]
										+ "\nCategoria: " + categorias[i];
								break;
							}
						}
						JOptionPane.showMessageDialog(null, strAux);
						strAux = "";
					}
					break;
				case "Cadastrar Categoria":
					if(indexCategoria == categorias.length) {
						JOptionPane.showMessageDialog(null, "O limite de categorias foir atingido!");
					}else {
						while(categorias[indexCategoria] == null || categorias[indexCategoria].equals("")) {
							categorias[indexCategoria] = JOptionPane.showInputDialog("Nome da Categoria");
						}
						indexCategoria++;
					}
					break;
				case "Alterar Categoria":
					if(categorias[0] == null) {
						JOptionPane.showMessageDialog(null, "Não existe categorias para alterar!");
					} else {
						strAux = (String) JOptionPane.showInputDialog(null,
											                       "Selecione uma categoria!",
											                       "Alterar Categoria", 
											                       JOptionPane.PLAIN_MESSAGE,
											                       null,
											                       categorias,
											                       "");
						for (int i = 0; i < indexCategoria; i++) {
							if(categorias[i].equals(strAux)) {
								categorias[i] = "";
								while(categorias[i].equals("")) {
									categorias[i] = JOptionPane.showInputDialog("Qual será o novo nome da categoria?");
									if(categorias[i].equals("")) {
										JOptionPane.showMessageDialog(null, "Nome de Categoria Inválido!");
									}
								}
							}
						}
						strAux = "";
					}
					break;
				case "Excluir Categoria":
					if(categorias[0] != null) {
						strAux = (String) JOptionPane.showInputDialog(null,
											                          "Selecione uma categoria!",
											                          "Excluir Categoria", 
											                          JOptionPane.PLAIN_MESSAGE,
											                          null,
											                          categorias,
											                          "");
						for (int i = 0; i < indexCategoria; i++) {
							if(booAux) {
								categorias[i] = ((i + 1) != categorias.length) ? categorias[i + 1] : null;
								continue;
							}
							if(categorias[i].equals(strAux)) {
								categorias[i] = ((i + 1) != categorias.length) ? categorias[i + 1] : null;
								booAux = true;
							}
						}
						booAux = false;
						strAux = "";
						indexCategoria--;
					} else {
						JOptionPane.showMessageDialog(null, "Não há nenhuma categoria cadastrada!");
					}
					break;
				case "Lembrete de Aniversários":
					strAux = (String) JOptionPane.showInputDialog(null,
											                       "Selecione um mes!",
											                       "Alterar Mês",
											                       JOptionPane.PLAIN_MESSAGE,
											                       null,
											                       new String[] {"01 - Janeiro",
												                     		     "02 - Fevereiro",
												                    		     "03 - Março",
												                    		     "04 - Abril",
												                    		     "05 - Maio",
												                    		     "06 - Junho",
												                    		     "07 - Julho",
												                    		     "08 - Agosto",
												                    		     "09 - Setembro",
												                    		     "10 - Outubro",
												                    		     "11 - Novembro",
												                    		     "12 - Dezembro"},
											                       "");
					intAux = Integer.parseInt(strAux.substring(0, 2));
					strAux = "Aniversariantes em " + strAux.substring(3, strAux.length()) + ":";
					for (int i = 0; i < indexContato; i++) {
						if(mesDN[i] == intAux) {
							strAux += "\n" + nomes[i] + " " + diaDN[i] + "/" + mesDN[i] + "/" + anoDN[i];
							booAux = true;
						}
					}
					if(booAux) {
						JOptionPane.showMessageDialog(null, strAux);
					} else {
						JOptionPane.showMessageDialog(null, "Sua busca não retornou resultados!");
					}
					strAux = "";
					intAux = 0;
					booAux = false;
					break;
				case "Encerrar Programa":
					break;
				default:
					throw new IllegalArgumentException();
			}
			
		}
		
	}

}
