package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import App.Carretas;
import JDBC.ConnectioFactory;
import Model.Carreta;

public class CarretaDao {
  private Connection conn;

  public CarretaDao() {
    this.conn = new ConnectioFactory().getConnection();
  }

  public boolean carretaadd(Carreta carreta) {
    String sql = "INSERT INTO  mydb.carretas (frota,carreta,cavalo,motorista,eixo,destino,capacidade)VALUE(?,?,?,?,?,?,?)";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, carreta.getFrota());
      stmt.setString(2, carreta.getPlacaCarreta());
      stmt.setString(3, carreta.getPlacaCavalo());
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

  public boolean carretaupdate(Carreta carreta) {
    String sql = "UPDATE carretas SET frota = ?, placa carreta = ?, placa cavalo = ?, motorista = ?, eixos = ?, destino = ?, capacidade = ? WHERE id = ?;";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, carreta.getFrota());
      stmt.setString(2, carreta.getPlacaCarreta());
      stmt.setString(3, carreta.getPlacaCavalo());
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

  public boolean carretadelete(Carreta carreta) {
    String sql = "DELETE FROM carretas WHERE id = ?;";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setLong(1, carreta.getId());
      stmt.execute();
      stmt.close();
      conn.close();
      return true;
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return false;

  }

  public List<Carretas> getList(){
    List<Carretas> carretas = new ArrayList<>();
    String sql = "SELECT FROM carretas";
    try {
      PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet ca = stmt.executeQuery();
      while (ca.next()) {
        Carreta carreta = new Carreta();
        carreta.setId(ca.getLong("id"));
        carreta.setFrota(ca.getString("Frota "));
        carreta.setPlacaCarreta(ca.getString("Placa Carreta "));
        carreta.setPlacaCavalo(ca.getString("Placa Cavalo "));
        carreta.setMotorista(ca.getString("Motorista "));
        carreta.setEixos(ca.getString("Eixos "));
        carreta.setDestino(ca.getString("Destino "));
        carreta.setCapacidade(ca.getString("Capacidade "));
        carretas.add((Carretas) carretas);
      }
      stmt.close();
      ca.close();
      conn.close();
    } catch (SQLException e) {
      System.out.println("ERRO!");
      e.printStackTrace();
    }
    return carretas;

  }
}


