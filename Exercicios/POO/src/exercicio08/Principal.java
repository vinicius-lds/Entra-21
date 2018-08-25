package exercicio08;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		System.out.print("Digite um numero: ");
		System.out.println(Numero.getInstance(new Scanner(System.in).nextInt()).getNumeros());
		
	}

}
