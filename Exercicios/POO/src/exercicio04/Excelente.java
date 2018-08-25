package exercicio04;

public class Excelente extends Avaliacao {
	
	public static Excelente avaliacao;
	
	private Excelente() {
		super.quantidade = 0;
	}
	
	public static Excelente getInstance() {
		if(avaliacao == null) {
			avaliacao = new Excelente();
		}
		return avaliacao;
	}
	
	@Override
	public String toString() {
		return "Excelente";
	}
	
}
