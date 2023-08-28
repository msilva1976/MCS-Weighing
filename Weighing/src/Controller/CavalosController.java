package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Cavalo;
import App.Principal;

import DAO.Cavalodao;

import Model.cavalo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CavalosController implements Initializable {

  @FXML  private Button btnCadastrar;
  @FXML  private Button btnCancela;
  @FXML  private TextField txtEmpresa;
  @FXML  private TextField txtFrota;
  @FXML  private TextField txtMotorista;
  @FXML  private TextField txtPlaCavalo;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    btnCancela.setOnMouseClicked((MouseEvent e) -> {
      fechar();
    });
    btnCancela.setOnKeyPressed((KeyEvent e) -> {
      if (e.getCode() == KeyCode.ENTER) {
        fechar();
      }
    });
    btnCadastrar.setOnMouseClicked((MouseEvent)->{
      cadastraCarreta();
    });
    btnCadastrar.setOnKeyPressed((KeyEvent e)->{
      if (e.getCode() == KeyCode.ENTER) {
        cadastraCarreta();
      }
    });
    txtFrota.setOnKeyPressed((KeyEvent e)->{
      
       if (e.getCode() == KeyCode.ENTER) {
        txtPlaCavalo.requestFocus();
      }
    });
    txtPlaCavalo.setOnKeyPressed((KeyEvent e)->{
      
       if (e.getCode() == KeyCode.ENTER) {
        txtEmpresa.requestFocus();
      }
    });
    txtEmpresa.setOnKeyPressed((KeyEvent e)->{
     
       if (e.getCode() == KeyCode.ENTER) {
         txtMotorista.requestFocus();
      }
    });
    txtMotorista.setOnKeyPressed((KeyEvent e)->{
     
       if (e.getCode() == KeyCode.ENTER) {
         btnCadastrar.requestFocus();
      }
    });

    btnCadastrar.setOnKeyPressed((KeyEvent e)->{
      if (e.getCode() == KeyCode.ENTER) {
        cadastraCarreta();
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
  private void cadastraCarreta(){
    String frota = txtFrota.getText();
    String cavalos = txtPlaCavalo.getText().toUpperCase();
    String empresa = txtEmpresa.getText().toUpperCase();
    String motorista = txtMotorista.getText().toUpperCase(); 
    cavalo cavalo = new cavalo(0, frota, cavalos, empresa, motorista) ; 
    Cavalodao cavalodao = new Cavalodao();
    if (cavalodao.cavaloadd(cavalo)) {
        Alert alert = new Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
      alert.setHeaderText("Bobtail Cadastrado");
      alert.showAndWait();
    } else {
      Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
      alert.setHeaderText("Bobtail não Cadastrado.");
    }
    }
    

  }

