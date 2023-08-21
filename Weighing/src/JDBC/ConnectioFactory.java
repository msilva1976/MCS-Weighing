package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//responsavel pela conexão do sistema
public class ConnectioFactory {
  public Connection getConnection(){
    String nomeUsuario = "msilva";
    String senhaUsuario = "i2#Bu94iL";
    String enderecoServidor = "localhost";
    String nomeBanco = "mydb";
    try {
      return DriverManager.getConnection("jdbc:mysql://"+enderecoServidor+"/"+nomeBanco,nomeUsuario,senhaUsuario);
    } catch (SQLException e) {
     System.out.println("Falha de Conexão");
     throw new RuntimeException(e);
    }

  }
}
