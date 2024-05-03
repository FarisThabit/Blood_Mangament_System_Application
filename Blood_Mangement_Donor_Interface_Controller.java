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

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Blood_Mangement_Donor_Interface_Controller implements Initializable {
    int DID = Blood_Mangement_System_Sign_up_Controller.ID;


    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private Button butt3;


    @FXML
    private Button butt4;



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
    private Label l6;

    @FXML
    private Label l7;

    @FXML
    private Label l8;

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @FXML
    private TextField tf4;

    @FXML
    private Button butt5;

    @FXML
    private Label l9;

    @FXML
    void DonateButtIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Donation_Intrface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);


   /* }
        if(tf2.getText() == null || (tf2.getText()).strip() == "" || tf3.getText() == null || (tf3.getText()).strip() == "" || tf4.getText() == null || (tf4.getText()).strip() =="") {
            l8.setText("*Fill the complete date");}
        else{
            l8.setText("Your Donation has been sent to the adminstration");
        }


    }

    @FXML
     void donationYearinputed(KeyEvent event) {
        if(tf2.getText() != null && tf3.getText() != null && tf4.getText() != null ){
            butt1.setDisable(false);
        }*/



    }

    @FXML
    void exitbuttisclicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      //  butt1.setDisable(true);
    }

    @FXML
    void UpdateButtisPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Update_Personal_Info_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }
    @FXML
    void ShowMedicHbuttIsClicked(ActionEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("Show_Medical_History.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);

    }


    @FXML
    void CheckRequestButtIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Donor_Requests_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);

    }

}
