import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Random aleatorio = new Random();
		int[] vetor = new int[5];
		int numero;
		
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = aleatorio.nextInt(21);
			for (int j = i; j >= 0; j--) {
				if(vetor[j] == vetor[i]) {
					if(j == i) { continue; }
					i--;
					break;
				}
			}
		}
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
		
		
	}

}
