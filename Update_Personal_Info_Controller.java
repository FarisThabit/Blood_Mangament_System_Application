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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Update_Personal_Info_Controller implements Initializable {
    int RDID = Show_And_Update_Medical_History.RDID;
    String User_Type = Show_And_Update_Medical_History.User_Type;

    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private Label l1;

    @FXML
    private Label l10;

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
    private Label l9;

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;


    @FXML
    private TextField tf3;

    public static boolean manger_Login = false;

    @FXML
    void BackButtISClicked(ActionEvent event) throws IOException {
        if(User_Type == "Donor" && !manger_Login ){
            Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Donor_Interface.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);
        }
        else if(User_Type == "Recipent" && !manger_Login ){
            Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Recipient_Interface.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);
        }
        else{
            Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Manger_Interface.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);

        }
    }

    @FXML
    void updateButtIsClicked(ActionEvent event) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
        );
        Statement statement = connection.createStatement();
        if(User_Type == "Donor"){

            if(tf1.getText() != null){
                String sqlCommand = "Update Donor set Number ='"+tf1.getText()+"' where ID ="+RDID;
                statement.executeUpdate(sqlCommand);

            }
            if(tf2.getText() != null){
                String sqlCommand = "Update Donor set Email ='"+tf2.getText()+"' where ID="+RDID;
                statement.executeUpdate(sqlCommand);

            }
            if(tf3.getText()!= null){
                String sqlCommand = "Update Donor set Address ='"+tf3.getText()+"' where ID="+RDID;
                statement.executeUpdate(sqlCommand);

            }
            if(tf1.getText() == null && tf2.getText() == null && tf3.getText() == null){
                l8.setText("Fill the required info to update");
            }
        }
        else{
            System.out.println("Recipent");
            if(tf1.getText() != null){
                String sqlCommand = "Update recipent set Number ='"+tf1.getText()+"' where ID ="+RDID;
                statement.executeUpdate(sqlCommand);

            }
            if(tf2.getText() != null){
                String sqlCommand = "Update recipent set Email ='"+tf2.getText()+"' where ID="+RDID;
                statement.executeUpdate(sqlCommand);

            }
            if(tf3.getText()!= null){
                String sqlCommand = "Update recipent set Address ='"+tf3.getText()+"' where ID="+RDID;
                statement.executeUpdate(sqlCommand);

            }
            if(tf1.getText() == null && tf2.getText() == null && tf3.getText() == null){
                l8.setText("Fill the required info to update");
            }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{


            if(User_Type == "Donor"){
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
                );
                Statement statement = connection.createStatement();
                String sqlCommand = "select Number, Email, Address from donor where ID="+ RDID;
                ResultSet resultset = statement.executeQuery(sqlCommand);

                    while (resultset.next()){
                        System.out.println("while is enterd");
                        l5.setText(resultset.getString("Number"));
                        l6.setText(resultset.getString("Email"));
                        l7.setText(resultset.getString("Address"));

                    }
                }


            else{
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
                );
                Statement statement = connection.createStatement();
                String sqlCommand = "select Number, Email, Address from Recipent where ID="+ RDID;
                ResultSet resultset = statement.executeQuery(sqlCommand);
                    while (resultset.next()){
                        l5.setText(resultset.getString("Number"));
                        l6.setText(resultset.getString("Email"));
                        l7.setText(resultset.getString("Address"));

                    }

            }

          } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }
}
