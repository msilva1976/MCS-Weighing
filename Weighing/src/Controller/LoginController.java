package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController implements Initializable {

    @FXML private Button btnCancel;
    @FXML private Button btnEnter;
    @FXML private PasswordField txtPassword;
    @FXML private TextField txtUser;
    
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
      btnEnter.setOnMouseClicked((MouseEvent e)->{
        System.out.println("Entrei");
      });
      btnCancel.setOnMouseClicked((MouseEvent e)->{
        System.out.println("sai");
      });
    }

}