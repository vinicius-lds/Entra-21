/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vo.pessoa;

/**
 *
 * @author 104884
 */
public class Funcionario extends Usuario {
    
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
        this.salario = salario;
    }
    
}
