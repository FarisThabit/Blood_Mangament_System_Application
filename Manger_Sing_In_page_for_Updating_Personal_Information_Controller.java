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

public class Manger_Sing_In_page_for_Updating_Personal_Information_Controller implements Initializable {
    int RDID = Show_And_Update_Medical_History.RDID;
    String User_Type = Show_And_Update_Medical_History.User_Type;

    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private ChoiceBox<String> chb1;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private TextField tf1;

    String[] jobType = {"Donor","Recipent"};

    public static boolean manger = false;

    @FXML
    void BackButtIsClicked(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Manger_Interface.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);



    }

    @FXML
    void ShowAndUpdatePersonalInfoISClicked(ActionEvent event) throws IOException {
        if(tf1.getText() != null && chb1.getValue() != null){
                Show_And_Update_Medical_History.RDID = Integer.parseInt(tf1.getText());
                Show_And_Update_Medical_History.User_Type = chb1.getValue();
                Parent root = FXMLLoader.load(getClass().getResource("Update_Personal_Info_Interface.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.setResizable(false);

        }
        else{
            l4.setText("Fill all required info");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chb1.getItems().addAll(jobType);

    }
}
