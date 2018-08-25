
package br.vo;

import br.enumeradores.Alternativa;
import java.util.ArrayList;

/**
 * @author 104884
 */
public class Pergunta {

    private String pergunta;
    private ArrayList<String> alternativas;
    private Alternativa resposta;

    public Pergunta(String pergunta, ArrayList<String> alternativas, Alternativa resposta) {
        this.setAternativas(alternativas);
        this.setResposta(resposta);
        this.setPergunta(pergunta);
    }

    public ArrayList<String> getAternativas() {
        return alternativas;
    }

    public void setAternativas(ArrayList<String> aternativas) {
        if(aternativas.size() != 4) {
            throw new IllegalArgumentException("Não pode haver uma pergunta com " + aternativas.size() + " alterantivas!");
        }
        this.alternativas = aternativas;
    }

    public Alternativa getResposta() {
        return resposta;
    }

    public void setResposta(Alternativa resposta) {
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    
    public String getAlternativa(Alternativa alt) {
        return this.getAternativas().get(alt.getIndex());
    }
    
}
