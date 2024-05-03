import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Report_Controller implements Initializable {

    @FXML
    private Button butt1;

    @FXML
    private Label l1;

    @FXML
    private Label l10;

    @FXML
    private Label l11;

    @FXML
    private Label l12;

    @FXML
    private Label l13;

    @FXML
    private Label l14;

    @FXML
    private Label l15;

    @FXML
    private Label l16;

    @FXML
    private Label l17;

    @FXML
    private Label l18;

    @FXML
    private Label l19;

    @FXML
    private Label l2;

    @FXML
    private Label l20;

    @FXML
    private Label l21;

    @FXML
    private Label l22;

    @FXML
    private Label l23;

    @FXML
    private Label l24;

    @FXML
    private Label l25;

    @FXML
    private Label l26;

    @FXML
    private Label l27;

    @FXML
    private Label l28;

    @FXML
    private Label l29;

    @FXML
    private Label l3;

    @FXML
    private Label l30;

    @FXML
    private Label l31;

    @FXML
    private Label l32;

    @FXML
    private Label l33;

    @FXML
    private Label l34;

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
    void BackButtIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Manger_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            int Counter = 0;
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
            );
            Statement statement = connection.createStatement();
            // Callculate statistics for donors
            String sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'A+' AND MRN in(select RMRN from recipent)";
            ResultSet resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l4.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'A-' AND MRN in(select RMRN from recipent)";
             resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l5.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'B+' AND MRN in(select RMRN from recipent)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l8.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'B-' AND MRN in(select RMRN from recipent)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l9.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'O+' AND MRN in(select RMRN from recipent)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l12.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'O-' AND MRN in(select RMRN from recipent)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l13.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'AB+' AND MRN in(select RMRN from recipent)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l16.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'AB-' AND MRN in(select RMRN from recipent)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l17.setText(""+Counter);
            // donor statstics
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'A+' AND MRN in(select DMRN from donor)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l21.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'A-' AND MRN in(select DMRN from donor)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l22.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'B+' AND MRN in(select DMRN from donor)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l25.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'B-' AND MRN in(select DMRN from donor)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l26.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'O+' AND MRN in(select DMRN from donor)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l29.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'O-' AND MRN in(select DMRN from donor)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l30.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'AB+' AND MRN in(select DMRN from donor)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l33.setText(""+Counter);
            Counter = 0;
            sqlCommand = "select Blood_Type from medical_history where Blood_Type= 'AB-' AND MRN in(select DMRN from donor)";
            resultset = statement.executeQuery(sqlCommand);
            while(resultset.next()){
                Counter++;
            }
            l34.setText(""+Counter);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
