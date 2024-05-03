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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Update_Recipent_Interface implements Initializable {

    @FXML
    private Button Butt1;

    @FXML
    private Button Butt2;

    @FXML
    private Label l1;

    @FXML
    private TextField l2;

    @FXML
    private TextField l3;

    @FXML
    private TextField l4;

    @FXML
    private Label l5;

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @FXML
    void BackButtIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Recipient_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @FXML
    void UpdateButtIsClicked(ActionEvent event) {
        l5.setText("Your info has been updated");
    }
    @FXML
    void UserEnteredSomethingtoUpdate(KeyEvent event){
        if(Butt1.isDisable()){
            if(tf1.getText() != null || tf2.getText() != null || tf3.getText() != null){
                Butt1.setDisable(false);
            }
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Butt1.setDisable(true);
    }
}
