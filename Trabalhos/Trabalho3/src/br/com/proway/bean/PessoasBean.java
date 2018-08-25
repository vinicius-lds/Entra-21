package br.com.proway.bean;

import java.sql.Date;

/**
 * @author Vinícius Luis da Silva
 */
public class PessoasBean {
    
    private final int idPessoa;
    private String nomePessoa;
    private boolean mascPessoa;
    private Date nascPessoa;
    private int idCargo;

    public PessoasBean(int idPessoa, String nomePessoa, boolean mascPessoa, Date nascPessoa, int idCargo) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.mascPessoa = mascPessoa;
        this.nascPessoa = nascPessoa;
        this.idCargo = idCargo;
    }

    public PessoasBean(int idPessoa, String nomePessoa, boolean mascPessoa, Date nascPessoa) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.mascPessoa = mascPessoa;
        this.nascPessoa = nascPessoa;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public boolean isMascPessoa() {
        return mascPessoa;
    }

    public void setMascPessoa(boolean mascPessoa) {
        this.mascPessoa = mascPessoa;
    }

    public Date getNascPessoa() {
        return nascPessoa;
    }

    public void setNascPessoa(Date nascPessoa) {
        this.nascPessoa = nascPessoa;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }
    
}
