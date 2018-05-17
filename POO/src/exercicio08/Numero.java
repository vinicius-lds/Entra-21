package exercicio08;

public class Numero {
	
	private static Numero numero;
	
	private int numParam;
	
	private Numero() {}
	
	public static Numero getInstance(int num) {
		if(numero == null) {
			numero = new Numero();
		}
		numero.setNumParam(num);
		return numero;
	}
	
	private void setNumParam(int num) {
		this.numParam = num;
	}
	
	public String getNumeros() {
		String aux = "Antecessores: ";
		for (int i = 1; i <= 10; i++) {
			aux += (numParam - i) + " ";
		}
		aux += "\nSucessores: ";
		for (int i = 1; i <= 10; i++) {
			aux += (numParam + i) + " ";
		}
		return aux;
	}
}
