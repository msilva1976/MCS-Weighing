package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Bobs;
import App.Principal;
import DAO.BobDao;
import Model.Bob;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;



public class BobsController implements Initializable {

    

  @FXML  private Button btnCadastra;
  @FXML  private Button btnCancela;
  @FXML  private TextField txtFrota;
  @FXML  private TextField txtMotorista;
  @FXML  private TextField txtPlaca;
  @FXML  private TextField txtTara;
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      btnCancela.setOnMouseClicked((MouseEvent )->{
        fechar();
      });
      btnCancela.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          fechar();
        }
      });
      txtFrota.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          txtPlaca.requestFocus();
        }    
      });
      txtPlaca.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          txtTara.requestFocus();
        }
      });
      txtTara.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode()==KeyCode.ENTER) {
           txtMotorista.requestFocus();
        }
       
      });
      txtMotorista.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          btnCadastra.requestFocus();        
        }
      });
      btnCadastra.setOnMouseClicked((MouseEvent )->{
        cadastraBob();
      });
      btnCadastra.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
          cadastraBob();
          fechar();
        }
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
  private void cadastraBob(){
    String frota = txtFrota.getText();
    String placaBos = txtPlaca.getText();
    String tara = txtTara.getText();
    String motorista = txtMotorista.getText();
    Bob bob = new Bob(0, frota, placaBos, tara, motorista);
    BobDao bobDao = new BobDao();
    if (bobDao.bobadd(bob)) {
      Alert alert = new Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
      alert.setHeaderText("Bobtail Cadastrado");
      alert.showAndWait();
    } else {
      Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
      alert.setHeaderText("Bobtail não Cadastrado.");
    }

  }

}
