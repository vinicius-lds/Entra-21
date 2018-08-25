package exercicio04;

public class Bom extends Avaliacao {
	
	private static Bom avaliacao;
	
	private Bom() {
		super.quantidade = 0;
	}
	
	public static Bom getInstance() {
		if(avaliacao == null) {
			avaliacao = new Bom();
		}
		return avaliacao;
	}
	
	@Override
	public String toString() {
		return "Bom";
	}
	
}
