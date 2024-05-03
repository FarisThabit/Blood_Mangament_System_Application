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
import java.sql.Statement;
import java.util.ResourceBundle;

public class Blood_Mangement_System_Recipent_Controller implements Initializable {
    // Storing the Recipent ID from the signup page
    int RID = Blood_Mangement_System_Sign_up_Controller.ID;
    @FXML
    private Button butt1;

    public static String bloodType;

    @FXML
    private ChoiceBox<String> cb1;


    @FXML
    private ChoiceBox<String> chb2;


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
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    String[] bloodTypes = {"AB+","AB-","A+","A-","B+","B-","O+","O-"};

    String[] majorDiseases = {"Yes", "No"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cb1.getItems().addAll(bloodTypes);
        chb2.getItems().addAll(majorDiseases);
        cb1.setOnAction(this::updateBloodType);
    }
    public void updateBloodType(ActionEvent event){
        bloodType = cb1.getValue();
    }
    @FXML
    void CompSingupButtIsClicked(ActionEvent event) throws IOException {

        try{
            bloodType = cb1.getValue();
            Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321");
            Statement statement = co.createStatement();
            int MRN = Integer.parseInt(tf3.getText());
            //Insert information to medical history
            String sqlCommand = "insert into medical_history(MRN,Weight,Age,Major_Diseases,Blood_Type)values("+MRN+",'"+tf2.getText()+"','"+tf1.getText()+"','"+chb2.getValue()+"','"+cb1.getValue()+"')";
            statement.execute(sqlCommand);
            //Update Recipent MRN

            String sqlCommand2 = "update recipent" +
                    " set RMRN = "+MRN+
                    " where ID =" + RID;
            statement.execute(sqlCommand2);
            Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Recipient_Interface.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);
        }
        catch (Exception ex){
            System.out.println(ex);
        }


    }

    @FXML
    void BackButtisClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Sign up.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }


}
