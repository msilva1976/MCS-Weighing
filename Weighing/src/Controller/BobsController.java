package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Bobs;
import App.Principal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;



public class BobsController implements Initializable {

    
    @FXML    private Button btnBusca;
    @FXML    private Button btnCadastra;
    @FXML    private Button btnCancela;
    @FXML    private Button btnDeleta;
    @FXML    private Button btnEdita;
    @FXML    private CheckBox chcFrota;
    @FXML    private TextField txtFrota;
    @FXML    private TextField txtMotorista;
    @FXML    private TextField txtPlaca;
    @FXML    private TextField txtTara;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      btnCancela.setOnMouseClicked((MouseEvent )->{
        fechar();
      });
      btnCancela.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode()==KeyCode.ENTER) {
          fechar();          
        }
      });

      
    }
    public void fechar(){
      Bobs.getStage().close();
      Principal principal = new Principal();
    try {
      principal.start(new Stage());
    } catch (Exception e) {
      
      e.printStackTrace();
    }
   }

}
