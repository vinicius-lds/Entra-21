/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo;

/**
 *
 * @author 104884
 */
public class Categoria {
    
    public static Categoria categoria = null;
    
    private Categoria() {}
    
    public static Categoria getInstance() {
        if(Categoria.categoria == null) {
            Categoria.categoria = new Categoria();
        }
        return Categoria.categoria;
    }
    
}
