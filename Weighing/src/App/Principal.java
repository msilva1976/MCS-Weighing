package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {
  private static Stage stage;
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage secondsStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/View/main.fxml"));
    Scene scene = new Scene(root);
    secondsStage.setTitle("Weighing Control");
    secondsStage.setScene(scene);
    secondsStage.show();
    setStage(secondsStage);
    
    
  }

  public static Stage getStage() {
    return stage;
  }

  public void setStage(Stage stage) {
    Principal.stage = stage;
  }
  
}
