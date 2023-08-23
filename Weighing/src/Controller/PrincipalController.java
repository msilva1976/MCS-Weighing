package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import App.Bobs;
import App.Carretas;
import App.Cavalo;
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
        menuSair.setOnAction((KeyEvent)->{
            fechar();
        });  
        menuUsuarios.setOnAction((KeyEvent)->{
            Usuarios usuarios = new Usuarios();
            try {
                usuarios.start(new Stage());
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        }); 
        menuCavalos.setOnAction((KeyEvent )->{
            Cavalo cavalo = new Cavalo();
            try {
                cavalo.start(new Stage());
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        });
        menuCarretas.setOnAction((KeyEvent)->{
            Carretas carretas = new Carretas();
            try {
                carretas.start(new Stage());
            } catch (Exception e) {
              
                e.printStackTrace();  
            }
        });
        menuBobs.setOnAction((KeyEvent)->{
            Bobs bobs = new Bobs();
            try {
                bobs.start(new Stage());
            } catch (Exception e) {
               
                e.printStackTrace();
            }
        });


    }
    public void fechar(){
        Principal.getStage().close();
    }



}
   
    

