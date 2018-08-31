package br.com.proway.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Vinícius Luis da Silva
 */
public class ConnectionFactory {
    
    private final String URL = "jdbc:mysql://localhost:3306/escola_proway";
    private final String USER = "root";
    private final String PASS = "";
    
    public Connection obterConexao() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USER, PASS);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }
    
}
