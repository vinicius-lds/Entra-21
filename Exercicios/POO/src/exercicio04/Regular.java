package exercicio04;

public class Regular extends Avaliacao {
	
	public static Regular avaliacao;
	
	private Regular() {
		super.quantidade = 0;
	}
	
	public static Regular getInstance() {
		if(avaliacao == null) {
			avaliacao = new Regular();
		}
		return avaliacao;
	}
	
	@Override
	public String toString() {
		return "Regular";
	}
	
}
