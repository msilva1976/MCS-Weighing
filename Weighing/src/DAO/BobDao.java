package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Bob;
import JDBC.ConnectioFactory;


public class BobDao {
  private Connection conn;

  public BobDao() {
    this.conn = new ConnectioFactory().getConnection();
  }

  public boolean bobadd(Bob bob) {
    String sql = "INSERT INTO bobtail(frota,placa,tara,motorista)VALUE(?,?,?,?)";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, bob.getFrota());
      stmt.setString(2, bob.getPlaca());
      stmt.setString(3, bob.getTara());
      stmt.setString(4, bob.getMotorista());
      stmt.execute();
      stmt.close();
      conn.close();
      return true;
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return false;

  }
  public boolean bobupdate(Bob bob){
    String sql = "UPDATE bobtail SET frota = ?, placa = ?, tara = ?, motorista = ? WHERE id = ?;";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1,bob.getFrota());
      stmt.setString(2,bob.getPlaca());
      stmt.setString(3,bob.getTara());
      stmt.setString(4,bob.getMotorista());
      stmt.execute();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
  
      e.printStackTrace();
    }
    return false;
  }
  public boolean bobdelete(Bob bob){
    String sql = "DELETE FROM bobtail WHERE id=?;";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setLong(1, bob.getId());
      stmt.execute();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
    return false;

  }
  public List<Bob>getList(){
    List<Bob>bobs = new ArrayList<>();
    String sql = "SELECT FROM bobtail";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet re = stmt.executeQuery();
      while (re.next()) {
        Bob bob = new Bob();
        bob.setId(re.getLong("id"));
        bob.setFrota(re.getString("Frota"));
        bob.setPlaca(re.getString("Placa"));
        bob.setTara(re.getString("Tara "));
        bob.setMotorista(re.getString("Motorista"));
        bobs.add(bob);
      }
      stmt.close();
      re.close();
      conn.close();
    } catch (SQLException e) {
      System.out.println("ERRO!");    
      e.printStackTrace();
      return null;
    }
    return bobs;
    


  }


}

