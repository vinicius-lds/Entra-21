package exercicios;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Exercicio05 {

	public static void main(String[] args) {
		
		//nome, sexo, altura, peso, imc (peso*altura^2), situação
		String[][] imc = new String[20][6];
		int index = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite o nome da pessoa ou \"SAIR\" para encerra o programa: ");
		String strAux = entrada.nextLine();
		double doubleAux;
		
		while(!strAux.equalsIgnoreCase("SAIR")) {
			
			//0 recebe nome
			imc[index][0] = strAux;
			
			//1 recebe o sexo de acordo com o primeiro char digitado pela pessoa
			do {
				System.out.print("\nDigite o sexo da pessoa: ");
				try {
					strAux = String.valueOf(entrada.nextLine().charAt(0));
					switch (strAux) {	
						case "M":
						case "m": 
							imc[index][1] = "Masculino";
							break;
						case "F":
						case "f":
							imc[index][1] = "Feminino";
							break;
						default:
							imc[index][1] = "";
							break;
					}
				} catch(Exception e) {}
			} while(!(imc[index][1].equals("Masculino") || imc[index][1].equals("Feminino")));
			
			//Pede a altura e tenta converter pra double, se nao conseguir, seta aux como null e pede denovo
			while(imc[index][2] == null) {
				try {
					System.out.print("Digite a altura da pessoa: ");
					strAux = entrada.nextLine();
					if(Double.parseDouble(strAux.replace(",", ".")) < 0) {
						throw new IllegalArgumentException();
					}
					imc[index][2] = strAux;
				} catch(Exception e) {
					strAux = null;
				}
			}
			
			//Pede o peso e tenta converter pra double, se nao conseguir, seta aux como null e pede denovo
			while(imc[index][3] == null) {
				try {
					System.out.print("Digite o peso da pessoa: ");
					strAux = entrada.nextLine();
					if(Double.parseDouble(strAux.replace(",", ".")) < 0) {
						throw new IllegalArgumentException();
					}
					imc[index][3] = strAux;
				} catch(Exception e) {
					strAux = null;
				}
			}
			
			//calcula imc
			doubleAux = Double.parseDouble(imc[index][3].replace(",", ".")) / Math.pow(Double.parseDouble(imc[index][2].replace(",", ".")), 2.0);
			System.out.println(doubleAux);
			imc[index][4] = "" + doubleAux;
			if(doubleAux < 17) {
				imc[index][5] = "Muito Abaixo do Peso";
			} else if(doubleAux < 18.5) {
				imc[index][5] = "Abaixo do peso";
			} else if(doubleAux < 25) {
				imc[index][5] = "Peso normal";
			} else if(doubleAux < 30) {
				imc[index][5] = "Acima do peso";
			} else if(doubleAux < 35) {
				imc[index][5] = "Obesidade I";
			} else if(doubleAux < 40) {
				imc[index][5] = "Obesidade II (severa)";
			} else {
				imc[index][5] = "Obesidade III (mórbida)";
			}
			
			index++;
			
			System.out.print("Digite o nome da pessoa ou \"SAIR\" para encerra o programa: ");
			strAux = entrada.nextLine();
		}
		
		for (int i = 0; i < index; i++) {
			System.out.println(imc[i][0] + ", " + imc[i][1]);
			System.out.println(imc[i][2] + "cm, " + imc[i][3] + "kg");
			System.out.println("IMC: " + imc[i][4] + " Situação: " + imc[i][5]);
			System.out.println("----------------------------------------------");
		}
		
	}

}
