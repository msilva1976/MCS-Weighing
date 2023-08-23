package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Principal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class PrincipalController implements Initializable {

    @FXML
    private AnchorPane main;
    @FXML
    private MenuItem menuBobs;
    @FXML
    private MenuItem menuCarretas;
    @FXML
    private MenuItem menuCavalos;
    @FXML
    private MenuItem menuSair;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuSair.setOnAction((MouseEvent)->{
            fecha();
        });
        
   
    }
    public void fecha() {
        Principal.getStage().close();
    }

}
