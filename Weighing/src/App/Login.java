package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {
  private static Stage stage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage pimaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/View/login.fxml"));
    Scene scene = new Scene(root);
    pimaryStage.setTitle("Login");
    pimaryStage.setScene(scene);
    pimaryStage.show();
    setStage(pimaryStage);

  }

  public static Stage getStage() {
    return stage;
  }

  public static void setStage(Stage stage) {
    Login.stage = stage;
  }

}
