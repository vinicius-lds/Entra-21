package br.com.proway.bean;

import br.com.proway.dao.Condicao;
import br.com.proway.main.Main;
import java.sql.ResultSet;

/**
 * @author Vinícius Luis da Silva
 */
public class PromocoesBean {

    private final int idPromocao;
    private int idProduto;
    private double percentualDesconto;

    public PromocoesBean(int idPromocao, int idProduto, double percentualDesconto) {
        this.idPromocao = idPromocao;
        this.idProduto = idProduto;
        this.percentualDesconto = percentualDesconto;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public String toString() {
        try {
            Condicao c = new Condicao();
            c.addWhere();
            c.addEquals("idProduto", this.getIdProduto() + "");
            ResultSet rs = Main.CONEXAO.select(new String[]{"nomeProduto"}, "produtos", c);
            String prod = null;
            while(rs.next()) {
                prod = rs.getString(1);
            }
            rs.close();
            return prod + " " + this.getPercentualDesconto() + "%";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.toString();
    }

}
