package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Cavalo;
import App.Principal;

import DAO.Cavalodao;
import Model.CavaloModel;
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
      cadastracavalo();
    });
    btnCadastrar.setOnKeyPressed((KeyEvent e)->{
      if (e.getCode() == KeyCode.ENTER) {
        cadastracavalo();
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
        cadastracavalo();
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
  private void cadastracavalo(){
    String frota = txtFrota.getText();
    String placacavalo = txtPlaCavalo.getText().toUpperCase();   
    String empresa =  txtEmpresa.getText().toUpperCase();
    String motorista = txtMotorista.getText().toUpperCase();
    Model.CavaloModel cavalo = new CavaloModel(0, frota, placacavalo, empresa, motorista);
    Cavalodao cavalodao = new Cavalodao(); 
    if (cavalodao.cavaloadd(cavalo)) {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setHeaderText("Cavalo não Cadastrado");
      alert.showAndWait();
    } else {      
      Alert alert = new Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
      alert.setHeaderText("Cavalo Cadastrado");
      alert.showAndWait();  
      fechar();    
      
    }
   
    }
    

  }

