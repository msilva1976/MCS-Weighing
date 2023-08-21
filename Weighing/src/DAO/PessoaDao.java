package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



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
    String sql = "DELETE FROM pessoa WHERE (?);";
    //String sql = "DELETE FROM `mydb`.`pessoa` WHERE (`id` = ?);";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setLong(1,pessoa.getId());
      stmt.execute();
      stmt.close();
      conn.close();
      return true;
    } catch (SQLException e) {
      
      e.printStackTrace();
      return false;
    }
    
  }
}

  

