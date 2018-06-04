/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo;

import br.vo.pessoa.Usuario;

/**
 *
 * @author 104884
 */
public class Login {

    private static Login login = null;


    private Usuario usuario;

    private Login() {
    }

    public static Login getInstance() {
        if (Login.login == null) {
            Login.login = new Login();
        }
        return Login.login;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
    
}
