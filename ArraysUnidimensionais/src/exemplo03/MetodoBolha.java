package exemplo03;

public class MetodoBolha {

	public static void main(String[] args) {

		int[] numeros = new int[] {5,1,2,5,21,5};
		int aux;
		/*
		for (int i = 0; i < numeros.length - 1; i++) {
			for (int j = i + 1; j < numeros.length; j++) {
				if(numeros[j] < numeros[i]) {
					aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
				}
			}
		}
		*/
		
		for (int i = 1; i < numeros.length; i++) {
			for (int j = i; j > 0; j--) {
				if(numeros[j] < numeros[j - 1]) {
					aux = numeros[j - 1];
					numeros[j - 1] = numeros[j];
					numeros[j] = aux;
				}
			}
		}
		
		
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
	}

}
