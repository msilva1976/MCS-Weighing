package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Login;
import App.Principal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML private Button btnCancel;
    @FXML private Button btnEnter;
    @FXML private PasswordField txtPassword;
    @FXML private TextField txtUser;
    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
      btnEnter.setOnMouseClicked((MouseEvent e)->{
        if (txtUser.getText().equals("msilva")&&txtPassword.getText().equals("1234")) {
          fecha();
          Principal principal = new Principal();
          try {
            principal.start(new Stage());
          } catch (Exception e1) {
           
            e1.printStackTrace();
          }
        }else{
          Alert alert =new Alert(AlertType.ERROR);
           alert.setHeaderText("LOGIN INVALIDO");
           alert.setTitle("LOGIN");
           alert.setContentText("ACESSO NEGADO");
           alert.show();
        }
      });
      btnCancel.setOnMouseClicked((MouseEvent e)->{
        fecha();
      });
      btnCancel.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode()==KeyCode.ENTER) {
          fecha();
        }
      });
    }
    public void fecha(){
      Login.getStage().close();

    }

}