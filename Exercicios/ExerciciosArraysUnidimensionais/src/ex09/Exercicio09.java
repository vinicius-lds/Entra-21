package ex09;

import javax.swing.JOptionPane;

public class Exercicio09 {

	public static void main(String[] args) throws Exception {

		String[] nomes 		= new String[10];
		double[] valores 	= new double[10];
		int   [] qtds 		= new int	[10];
		int index = 0;
		
		String opcao = "";
		
		while(!opcao.equals("Encerrar Programa")) {
			
			opcao = (String) JOptionPane.showInputDialog(null,
									                     "Selecione uma ação!",
									                     "", 
									                     JOptionPane.PLAIN_MESSAGE,
									                     null,
									                     new String[]{"Cadastrar", "Listar", "Alterar", "Excluir", "Encerrar Programa"},
									                     "");
			switch (opcao) {
				case "Cadastrar":
					if(index >= 10) {
						JOptionPane.showMessageDialog(null, "Já foram cadastrados o número máximo de produtos.");
						break;
					} else {
						boolean nomeValido = false;
						String nome = "";
						double preco = Double.MIN_VALUE;
						int qtd = Integer.MIN_VALUE;
						while(!nomeValido) {
							nome = JOptionPane.showInputDialog("Nome do Produto");
							nomeValido = true;
							for (int i = 0; i < index + 1; i++) {
								if(nome == nomes[i]) {
									nomeValido = false;
									break;
								}
							}
						}
						while(preco == Double.MIN_VALUE) {
							try {
								preco = Double.parseDouble(JOptionPane.showInputDialog("Preço"));
								if(preco < 0) {
									preco = Double.MIN_VALUE;
									throw new IllegalArgumentException();
								}
							} catch(Exception e) {
								JOptionPane.showMessageDialog(null, "O preço é inválido!");
							}
						}
						while(qtd == Integer.MIN_VALUE) {
							try {
								qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
								if(qtd < 0) {
									qtd = Integer.MIN_VALUE;
									throw new IllegalArgumentException();
								}
							} catch(Exception e) {
								JOptionPane.showMessageDialog(null, "A quantidade é inválida!");
							}
						}
						nomes[index] = nome;
						valores[index] = preco;
						qtds[index] = qtd;
						index++;
					}
					break;
				case "Listar":
					String str = "";
					for (int i = 0; i < index; i++) {
						str += nomes[i] + " R$" + valores[i] + " QUANTIDADE: " + qtds[i] + " unidades.\n"; 
					}
					JOptionPane.showMessageDialog(null, str);
					break;
				case "Alterar":
					int j = -1;
					String produto = JOptionPane.showInputDialog("Qual produto deseja alterar?");
					while(j < 0) {
						for (int i = 0; i < index; i++) {
							if(nomes[i].equals(produto)) {
								j = i;
								break;
							}
						}
						if(j < 0) {
							JOptionPane.showMessageDialog(null, "O produto requisitado não foi encontrado!");
						}
					}
					nomes[j] = JOptionPane.showInputDialog("Alterar para:");
					double preco = Double.MIN_VALUE;
					int qtd = Integer.MIN_VALUE;
					while(preco == Double.MIN_VALUE) {
						try {
							preco = Double.parseDouble(JOptionPane.showInputDialog("Preço"));
							if(preco < 0) {
								preco = Double.MIN_VALUE;
								throw new IllegalArgumentException();
							}
						} catch(Exception e) {
							JOptionPane.showMessageDialog(null, "O preço é inválido!");
						}
					}
					while(qtd == Integer.MIN_VALUE) {
						try {
							qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
							if(qtd < 0) {
								qtd = Integer.MIN_VALUE;
								throw new IllegalArgumentException();
							}
						} catch(Exception e) {
							JOptionPane.showMessageDialog(null, "A quantidade é inválida!");
						}
					}
					valores[j] = preco;
					qtds[j] = qtd;
					break;
				case "Excluir":
					int k = -1;
					String prExcluir = JOptionPane.showInputDialog("Qual produto deseja excluir?");
					while(k < 0) {
						for (int i = 0; i < index; i++) {
							if(nomes[i].equals(prExcluir)) {
								k = i;
								break;
							}
						}
						if(k < 0) {
							JOptionPane.showMessageDialog(null, "O produto requisitado não foi encontrado!");
						}
					}
					System.out.println(k);
					System.out.println(index);
					try {
						for (int i = k; i < index; i++) {
							System.out.println(nomes[i + 1]);
							nomes[i] = nomes[i + 1];
							valores[i] = valores[i + 1];
							qtds[i] = qtds[i + 1];
						}
					} catch (IndexOutOfBoundsException e) {
						nomes[k] = null;
						valores[k] = 0;
						qtds[k] = 0;
					}
					index--;
					break;
				case "Encerrar Programa":
					break;

				default:
					throw new Exception();
			}
		
		}
		
	}

}
