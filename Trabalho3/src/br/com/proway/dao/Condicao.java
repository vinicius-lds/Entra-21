package br.com.proway.dao;

import br.com.proway.util.StringUtil;
import br.com.proway.enumeradores.Comando;

/**
 * @author Vinícius Luis da Silva
 */
public class Condicao {

    private String info;
    
    public Condicao() {
        info = "";
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return this.info;
    }
    
    /**
     * Adiciona um comando LIKE na condicão
     * @param coluna a coluna que será comparada
     * @param valor o valor que sera comparado
     */
    public void addLike(String coluna, String valor) {
        info += " " + coluna + " " + Comando.LIKE + " " + StringUtil.setAspas("%" + valor + "%");
    }
    
    /**
     * Adiciona um comando LIKE na condicão (%LIKE)
     * @param coluna a coluna que será comparada
     * @param valor o valor que sera comparado
     */
    public void addLikeFirst(String coluna, String valor) {
        info += " " + coluna + " " + Comando.LIKE + " " + StringUtil.setAspas("%" + valor);
    }
    
    /**
     * Adiciona um comando LIKE na condicão(LIKE%)
     * @param coluna a coluna que será comparada
     * @param valor o valor que sera comparado
     */
    public void addLikeLast(String coluna, String valor) {
        info += " " + coluna + " " + Comando.LIKE + " " + StringUtil.setAspas(valor + "%");
    }
    
    /**
     * Adiciona um comando WHERE na condição
     */
    public void addWhere() {
        info += " " + Comando.WHERE;
    }
    
    /**
     * Adiciona um comando INNER JOIN na condicão
     * @param tabelaAtual a tabela em que o comando esta atualmente
     * @param tabelaJoin a tabela que será juntada com a atual
     * @param primeiraColuna o primeiro valor que será comparado
     * @param segundaColuna o segundo valor que será comparado
     */
    public void addInnerJoin(String tabelaAtual, String tabelaJoin, String primeiraColuna, String segundaColuna) {
        info += " " 
                + Comando.INNER_JOIN
                + " "
                + tabelaJoin
                + " "
                + Comando.ON 
                + " "
                + tabelaAtual + "." + primeiraColuna
                + Comando.EQUALS
                + tabelaJoin + "." + segundaColuna;
    }
    
    public void addInnerJoin(String tabelaAtual, String tabelaJoin, String coluna) {
        info += " " 
                + Comando.INNER_JOIN
                + " "
                + tabelaJoin
                + " "
                + Comando.ON 
                + " "
                + tabelaAtual + "." + coluna
                + Comando.EQUALS
                + tabelaJoin + "." + coluna;
    }
    
    public void addEquals(String coluna, String valor) {
        info += " " 
                + coluna 
                + (valor == null || valor.equals("null") ? 
                    " " + Comando.IS + " null" 
                :
                    Comando.EQUALS + StringUtil.setAspas(valor));
    }
    
    public void addAnd() {
        info += " " + Comando.AND;
    }
    
    public void addOr() {
        info += " " + Comando.OR;
    }
    
}
