package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Principal;
import App.Usuarios;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalController implements Initializable {

    @FXML    private AnchorPane main;
    @FXML    private MenuItem menuBobs;
    @FXML    private MenuItem menuCarretas;
    @FXML    private MenuItem menuCavalos;
    @FXML    private MenuItem menuSair;
    @FXML    private MenuItem menuUsuarios;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuSair.setOnAction((MouseEvent)->{
            fecha();
        });
        menuUsuarios.setOnAction((KeyEvent)->{
            Usuarios usuarios = new Usuarios();
            try {
                usuarios.start(new Stage());
            } catch (Exception e) {
               
                e.printStackTrace();
            }
        });
        
   
    }

    public void fecha() {
        Principal.getStage().close();
    }
    
}
