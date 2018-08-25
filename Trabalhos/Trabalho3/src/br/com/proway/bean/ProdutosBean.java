package br.com.proway.bean;

/**
 * @author Vinícius Luis da Silva
 */
public class ProdutosBean {
    
    private final int idProduto;
    private String nomeProduto;
    private double valorProduto;
    private int quantidadeProduto;
    private int idMarca;
    private int idSetor;

    public ProdutosBean(int idProduto, String nomeProduto, double valorProduto, int quantidadeProduto, int idMarca, int idSetor) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.idMarca = idMarca;
        this.idSetor = idSetor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    @Override
    public String toString() {
        return this.getNomeProduto();
    }

    
    
}
