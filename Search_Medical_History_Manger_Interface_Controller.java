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
import java.util.ResourceBundle;

public class Search_Medical_History_Manger_Interface_Controller implements Initializable {

    @FXML
    private Button butt1;

    @FXML
    private ChoiceBox<String> chb1;

    String[] job_type = {"Donor","Recipent"};

    @FXML
    private Label l1;

    @FXML
    private Label l2;


    @FXML
    private TextField tf1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chb1.getItems().addAll(job_type);
    }
    @FXML
    void SearchButtISClcked(ActionEvent event) throws IOException {
        if(tf1 == null || chb1.getValue() == null){
            l2.setText("Complete all information");
        }
        else{
            if(chb1.getValue() == "Donor"){
                Show_And_Update_Medical_History.manger = true;
                Show_And_Update_Medical_History.RDID = Integer.parseInt(tf1.getText());
                Show_And_Update_Medical_History.User_Type = chb1.getValue();
                Parent root = FXMLLoader.load(getClass().getResource("Show_Medical_History.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.setResizable(false);
            }
            else{
                Show_And_Update_Medical_History.manger = true;
                Show_And_Update_Medical_History.RDID = Integer.parseInt(tf1.getText());
                Show_And_Update_Medical_History.User_Type = chb1.getValue();
                Parent root = FXMLLoader.load(getClass().getResource("Show_Medical_History.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.setResizable(false);


            }
        }
    }
    @FXML
    void BackButtISclicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Manger_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }

}

