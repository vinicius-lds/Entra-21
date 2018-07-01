package br.com.proway.bean;

/**
 * @author Vinícius Luis da Silva
 */
public class SaidaDosProdutosBean {
    
    private final int idSaida;
    private double valorSaida;
    private int quantidadeSaida;
    private int idProduto;

    public SaidaDosProdutosBean(int idSaida, double valorSaida, int quantidadeSaida, int idProduto) {
        this.idSaida = idSaida;
        this.valorSaida = valorSaida;
        this.quantidadeSaida = quantidadeSaida;
        this.idProduto = idProduto;
    }

    public int getIdSaida() {
        return idSaida;
    }

    public double getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(double valorSaida) {
        this.valorSaida = valorSaida;
    }

    public int getQuantidadeSaida() {
        return quantidadeSaida;
    }

    public void setQuantidadeSaida(int quantidadeSaida) {
        this.quantidadeSaida = quantidadeSaida;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

        
}
