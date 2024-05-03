import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Login_Interface_Controller implements Initializable {
    String DID;
    String RID;

    String MID;



    @FXML
    private Button butt1;


    @FXML
    private Button butt2;


    @FXML
    private Hyperlink hl1;


    @FXML
    private Hyperlink hl2;

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

    @FXML
    private TextField tf2;

    @FXML
    private ChoiceBox<String> chb1;

    String jobType;


    @FXML
    private Label l9;

    private String[] jopType = {"Donor", "Recipent", "Manger"};

    @FXML
    void LoginButtISclicked(ActionEvent event) throws SQLException, IOException {
        if(tf1.getText() == null || (tf1.getText()).strip() == "" || chb1.getValue() ==null){
            l4.setText("Fill all required info");
        }
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
        );
        Statement statement = connection.createStatement();
       boolean login = false;
        if(chb1.getValue() == "Donor"){
            ResultSet resultset = statement.executeQuery("Select ID from donor" );
            while (resultset.next()){
                if(tf1.getText().equals(resultset.getString("ID"))){
                    login = true;
                    DID = tf1.getText();

                }
            }
            if(login){
                Show_And_Update_Medical_History.User_Type = "Donor";
                Update_Personal_Info_Controller.manger_Login = false;
                Blood_Mangement_System_Sign_up_Controller.ID = Integer.parseInt(DID);
                Show_And_Update_Medical_History.manger = false;
                Show_And_Update_Medical_History.RDID = Integer.parseInt(DID);
                Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Donor_Interface.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

            }
            else{
                l4.setText("ID does not exist");

            }



        }
        else if(chb1.getValue()=="Recipent"){
            ResultSet resultset = statement.executeQuery("Select ID from recipent" );
            while (resultset.next()){
                if(tf1.getText().equals(resultset.getString("ID"))){
                    login = true;
                    RID = tf1.getText();

                }
            }
            if(login){
                Show_And_Update_Medical_History.User_Type = "Recipent";
                Update_Personal_Info_Controller.manger_Login = false;
                Show_And_Update_Medical_History.RDID = Integer.parseInt(RID);
                Show_And_Update_Medical_History.manger = false;
                Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Recipient_Interface.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

            }
            else{
                l4.setText("ID does not exist");

            }

        }
        else if(chb1.getValue()=="Manger"){
           Blood_Mangement_Manger_Interface_Controller.mangerAccess = true;
            ResultSet resultset = statement.executeQuery("Select ID from hospital_manger" );
            while (resultset.next()){
                if(tf1.getText().equals(resultset.getString("ID"))){
                    login = true;
                    MID = tf1.getText();


                }
            }
            if(login){
                Update_Personal_Info_Controller.manger_Login = true;
                Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Manger_Interface.fxml"));
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

            }
            else{
                l4.setText("ID does not exist");

            }



        }
        else{
            l4.setText("ID is not correct");
        }
    }

    @FXML
    void LoginasguestDonorISclicked(ActionEvent event) throws IOException, SQLException {


        Parent root = FXMLLoader.load(getClass().getResource("Login_As_Guest_Donor.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void LoginasguestRecipentISclicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login_As_Guest_Recipent.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);

    }

    @FXML
    void BackButtISclicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chb1.getItems().addAll(jopType);
        chb1.setOnAction(this::jobType);
    }
    public void jobType(ActionEvent event){
        jobType = chb1.getValue();
    }
}
