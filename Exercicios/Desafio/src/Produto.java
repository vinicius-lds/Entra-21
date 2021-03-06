

public class Produto {
	
	private String nome;
	private double valor;
	private int quantidade;
	
	public Produto(String nome, double valor, int quantidade) {
		this.setNome(nome);
		this.setValor(valor);
		this.setQuantidade(quantidade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		if(valor <= 0) {
			throw new IllegalArgumentException("Valor inv�lido! " + valor);
		}
		this.valor =  valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if(quantidade < 0) {
			throw new IllegalArgumentException("Quantidade inv�lida! " + quantidade);
		}
		this.quantidade = quantidade;
	}
	
	public Object[] getRow() {
		return new Object[]{this, valor, quantidade};
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
	
}
