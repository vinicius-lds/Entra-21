package exemplo02;

public class Condicional {

	public static void main(String[] args) {

		//Array de inteiros
		int[] idades = new int[]{5, 12, 18, 7, 23, 30, 40, 6};
		
		//Verificar se o candidato pode tirar a CNH
		for (int idade : idades) {
			System.out.println((idade < 18) ? idade + ": Não pode tirar CNH" : idade + ": Pode tirar CNH");
		}

	}

}
