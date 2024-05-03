import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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



public class Blood_Mangement_System_Sign_up_Controller implements Initializable {
    String sqlCommand;

    static int ID;

    @FXML
    private ChoiceBox<String> cb1;
    @FXML
    private Label l2;

    @FXML
    private Label l15;


    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @FXML
    private TextField tf4;

    @FXML
    private TextField tf5;

    @FXML
    private TextField tf6;

    @FXML
    public TextField tf7;

    @FXML
    private Label l66;



    String jobType;


    private String[] jopType = {"Donor", "Recipent", "Manger"};

    public void initialize(URL arg0, ResourceBundle arg1) {

        cb1.getItems().addAll(jopType);
        cb1.setOnAction(this::jobType);

    }
    public void jobType(ActionEvent event){
        jobType = cb1.getValue();
    }
    @FXML
    void Signupbuttisclicked(ActionEvent event) throws IOException, SQLException {
        try{


        if(jobType == "Donor"){
            Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321");
            Statement statement = co.createStatement();
            Update_Personal_Info_Controller.manger_Login = false;
            ID = Integer.parseInt(tf7.getText());
            sqlCommand = "insert into donor values("+ID+",'"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"','"+tf4.getText()+"',"+null+",'"+"Online"+"')";
            statement.execute(sqlCommand);
            Show_And_Update_Medical_History.RDID = ID;
            Show_And_Update_Medical_History.User_Type = "Donor";
            Show_And_Update_Medical_History.manger = false;
            Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Donor.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);


        }
        else if(jobType == "Recipent"){
            Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321");
            Statement statement = co.createStatement();
            Update_Personal_Info_Controller.manger_Login = false;
            ID = Integer.parseInt(tf7.getText());
             String sqlCommand = "insert into recipent values("+ID+",'"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"','"+tf4.getText()+"',"+null+",'"+"Online"+"')";
            statement.execute(sqlCommand);
            Show_And_Update_Medical_History.RDID = ID;
            Show_And_Update_Medical_History.User_Type = "Recipent";
            Show_And_Update_Medical_History.manger = false;
            Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Recipent.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);

        }
        else{
            Update_Personal_Info_Controller.manger_Login = true;
            Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321");
            Statement statement = co.createStatement();
            int ID = Integer.parseInt(tf7.getText());
            String sqlCommand = "insert into hospital_manger values("+ID+",'"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"','"+tf4.getText()+"',"+null+",'"+"Online"+"')";
            statement.execute(sqlCommand);
           Blood_Mangement_Manger_Interface_Controller.mangerAccess = true;
            Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Manger_Interface.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);

        }


        }
        catch(Exception ex){
            l66.setText("ID Already exists");
            System.out.println(ex);


        }


    }
    @FXML
    void backButtisClicked(ActionEvent event) throws IOException {
        if(!Blood_Mangement_Manger_Interface_Controller.mangerAccess){
            Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Home.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);
        }
        else{
            Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Remove_Edit_Interface.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);
        }






    }


}
