package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Cavalo;
import App.Principal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class CavalosController implements Initializable {

    @FXML    private Button btnBuscar;
    @FXML    private Button btnCadastrar;
    @FXML    private Button btnCancela;
    @FXML    private Button btnDeleta;
    @FXML    private Button btnEditar;
    @FXML    private CheckBox chcFrota;
    @FXML    private CheckBox chcPlaca;
    @FXML    private TextField txtEmpresa;
    @FXML    private TextField txtFrota;
    @FXML    private TextField txtMotorista;
    @FXML    private TextField txtPlaCavalo;
    @FXML    private TextField txtbuscar;
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

    public void fechar() {
      Cavalo.getStage().close();
      Principal principal = new Principal();
    try {
      principal.start(new Stage());
    } catch (Exception e) {
      
      e.printStackTrace();
    }
      

    }

}

