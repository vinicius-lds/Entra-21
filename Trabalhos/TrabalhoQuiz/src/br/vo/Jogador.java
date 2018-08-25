package br.vo;

import java.util.ArrayList;

/**
 * @author 104884
 */
public class Jogador {

    private static ArrayList<Jogador> jogadores = new ArrayList<>();
    
    public static boolean existeJogador(String nome) {
        for(Jogador j: jogadores) {
            if(j.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    } 
    
    public static void addJogador(Jogador j) {
        jogadores.add(j);
    }
    
    public static ArrayList<Jogador> getJogadores() {
        return jogadores;
    }
    
    private String nome;
    private Long score;
    private Integer acertos;
    private Long ms;
    
    public Jogador(String nome) {
        this.setNome(nome);
        this.acertos = 0;
        this.score = Long.parseLong("0");
        this.ms = Long.parseLong("0");
        Jogador.addJogador(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null) {
            throw new NullPointerException();
        }
        if(existeJogador(nome)) {
            throw new IllegalArgumentException("Já existe um jogador cadastrado com esse nome!");
        }
        if(nome.equals("")) {
            throw new IllegalArgumentException("O nome não pode ser vazio!");
        }
        this.nome = nome;
    }
    
    public void incAcertos() {
        this.acertos++;
        System.out.println("Quantidade de acertos " + this.acertos);
    }
    
    public void incScore(long ms) {
        this.ms += (ms / 100);
        this.score = ((this.ms) + (this.acertos * 600)) / 10;
        System.out.println(this.score);
    }

    public long getScore() {
        return score;
    }

    public int getAcertos() {
        return acertos;
    }
    
}
