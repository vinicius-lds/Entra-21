package exercicios;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Exercicio08 {
	
	public final static DecimalFormat FORMATO_DECIMAL = new DecimalFormat("#0.00"); 

	public static void main(String[] args) throws Exception {
		
		String strAux = "";
		String[] strArrAux = null;
		double[] doubleArrAux = null;
		boolean boolAux = false;
		double doubleAux = Double.MIN_VALUE;
		
		int index = 0;
		double media = 0.0;
		String opcao = "";
		String[] opcoes = new String[] {"Cadastrar Aluno", "Excluir Aluno", "Estatísticas", "Encerrar Programa"};
		String[] sexos  = new String[] {"Masculino", "Feminino"};
		//nome, sexo, media, situacao
		String[][] alunos = new String[10][4];
		
		while(!opcao.equals("Encerrar Programa")) {
			
			opcao = (String) JOptionPane.showInputDialog(null,
									                     "Selecione uma ação!",
									                     "", 
									                     JOptionPane.PLAIN_MESSAGE,
									                     null,
									                     opcoes,
									                     "");
			
			switch (opcao) {
				case "Cadastrar Aluno":
					
					if(index < alunos.length) {
						while(alunos[index][0] == null) {
							
							strAux = JOptionPane.showInputDialog("Digite o nome do aluno");
							
							for (int i = 0; i < index; i++) {
								if(alunos[i][0].equals(strAux)) {
									boolAux = true;
									break;
								}
							}
							
							if(boolAux) {
								JOptionPane.showMessageDialog(null, "O nome " + strAux + " já foi cadastrado!");
							} else {
								alunos[index][0] = strAux;
							}
							
							boolAux = false;
							strAux = "";
							
						}
						
						alunos[index][1] = (String) JOptionPane.showInputDialog(null,
															                     "Selecione o sexo do aluno(a)!",
															                     "", 
															                     JOptionPane.PLAIN_MESSAGE,
															                     null,
															                     sexos,
															                     "");
						
						for (int i = 0; i < 3; i++) {
							while(doubleAux == Double.MIN_VALUE) {
								try {
									doubleAux = Double.parseDouble(JOptionPane.showInputDialog((i + 1) + "º nota"));
									if(doubleAux < 0 || doubleAux > 10) {
										doubleAux = Double.MIN_VALUE;
										JOptionPane.showMessageDialog(null, "Esta nota é inválida!");
									} else {
										media += doubleAux;
									}
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, "Esta nota é inválida!");
								}
							}
							doubleAux = Double.MIN_VALUE;
						}
						
						media /= 3;
						alunos[index][2] = String.valueOf(FORMATO_DECIMAL.format(media)).replaceAll(".", ",");
						
						if(media < 5) {
							alunos[index][3] = "Reprovado!";
						} else if(media < 7) {
							alunos[index][3] = "Recuperação!";
						} else {
							alunos[index][3] = "Aprovado!";
						}
						
						media = 0.0;
						index++;
						
					} else {
						JOptionPane.showMessageDialog(null, "Lista Cheia!");
					}
					
					break;
				case "Excluir Aluno":
					
					if(index > 0) {
						
						strArrAux = new String[index];
						for (int i = 0; i < index; i++) {
							strArrAux[i] = alunos[i][0];
						}
						
						strAux = (String) JOptionPane.showInputDialog(null,
												                      "Selecione um(a) aluno(a)!",
												                      "", 
												                      JOptionPane.PLAIN_MESSAGE,
												                      null,
												                      strArrAux,
												                      "");
						
						for (int i = 0; i < index; i++) {
							if(alunos[i][0].equals(strAux)) {
								for (int j = i; j < index; j++) {
									if(j < alunos.length - 1) {
										alunos[j] = alunos[j + 1];
									} else {
										alunos[j] = null;
									}
									if(alunos[j] == null) {
										break;
									}
								}
							} else {
								continue;
							}
							break;
						}
						
						strArrAux = null;
						index--;
						
					} else {
						JOptionPane.showMessageDialog(null, "Lista Vazia!");
					}
					
					break;
				case "Estatísticas":
					
					//reprovado, recuperacao, aprovado, masculino, feminino
					doubleArrAux = new double[5];
					
					for (int i = 0; i < index; i++) {
						switch (alunos[i][3]) {
							case "Reprovado!":
								doubleArrAux[0]++;				
								break;
							case "Recuperação!":
								doubleArrAux[1]++;
								break;
							case "Aprovado!":
								doubleArrAux[2]++;
								break;
							default:
								throw new Exception();
						}
						switch (alunos[i][1]) {
							case "Masculino":
								doubleArrAux[3]++;
								break;
							case "Feminino":
								doubleArrAux[4]++;
								break;
							default:
								throw new Exception();
						}
					}
					
					JOptionPane.showMessageDialog(null, "Percentual de meninas: " + FORMATO_DECIMAL.format((doubleArrAux[4] / (doubleArrAux[4] + doubleArrAux[3])) * 100) + "%"
														+ "\nPercentual de meninos: " + FORMATO_DECIMAL.format((doubleArrAux[3] / (doubleArrAux[4] + doubleArrAux[3])) * 100) + "%"
														+ "\nPercentual de alunos aprovados:  " + FORMATO_DECIMAL.format((doubleArrAux[2] / (doubleArrAux[0] + doubleArrAux[1] + doubleArrAux[2])) * 100) + "%"
														+ "\nPercentual de alunos em recuperação: " + FORMATO_DECIMAL.format((doubleArrAux[1] / (doubleArrAux[0] + doubleArrAux[1] + doubleArrAux[2])) * 100) + "%"
														+ "\nPercentual de alunos reprovados: " + FORMATO_DECIMAL.format((doubleArrAux[0] / (doubleArrAux[0] + doubleArrAux[1] + doubleArrAux[2])) * 100) + "%");
					
					break;
				case "Encerrar Programa":
					break;
				default:
					throw new IllegalArgumentException();
			}
			
		}
		
	}

}
