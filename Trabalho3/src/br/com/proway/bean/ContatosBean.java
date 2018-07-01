package br.com.proway.bean;

/**
 * @author Vinícius Luis da Silva
 */
public class ContatosBean {
    
    private final int idContato;
    private String conteudoContato;
    private int idPessoa;

    public ContatosBean(int idContato, String conteudoContato, int idPessoa) {
        this.idContato = idContato;
        this.conteudoContato = conteudoContato;
        this.idPessoa = idPessoa;
    }

    public int getIdContato() {
        return idContato;
    }

    public String getConteudoContato() {
        return conteudoContato;
    }

    public void setConteudoContato(String conteudoContato) {
        this.conteudoContato = conteudoContato;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return this.getConteudoContato();
    }
    
}
