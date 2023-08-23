package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Usuarios;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UsuariosController implements Initializable{

  @FXML  private Button btbBuscar;
  @FXML  private Button btbEditar;
  @FXML  private Button btnCancela;
  @FXML  private Button btnDeleta;
  @FXML  private Button btncadas;
  @FXML  private TextField txtBuscar;
  @FXML  private TextField txtNome;
  @FXML  private TextField txtSenha;
  @FXML  private TextField txtUser;
  

  

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    fechar();
  }
  public void fechar() {
    Usuarios.getStage().close();

  }

}
