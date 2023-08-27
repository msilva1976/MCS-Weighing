package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Carretas;
import App.Principal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class CarretasController implements Initializable {
    
  
  @FXML
  private Button btnCadastrar;

  @FXML  private Button btnCancela;
  @FXML  private TextField txtCapacidade;
  @FXML  private TextField txtDestino;
  @FXML  private TextField txtEixo;
  @FXML  private TextField txtMotorista;
  @FXML  private Pane txtPlaca;
  @FXML  private TextField txtPlacaCarreta;
  @FXML  private TextField txtPlava;
  @FXML  private TextField txttxtPlaCavalo;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      btnCancela.setOnMouseClicked((MouseEvent e)->{
        fechar();
      });
      btnCancela.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          fechar();
        }
      });      
    }
    public void fechar(){
      Carretas.getStage().close();
      Principal principal = new Principal();
    try {
      principal.start(new Stage());
    } catch (Exception e) {
      
      e.printStackTrace();
    }
    }


}
