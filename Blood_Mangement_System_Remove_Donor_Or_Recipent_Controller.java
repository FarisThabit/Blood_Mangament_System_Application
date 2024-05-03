import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Blood_Mangement_System_Remove_Donor_Or_Recipent_Controller implements Initializable {

    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private ChoiceBox<String> chb1;

    @FXML
    private Label l1;


    @FXML
    private Label l13;


    @FXML
    private Label l2;


    @FXML
    private TextField tf1;

     String[] userType= {"Donor","Recipent"};

    @FXML
    void BackButtIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Remove_Edit_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);

    }

    @FXML
    void RemoveButtIsClicked(ActionEvent event) throws SQLException {
        if(chb1.getValue() == null || tf1.getText() == null){
            l13.setText("Fill the required info");
        }
        else if (chb1.getValue() == "Donor"){
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
            );
            Statement statement = connection.createStatement();
            // Delete a specfic Donor
            int ID = Integer.parseInt(tf1.getText());
            String SqlCommand = "delete from donor where ID ="+ID;
            statement.execute(SqlCommand);


        }
        else{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://17.0.0.1:3306/system_schema","root","FARISSQL20ics321"
            );
            Statement statement = connection.createStatement();
            // Delete a specfic Recipent
            int ID = Integer.parseInt(tf1.getText());
            String SqlCommand = "delete from recipent where ID ="+ID;
            statement.execute(SqlCommand);
        }

    }

    @FXML
    void tf1(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chb1.getItems().addAll(userType);

    }
}
