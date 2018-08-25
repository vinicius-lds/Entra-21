package br.com.proway.bean;

/**
 * @author Vinícius Luis da Silva
 */
public class EnderecosBean {
    
    private final int idEndereco;
    private String cepEndereco;
    private String ruaEndereco;
    private String complementoEndereco;
    private int idPessoa;

    public EnderecosBean(int idEndereco, String cepEndereco, String ruaEndereco, String complementoEndereco, int idPessoa) {
        this.idEndereco = idEndereco;
        this.cepEndereco = cepEndereco;
        this.ruaEndereco = ruaEndereco;
        this.complementoEndereco = complementoEndereco;
        this.idPessoa = idPessoa;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public String getRuaEndereco() {
        return ruaEndereco;
    }

    public void setRuaEndereco(String ruaEndereco) {
        this.ruaEndereco = ruaEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return "Rua: " + this.getRuaEndereco() + ", CEP: " + this.getCepEndereco();
    }
    
}
