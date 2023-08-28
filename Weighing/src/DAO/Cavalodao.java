package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.cavalo;
import JDBC.ConnectioFactory;



public class Cavalodao {
  private Connection conn;
  
  public Cavalodao(){
    this.conn = new ConnectioFactory().getConnection();
  }
  public boolean cavaloadd(cavalo cavalo){
  
    String sql = "INSERT INTO cavalo(frota,cavalo,empresa,motorista)VALUE(?,?,?,?)";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, cavalo.getFrota());
      stmt.setString(2,cavalo.getPlaca());
      stmt.setString(3, cavalo.getEmpresa());
      stmt.setString(4, cavalo.getMotorista());
    
      stmt.execute();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
    return false;

  }
    public boolean cavaloupdate(cavalo cavalo){
    String sql = "UPDATE cavalo SET frota = ?, cavalo = ?, empresa = ?, motorista = ? WHERE id = ?;";
    
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, cavalo.getFrota());
      stmt.setString(2,cavalo.getCavalo());
      stmt.setString(3, cavalo.getEmpresa());
      stmt.setString(4, cavalo.getMotorista());    
      stmt.execute();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
    return false;

  }
  public boolean cavalodelete(cavalo cavalo){
    String sql = "DELETE FROM cavalo WHERE id=?;";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setLong(1, cavalo.getid());
      stmt.execute();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
    return false;

  }
  public List<cavalo>getList(){
    List<cavalo>cavalos = new ArrayList<>();
    String sql = "SELECT FROM cavalo";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet re = stmt.executeQuery();
      while (re.next()) {
        cavalo cavalo = new cavalo();
        cavalo.setId(re.getLong("id"));
        cavalo.setFrota(re.getString("Frota"));
        cavalo.setPlaca(re.getString("Placa"));
        cavalo.setEmpresa(re.getString("Empresa "));
        cavalo.setMotorista(re.getString("motorista"));
        cavalo.add(cavalo);
      }
      stmt.close();
      re.close();
      conn.close();
    } catch (SQLException e) {
      System.out.println("ERRO!");    
      e.printStackTrace();
      return null;
    }
    return cavalos;
    


  }

}
