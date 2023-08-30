package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.CarretaModel;

import JDBC.ConnectioFactory;


public class CarretaDao {
  private Connection conn;

  public CarretaDao() {
    this.conn = new ConnectioFactory().getConnection();
  }

  public boolean carretaadd(CarretaModel carreta) {
    String sql = "INSERT INTO  mydb.carretas (frota,carreta,cavalo,motorista,eixo,destino,capacidade)VALUE(?,?,?,?,?,?,?)";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, carreta.getFrota());
      stmt.setString(2, carreta.getCarreta());
      stmt.setString(3, carreta.getCavalo());
      stmt.setString(4, carreta.getMotorista());
      stmt.setString(5, carreta.getEixos());
      stmt.setString(6, carreta.getDestino());
      stmt.setString(7, carreta.getCapacidade());
      stmt.execute();
      stmt.close();
      conn.close();
      return true;
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return false;

  }

  public boolean carretaupdate(CarretaModel carreta) {
    String sql = "UPDATE carretas SET frota = ?, placa carreta = ?, placa cavalo = ?, motorista = ?, eixos = ?, destino = ?, capacidade = ? WHERE id = ?;";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, carreta.getFrota());
      stmt.setString(2, carreta.getCarreta());
      stmt.setString(3, carreta.getCavalo());
      stmt.setString(4, carreta.getMotorista());
      stmt.setString(5, carreta.getEixos());
      stmt.setString(6, carreta.getDestino());
      stmt.setString(7, carreta.getCapacidade());
      stmt.execute();
      stmt.close();
      conn.close();
      return true;
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return false;
  }

  
    
    
  public boolean deletaCarreta(CarretaModel carretaModel){
    String sql = "DELETE FROM carretas WHERE id=?;";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setLong(1,carretaModel.getId());
      stmt.execute();
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      
      e.printStackTrace();
    }
    return false;

  }
  public List<CarretaModel>getList(){
    List<CarretaModel>carretaModels = new ArrayList<>();
    String sql = "SELECT * FROM carretas";
      try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet r = stmt.executeQuery();
        while (r.next()) {
          CarretaModel carretaModel = new CarretaModel();
          carretaModel.setId(r.getLong("id"));
          carretaModel.setFrota(r.getString("frota"));
          carretaModel.setCarreta(r.getString("carreta"));
          carretaModel.setCavalo(r.getString("cavalo"));
          carretaModel.setMotorista(r.getString("motorista"));
          carretaModel.setEixos(r.getString("eixo"));
          carretaModel.setDestino(r.getString("destino"));
          carretaModel.setCapacidade(r.getString("capacidade"));
          carretaModels.add(carretaModel);        
        }
        stmt.close();
        r.close();
        conn.close();
      } catch (SQLException e) {
        
        e.printStackTrace();
      }
    
    
    return carretaModels;
    
  }

}
