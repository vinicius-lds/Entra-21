package br.com.proway.dao;

import br.com.proway.bean.CursosBean;
import br.com.proway.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Vinícius Luis da Silva
 */
public class CursosDAO {

    private Connection conexao;
    
    public CursosDAO() {
        this.conexao = new ConnectionFactory().obterConexao();
    }
    
    public void cadastrarCurso(CursosBean cb) {
        try {
            PreparedStatement pstmt = this.conexao.prepareStatement("INSERT INTO cursos(nomeCurso, valor) VALUES (?, ?);");
            pstmt.setString(1, cb.getNomeCurso());
            pstmt.setDouble(2, cb.getValorCurso());
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public void alterarCurso(CursosBean cb) {
        try {
            PreparedStatement pstmt = this.conexao.prepareStatement("UPDATE cursos SET nomeCurso = ? , valor = ? WHERE idCurso = ?");
            pstmt.setString(1,cb.getNomeCurso());
            pstmt.setDouble(2,cb.getValorCurso());
            pstmt.setInt(3,cb.getIdCurso());
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public void deletarCurso(Integer id) {
        try {
            PreparedStatement pstmt = this.conexao.prepareStatement("DELETE FROM cursos WHERE idCurso = ?");
            pstmt.setInt(1, id);
            pstmt.execute();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    public ArrayList<Object> listarCursos() {
        ArrayList<Object> results = new ArrayList<>();
        try {
            Statement stmt = this.conexao.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cursos;");
            while(rs.next()) {
                results.add(rs.getInt(1));
                results.add(rs.getString(2));
                results.add(rs.getString(3));
            }                                                                   
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return results;
    }
    
}
