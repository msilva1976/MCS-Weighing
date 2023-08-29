package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.CavaloModel;
import JDBC.ConnectioFactory;



public class Cavalodao {
  private Connection conn;
  
  public Cavalodao(){
    this.conn = new ConnectioFactory().getConnection();
  }
  public boolean cavaloadd(CavaloModel cavalo){
  
    String sql = "INSERT INTO cavalo(frota,cavalo,empresa,motorista)VALUE(?,?,?,?)";
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
    public boolean cavaloupdate(CavaloModel cavalo){
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
  public boolean cavalodelete(CavaloModel cavalo){
    String sql = "DELETE FROM cavalo WHERE id=?;";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setLong(1, cavalo.getId());
      stmt.execute();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
    return false;

  }
  public List<CavaloModel>getList(){
    List<CavaloModel>cavaloModels = new ArrayList<>();
    String sql = "SELECT * FROM cavalo";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet r = stmt.executeQuery();
      while (r.next()) {
        CavaloModel cavaloModel = new CavaloModel();
        cavaloModel.setId(r.getLong("id"));
        cavaloModel.setFrota(r.getString("frota"));
        cavaloModel.setCavalo(r.getString("cavalo"));
        cavaloModel.setMotorista(r.getString("motorista"));
        cavaloModels.add(cavaloModel);

      }
      stmt.close();
      r.close();
      conn.close();
    } catch (SQLException e) {
      
      e.printStackTrace();
      return null;
    }
    return cavaloModels;

  }

}
