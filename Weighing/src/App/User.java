package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class User extends Application{
  private static Stage stage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage fridayStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/View/user.fxml"));
    Scene scene = new Scene(root);
    fridayStage.setTitle("User");
    fridayStage.setScene(scene);
    fridayStage.show();
    setStage(fridayStage);
    
  }

  public static Stage getStage() {
    return stage;
  }

  public static void setStage(Stage stage) {
    User.stage = stage;
  }
  
}
