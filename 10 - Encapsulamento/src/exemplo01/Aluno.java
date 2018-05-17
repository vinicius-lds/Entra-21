package exemplo01;

public class Aluno {
	
	private static int contador = 0;
	
	private String nome;
	private int idade;
	
	public Aluno() {
		System.out.println(++Aluno.contador + " aluno(s) cadastrado(s).");
	}
	
	public Aluno(String nome, int idade) {
		this.setNome(nome);
		this.setIdade(idade);
	}

	public Aluno(String nome) {
		this.setNome(nome);
	}
	
	public Aluno(int idade) {
		this.setIdade(idade);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

}
