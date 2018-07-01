/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo.tema;

import br.enumeradores.Alternativa;
import br.vo.Pergunta;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 104884
 */
public class Portugues extends Tema {
    
    private static Portugues obj;
    
    public static Portugues getInstance() {
        if(obj == null) {
            obj = new Portugues();
        }
        obj.iniciarPerguntas();
        obj.sortearPerguntas();
        return obj;
    }

    @Override
    public void iniciarPerguntas() {
        ArrayList<Pergunta> ps = new ArrayList<Pergunta>();

        ArrayList<Alternativa> respostas = new ArrayList<>();
        respostas.add(Alternativa.A);
        respostas.add(Alternativa.B);
        respostas.add(Alternativa.C);
        respostas.add(Alternativa.D);

        Random r = new Random();

        for (int i = 1; i <= 20; i++) {
            ArrayList<String> alternativas = new ArrayList<String>();
            alternativas.add("Alternativa A pergunta Portugues " + i);
            alternativas.add("Alternativa B pergunta Portugues " + i);
            alternativas.add("Alternativa C pergunta Portugues " + i);
            alternativas.add("Alternativa D pergunta Portugues " + i);
            ps.add(new Pergunta("Pergunta Portugues " + i, alternativas, respostas.get(r.nextInt(4))));
        }

        super.setPerguntas(ps);
    }
    
}
