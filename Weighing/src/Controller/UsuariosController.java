package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Principal;
import App.Usuarios;
import DAO.PessoaDao;
import Model.Pessoa;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UsuariosController implements Initializable{


  
  @FXML  private Button btnCancela;
  @FXML  private Button btncadas;
  @FXML  private TextField txtConfirma;
  @FXML  private TextField txtNome;
  @FXML  private TextField txtSenha;
  @FXML  private TextField txtUser;


  

  

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    btnCancela.setOnMouseClicked((MouseEvent e) -> {
      fechar();
    });
    btncadas.setOnKeyPressed((KeyEvent e)->{
      if (e.getCode() == KeyCode.ENTER) {
        cadastroUser();        
      }
    });
    btncadas.setOnMouseClicked((MouseEvent)->{
      cadastroUser();
    });

  }

  public void fechar() {
    Usuarios.getStage().close();
    Principal principal = new Principal();
    try {
      principal.start(new Stage());
    } catch (Exception e) {

      e.printStackTrace();
    }

  }
  private void cadastroUser(){
    String user =  txtUser.getText().toUpperCase();
    String nome = txtNome.getText().toUpperCase();
    String senha = txtSenha.getText();
    String confirma = txtConfirma.getText();
    if (senha.equals(confirma) == true) {
       Pessoa pessoa =  new Pessoa(user,nome,senha);
       PessoaDao dao = new PessoaDao();
       if (dao.add(pessoa)) {
         Alert alert = new Alert(AlertType.CONFIRMATION);
         alert.setHeaderText("Usuario cadastrado.");
         alert.showAndWait();

       } else {
         Alert alert = new Alert(AlertType.ERROR);
         alert.setHeaderText("Usuario não cadastrado.");
         alert.showAndWait();
       }

    } else {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setHeaderText("Senhas diferentes!");
      alert.showAndWait();
    }
    fechar();
 
  }
  // private void editaUser(){
  //   String user = txtUser.getText();
  //   String nome = txtNome.getText();
  //   String senha = txtSenha.getText();
  //   String confirma = txtConfirma.getText();
  //   if (senha.equals(confirma) == true) {
  //      Pessoa pessoa =  new Pessoa(user,nome,senha);
  //      PessoaDao dao = new PessoaDao();
  //      if (dao.update(pessoa)) {
  //        Alert alert = new Alert(AlertType.CONFIRMATION);
  //        alert.setHeaderText("Usuario cadastrado.");
  //        alert.showAndWait();

  //      } else {
  //        Alert alert = new Alert(AlertType.ERROR);
  //        alert.setHeaderText("Usuario não cadastrado.");
  //        alert.showAndWait();
  //      }

  //   } else {
  //     Alert alert = new Alert(AlertType.ERROR);
  //     alert.setHeaderText("Senhas diferentes!");
  //     alert.showAndWait();
  //   }
  //   fechar();

  // }


}

