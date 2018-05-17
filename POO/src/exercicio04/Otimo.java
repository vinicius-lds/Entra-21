package exercicio04;

public class Otimo extends Avaliacao {
	
	public static Otimo avaliacao;
	
	private Otimo() {
		super.quantidade = 0;
	}
	
	public static Otimo getInstance() {
		if(avaliacao == null) {
			avaliacao = new Otimo();
		}
		return avaliacao;
	}
	
	@Override
	public String toString() {
		return "Ótimo";
	}
	
}
