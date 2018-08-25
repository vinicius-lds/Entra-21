package exercicio04;

public class Ruim extends Avaliacao {
	
	public static Ruim avaliacao;
	
	private Ruim() {
		super.quantidade = 0;
	}
	
	public static Ruim getInstance() {
		if(avaliacao == null) {
			avaliacao = new Ruim();
		}
		return avaliacao;
	}
	
	@Override
	public String toString() {
		return "Ruim";
	}
	
}
