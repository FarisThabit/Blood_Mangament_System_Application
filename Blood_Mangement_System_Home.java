import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Blood_Mangement_System_Home extends Application {
    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Blood_Mangement_System_Home.class.getResource("Blood_Mangement_System_Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Blood_Mangement_System_Home");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}