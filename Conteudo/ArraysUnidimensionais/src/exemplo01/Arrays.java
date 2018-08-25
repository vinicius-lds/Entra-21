package exemplo01;

public class Arrays {

	public static void main(String[] args) {

		//Vetores
		String[] nomes = new String[3];
		
		//Atribui��o de valores ao vetor
		nomes[0] = "Alice";
		nomes[1] = "Bryan";
		nomes[2] = "Caroline";
		
		//#1 - Exibi��o dos valores do vetor
		System.out.println(nomes[0]);
		System.out.println(nomes[1]);
		System.out.println(nomes[2]);
		
		//#2 - Exibi��o dos valores do vetor
		int index = 0;
		do {
			System.out.println("do while: " + nomes[index]);
			index++;
		} while(index < nomes.length);
		
		//#3 - Exibi��o dos valores do vetor
		for(int i = 0; i < nomes.length; i++) {
			System.out.println("for: " + nomes[i]);
		}
		
		//#4 - Exibi��o dos valores do vetor
		for(String nome: nomes) {
			System.out.println("foreach: " + nome);
		}
		
	}

}
