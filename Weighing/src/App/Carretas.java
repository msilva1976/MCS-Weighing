package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Carretas extends Application {
  private static Stage stage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage fourthsStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/View/carretas.fxml"));
    Scene scene = new Scene(root);
    fourthsStage.setTitle("Carretas");
    fourthsStage.setScene(scene);
    fourthsStage.show();
    setStage(fourthsStage);
       
  }

  public static Stage getStage() {
    return stage;
  }

  public static void setStage(Stage stage) {
    Carretas.stage = stage;
  }
  
}
