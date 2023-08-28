package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Carretas;
import App.Principal;
import DAO.CarretaDao;
import Model.Carreta;
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


public class CarretasController implements Initializable {
    
  
 

  @FXML  private Button btnCadastrar;
  @FXML  private Button btnCancela;
  @FXML  private TextField txtCapacidade;
  @FXML  private TextField txtDestino;
  @FXML  private TextField txtEixo;
  @FXML  private TextField txtMotorista;
  @FXML  private TextField txtPlacaCarreta;
  @FXML  private TextField txtfrota;
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
      btnCadastrar.setOnMouseClicked((MouseEvent)->{
        cadastraCarreta();
      });
      btnCadastrar.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          cadastraCarreta();
        }
      });
      txtfrota.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          txtPlacaCarreta.requestFocus();
        }
      });
       txtPlacaCarreta.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          txttxtPlaCavalo.requestFocus();
        }
      });
       txttxtPlaCavalo.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          txtMotorista.requestFocus();
        }
      });
       txtMotorista.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          txtEixo.requestFocus();
        }
      });
       txtEixo.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          txtDestino.requestFocus();
        }
      });
       txtDestino.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          txtCapacidade.requestFocus();
        }
      });
       txtCapacidade.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          btnCadastrar.requestFocus();
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
    private void cadastraCarreta(){
      String frota = txtfrota.getText();
      String placaCarreta = txtPlacaCarreta.getText().toUpperCase();
      String placcaCavalo = txttxtPlaCavalo.getText().toUpperCase();
      String motorista =  txtMotorista.getText().toUpperCase();
      String eixos = txtEixo.getText();
      String destino  = txtDestino.getText().toUpperCase();
      String capacidade = txtCapacidade.getText();
       Carreta carreta = new Carreta(0, frota, placaCarreta, placcaCavalo, motorista, eixos, destino, capacidade);
       CarretaDao carretaDao = new CarretaDao();
       if (carretaDao.carretaadd(carreta)) {
         Alert alert = new Alert(AlertType.CONFIRMATION);
       alert.setHeaderText("Carreta Cadastrada.");
       alert.showAndWait();        
       }else{
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText("Carreta Não Cadastrada");
        alert.showAndWait();

       }
      

    }


}
