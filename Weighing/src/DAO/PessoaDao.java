package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import JDBC.ConnectioFactory;
import Model.Pessoa;

public class PessoaDao {
  private Connection conn;
  

  public PessoaDao(){
    this.conn = new ConnectioFactory().getConnection();
  }
  public boolean add(Pessoa pessoa){
    String sql = "INSERT INTO pessoa(user,nome,senha)VALUES (?,?,?);";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1,pessoa.getUser());
      stmt.setString(2, pessoa.getNome());
      stmt.setString(3, pessoa.getSenha());
      stmt.execute();
      stmt.close();
      conn.close();
      return true;
    } catch (SQLException e) {     
      e.printStackTrace();
    }
    return false;
    }
  public boolean update(Pessoa pessoa){
    String sql = "UPDATE pessoa SET user = ?,nome = ?,senha = ? WHERE id = ?;";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1,pessoa.getUser());
      stmt.setString(2, pessoa.getNome());
      stmt.setString(3, pessoa.getSenha());
      stmt.setLong(4,pessoa.getId());
      stmt.execute();
      stmt.close();
      conn.close();
      return true;
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
    return false;
  }
  public boolean delete(Pessoa pessoa){
    String sql = "DELETE FROM pessoa WHERE id=?;";

    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setLong(1, pessoa.getId());
      stmt.execute();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      Logger.getLogger( PessoaDao.class.getName()).log(Level.SEVERE, null, e);
      
    }
    return false;
    
  }
  public List<Pessoa>getList(){
    List<Pessoa>pessoas = new ArrayList<>();
    String sql = "SELECT * FROM pessoa ";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet rs = stmt.executeQuery();
      while(rs.next()){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(rs.getLong("id"));
        pessoa.setUser(rs.getString("user"));
        pessoa.setNome(rs.getString("nome"));
        pessoa.setSenha(rs.getString("senha"));
        pessoas.add(pessoa);
        
      }
      stmt.close();
      rs.close();
      conn.close();
    } catch (SQLException e) {
      System.out.println("erro");
     
      return null;
    }

    return pessoas;
    
  }
  
}

  

