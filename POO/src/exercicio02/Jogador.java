package exercicio02;


public class Jogador {
    private String nome;
    private int idade;
    private double altura;
    private double peso;

    public Jogador(String nome, int idade, double altura, double peso) {
        this.altura = altura;
        this.idade = idade;
        this.peso = peso;
        this.nome = nome;
    }

    public Jogador() {
    }

    public Jogador clone() {
        return new Jogador(this.nome, this.idade, this.altura, this.peso);
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(String altura) {
        this.altura = Double.parseDouble(altura);
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(String idade) {
        this.idade = Integer.parseInt(idade);
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(String peso) {
        this.peso = Double.parseDouble(peso);
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

}