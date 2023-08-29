package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Bobs extends Application {
  private static Stage stage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage thirdStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/View/bobs.fxml"));
    Scene scene = new Scene(root);
    thirdStage.setTitle("Bobs");
    thirdStage.setScene(scene);
    thirdStage.show();
    setStage(thirdStage);

  }

  public static Stage getStage() {
    return stage;
  }

  public static void setStage(Stage stage) {
    Bobs.stage = stage;
  }

}
