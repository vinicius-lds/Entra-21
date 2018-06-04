/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo.pessoa;

import br.util.Arquivo;
import java.io.Serializable;

/**
 *
 * @author 104884
 */
public class Funcionario extends Usuario implements Serializable {
    
    private double salario;

    public Funcionario(String nome, String codigo, String nomeUsuario, String senha, String pergunta, String resposta, double salario) {
        super(nome, codigo, nomeUsuario, senha, pergunta, resposta);
        this.setSalario(salario);
    }
    
    public Funcionario() {}

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if(salario < 0) {
            throw new IllegalArgumentException("Salário " + salario + " é inválido!");
        }
        this.salario = salario;
        System.out.println("setSalario " + this.salario);
    }

    public void atualizaUsuario(String nome, String codigo, String senha, String pergunta, String resposta, double salario) {
        super.setNome(nome);
        super.setCodigo(codigo);
        super.setPass(senha);
        super.setPergunta(pergunta);
        super.setResposta(resposta);
        this.setSalario(salario);
        Arquivo.gravarAlteracoesUsuarios();
    }
    
}
