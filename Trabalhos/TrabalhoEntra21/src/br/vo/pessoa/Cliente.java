/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo.pessoa;

import br.util.Arquivo;

/**
 *
 * @author 104884
 */
public class Cliente extends Usuario {
    
    public Cliente(String nome, String codigo, String nomeUsuario, String senha, String pergunta, String resposta) {
        super(nome, codigo, nomeUsuario, senha, pergunta, resposta);
    }
    
}
