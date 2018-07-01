package br.vo.tema;

import br.vo.Pergunta;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author 104884
 */
public abstract class Tema {

    private String nome;
    private ArrayList<Pergunta> perguntas;
    private int[] perguntasSorteadas;
    private int index;

    public Tema() {
        
    }
    /*
    public Tema(String nome, ArrayList<Pergunta> perguntas) {
        this.nome = nome;
        this.perguntas = perguntas;
        this.sortearPerguntas();
    }
    */
    public abstract void iniciarPerguntas();
    
    public String getNome() {
        return nome;
    }

    public void sortearPerguntas() {
        this.index = 0;
        this.perguntasSorteadas = new int[13];
        Random r = new Random();
        for (int i = 0; i < perguntasSorteadas.length; i++) {
            perguntasSorteadas[i] = r.nextInt(this.perguntas.size());
            for (int j = i; j >= 0; j--) {
                if (perguntasSorteadas[j] == perguntasSorteadas[i]) {
                    if (j == i) {
                        continue;
                    }
                    i--;
                    break;
                }
            }
        }
    }
    
    public Pergunta getPergunta() throws IndexOutOfBoundsException {
        return this.perguntas.get(this.perguntasSorteadas[index++]);
    }

    public void setNome(String nome) {
        if (nome.equals("")) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        this.nome = nome;
    }

    protected ArrayList<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(ArrayList<Pergunta> perguntas) {
        if (perguntas.size() < 13) {
            throw new IllegalArgumentException("Deve ter no mínimo 13 perguntas!");
        }
        this.perguntas = perguntas;
    }

    public void addPergunta(Pergunta p) {
        this.getPerguntas().add(p);
    }

    public void removePergunta(Pergunta p) {
        this.getPerguntas().remove(p);
    }

    public void removePergunta(int i) {
        this.getPerguntas().remove(i);
    }

}
