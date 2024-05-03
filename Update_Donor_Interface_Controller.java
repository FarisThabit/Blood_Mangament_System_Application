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

public class Update_Donor_Interface_Controller implements Initializable {

    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Label l5;


    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt1.setDisable(true);
    }

    @FXML
    void BackButtonPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Donor_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }


    @FXML
    void UpdateButtPresssed(ActionEvent event) {
        l2.setText("Your information has been updated");
    }
    @FXML
    void Addressinputed(KeyEvent event) {
        if(butt1.isDisable()){
            if(tf1.getText() != null || tf2.getText() != null || tf3.getText() != null ){
                butt1.setDisable(false);
        }

        }}

}
