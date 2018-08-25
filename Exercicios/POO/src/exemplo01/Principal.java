package exemplo01;

public class Principal {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Ricardo");
		p1.setIdade(23);
		p1.setAltura(1.8);
		p1.setPeso(73.4);
		p1.apresentacao();
		p1.exibirIMC();
		
		/*Pessoa p2 = new Pessoa();
		p2.setNome("Andressa");
		p2.setIdade(16);
		p2.setAltura(1.67);
		p2.setPeso(56.3);
		p2.apresentacao();
		p2.exibirIMC();*/
		
	}

}
