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

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Show_And_Update_Medical_History implements Initializable {
    public static int RDID;
    public static String User_Type;

    @FXML
    private Button Butt1;


    @FXML
    private Button Butt2;

    @FXML
    private ChoiceBox<String> chb1;

    String major_Diseases[] = {"Yes","No"};


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

    public static boolean manger = false;
    @FXML
    void BackButtISclicked(ActionEvent event) throws IOException {
        if(User_Type == "Donor" && !manger){
            Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Donor_Interface.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            stage.setResizable(false);
        }
        else if(User_Type == "Recipent" && !manger){
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
    void UpdateButtIsClicked(ActionEvent event) throws SQLException {
        if(User_Type == "Donor"){
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
            );
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("Select DMRN from donor" +
                                                      " where ID = "+ RDID );
            int DMRN = 0;
            if(resultset.next()){
                DMRN = resultset.getInt("DMRN");

            }
            if(tf1.getText() != null){
                 statement.executeUpdate("update medical_history" +
                                                        " set Age ="+ tf1.getText() +
                                                         " where MRN ="+ DMRN);

            }
            if(tf2.getText() != null){
                statement.executeUpdate("update medical_history" +
                        " set Weight ="+ tf2.getText() +
                        " where MRN ="+ DMRN);


            }

            if(chb1.getValue() != null){
                System.out.println(chb1.getValue());
                String sql = "UPDATE medical_history SET Major_diseases = '" + chb1.getValue() + "' WHERE MRN = " + DMRN;
                statement.executeUpdate(sql);
            }
            if(chb1.getValue() == null && tf2.getText() == null && tf1.getText() == null){

            }
        }
        else{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
            );
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("Select RMRN from recipent " +
                    "where ID = "+Show_And_Update_Medical_History.RDID );
            int RMRN = 0;
            if(resultset.next())
                RMRN = resultset.getInt("RMRN");

            if(tf1.getText() != null){
                statement.executeUpdate("update medical_history set Age = "+tf1.getText()+" where MRN = "+ RMRN);
            }

            if(tf2.getText() != null){
                statement.executeUpdate("update medical_history set Weight = "+tf2.getText()+" where MRN = "+ RMRN);

            }



            if(chb1.getValue() != null){
                statement.executeUpdate("update medical_history set Major_diseases = '"+chb1.getValue()+"' where MRN = "+ RMRN);

            }

            if(chb1.getValue() == null && tf2.getText() == null && tf1.getText() == null){
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       /* if (User_Type == "Donor") {
            try {
                //l5.setText("O-");
                chb1.getItems().addAll(major_Diseases);
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/system_schema", "root", "FARISSQL20ics321"
                );
                Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery("Select DMRN from donor where ID = " + Show_And_Update_Medical_History.RDID);

                int DMRN = 0;
                if (resultset.next()) {
                    DMRN = resultset.getInt("DMRN");
                }

                resultset = statement.executeQuery("select Weight, Age, Major_diseases, Blood_type from medical_history" +
                        " where MRN =" + DMRN);
                while (resultset.next()) {
                    l7.setText(resultset.getString("Weight"));
                    l6.setText(resultset.getString("Age"));
                    l8.setText(resultset.getString("Major_diseases"));
                    l5.setText(resultset.getString("Blood_type"));
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

        }*/
        try{
            if (User_Type == "Donor"){
                chb1.getItems().addAll(major_Diseases);
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/system_schema", "root", "FARISSQL20ics321"
                );
                Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery("Select DMRN from donor where ID = " + Show_And_Update_Medical_History.RDID);

                int DMRN = 0;
                if (resultset.next()) {
                    DMRN = resultset.getInt("DMRN");
                }

                resultset = statement.executeQuery("select Weight, Age, Major_diseases, Blood_type from medical_history" +
                        " where MRN =" + DMRN);
                while (resultset.next()) {
                    l7.setText(resultset.getString("Weight"));
                    l6.setText(resultset.getString("Age"));
                    l8.setText(resultset.getString("Major_diseases"));
                    l5.setText(resultset.getString("Blood_type"));

            }}
            else{
                System.out.println("ELSE is entered");
                chb1.getItems().addAll(major_Diseases);
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/system_schema", "root", "FARISSQL20ics321"
                );
                Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery("Select RMRN from recipent where ID = " + Show_And_Update_Medical_History.RDID);

                int RMRN = 0;
                if (resultset.next()) {
                    RMRN = resultset.getInt("RMRN");
                }

                resultset = statement.executeQuery("select Weight, Age, Major_diseases, Blood_type from medical_history" +
                        " where MRN =" + RMRN);
                while (resultset.next()) {
                    l7.setText(resultset.getString("Weight"));
                    l6.setText(resultset.getString("Age"));
                    l8.setText(resultset.getString("Major_diseases"));
                    l5.setText(resultset.getString("Blood_type"));


                }
        }


    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
