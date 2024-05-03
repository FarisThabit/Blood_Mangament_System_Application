import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login_As_Guest_Recipent_Controller implements Initializable {

    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private Button butt3;

    @FXML
    private Label l1;

    @FXML
    private Label l2;


    @FXML
    private Button butt4;

    @FXML
    private ChoiceBox<String> chb1;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private CheckBox chob1;

    String[] requestType = {"Free","Paid"};

    @FXML
    void LogOutBUttIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void RBDIsClickde(ActionEvent event) {
        l1.setText("You can't request blood as a guest");
    }

    @FXML
    void UPIButtIsClicked(ActionEvent event) {
        l1.setText("You can't update your information as a guest");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chb1.getItems().addAll(requestType);
        butt1.setDisable(true);
        butt2.setDisable(true);
        butt3.setDisable(true);
        butt4.setDisable(true);

    }
}
