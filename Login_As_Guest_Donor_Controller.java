import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login_As_Guest_Donor_Controller implements Initializable {

    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private Label l6;

    @FXML
    private Button butt3;


    @FXML
    private Button Butt4;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @FXML
    void BackbuttISPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void DonateButtIsPressed(ActionEvent event) {
        l1.setText("You can't Donate as a guest");
    }

    @FXML
    void UpdatePersonalInfoButtIsPressed(ActionEvent event) {
        l1.setText("You can't update your info as a guest");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt1.setDisable(true);
        butt2.setDisable(true);
        Butt4.setDisable(true);

    }
}
