/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo;

import br.vo.tema.Historia;
import br.vo.tema.Matematica;
import br.vo.tema.Portugues;
import br.vo.tema.Tema;

/**
 *
 * @author 104884
 */
public class FactoryTema {
    
    public static Tema get(String tema) {
        switch (tema) {
            case "História":
                return Historia.getInstace();
            case "Matemática":
                return Matematica.getInstance();
            case "Português":
                return Portugues.getInstance();
            default:
                throw new IllegalArgumentException("Tema inválido!");
        }
    }
    
}
