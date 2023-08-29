package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Cavalo extends Application{
  private static Stage stage;

  public Cavalo(String frota, String placacavalo, String empresa, String motorista) {
  }
  public Cavalo() {
  }
  public static void main(String[] args) {
    launch(args);
  }
  @Override
  public void start(Stage fifthsStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/View/cavalos.fxml"));
    Scene scene = new Scene(root);
    fifthsStage.setTitle("Cavalo");
    fifthsStage.setScene(scene);
    fifthsStage.show();
    setStage(fifthsStage);
   
  }
  public static Stage getStage() {
    return stage;
  }
  public static void setStage(Stage stage) {
    Cavalo.stage = stage;
  }


  
}
