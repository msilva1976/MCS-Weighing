package Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import App.Login;
import App.Principal;
import DAO.PessoaDao;
import Model.Pessoa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML    private Button btnCancela;
    @FXML    private Button btnEntrar;
    @FXML    private PasswordField txpPassword;
    @FXML    private TextField txtUser;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      btnCancela.setOnMouseClicked((MouseEvent)->{
        fecha();
      });
      btnCancela.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          fecha();
        }
      });
      txpPassword.setOnKeyPressed((KeyEvent e )->{
        if (e.getCode()==KeyCode.ENTER) {
          logar();
        }
      });
      btnEntrar.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode()==KeyCode.ENTER) {
          logar();
        }
      });
      txtUser.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode()==KeyCode.ENTER) {
          txpPassword.requestFocus();
          
        }
      });
      
    }
   
    public void fecha() {
      Login.getStage().close();

    }

    public void logar() {
      PessoaDao dao = new PessoaDao();
      List<Pessoa> pessoas = dao.getList();

      for (int x=0; x < pessoas.size() ; x++) {
        if (txtUser.getText().equals(pessoas.get(x).getUser()) && txpPassword.getText().equals(pessoas.get(x).getSenha())) {
        
        Principal principal = new Principal();
        x = pessoas.size();
        try {
          principal.start(new Stage());
          fecha();
        } catch (Exception e1) {

          e1.printStackTrace();
        }
      } else {
        if (x==pessoas.size()-1) {
          Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText("LOGIN INVALIDO");
        alert.setTitle("LOGIN");
        alert.setContentText("ACESSO NEGADO");
        alert.show();
        }
        
      }
      
    }
      }
      
      

  }