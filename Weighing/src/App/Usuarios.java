package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Usuarios extends Application{
  private static Stage stage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage fridaysStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/View/usuarios.fxml"));
    Scene scene = new Scene(root);
    fridaysStage.setTitle("Usuarios");
    fridaysStage.setScene(scene);
    fridaysStage.show();
    setStage(fridaysStage);
    }

  public static Stage getStage() {
    return stage;
  }

  public static void setStage(Stage stage) {
    Usuarios.stage = stage;
  }
    
  
}
