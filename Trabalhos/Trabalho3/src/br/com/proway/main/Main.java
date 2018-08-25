package br.com.proway.main;

import br.com.proway.dao.DAO;
import br.com.proway.view.Principal;
import java.sql.SQLException;

/**
 * @author Vinícius Luis da Silva
 */
public abstract class Main {
    
    public static DAO CONEXAO;
    
    public static void main(String[] args) throws SQLException {
        CONEXAO = new DAO("root", "", "jdbc:mysql://localhost:3306/mercado");
        new Principal();
    }
    
}
