package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.BobModel;
import JDBC.ConnectioFactory;


public class BobDao {
  private Connection conn;

  public BobDao() {
    this.conn = new ConnectioFactory().getConnection();
  }

  public boolean bobadd(BobModel bob) {
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
  public boolean bobupdate(BobModel bob){
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
  public boolean bobdelete(BobModel bob){
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
  public List<BobModel>getList(){
    List<BobModel>bobModels = new ArrayList<>();
    String sql = "SELECT * FROM bobtail";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet r = stmt.executeQuery();
      while (r.next()) {
        BobModel bobModel = new BobModel();
        bobModel.setId(r.getLong("id"));
        bobModel.setFrota(r.getString("frota"));
        bobModel.setPlaca(r.getString("placa"));
        bobModel.setTara(r.getString("tara"));
        bobModel.setMotorista(r.getString("motorista"));
        bobModels.add(bobModel);
      }
      stmt.close();
      r.close();
      conn.close();
    } catch (SQLException e) {
      
      e.printStackTrace();
      return null;
    }
    return bobModels;
    
  }
  


}

