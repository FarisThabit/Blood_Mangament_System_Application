import com.mysql.cj.protocol.Resultset;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Blood_Mangement_Manger_Interface_Controller {

   public static boolean mangerAccess = false;

    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private Button butt3;

    @FXML
    private Button butt4;

    @FXML
    private Button butt5;


    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    void exitButtIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @FXML
    void ADDREP(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Remove_Edit_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @FXML
    void GenreateRBC(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Report_interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);

    }

    @FXML
    void PendingRequest(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Requests_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);

    }

    @FXML
    void SearchMH(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Search_Medical_History_Manger_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @FXML
    void SendBCA(ActionEvent event) throws SQLException, IOException {

        l2.setText("Emails has been sent to donors");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
        );
        File infile = new File("C://Users//faris//OneDrive//Desktop//New_Project//ICS321-PV0.1//src//Donors_Messages.txt");
        FileWriter fw = new FileWriter(infile);
        PrintWriter pw = new PrintWriter(fw);
        Statement statement = connection.createStatement();
        // to get donors emails
        String SqlCommand = "Select Email from donor";
        ResultSet resultset = statement.executeQuery(SqlCommand);
        pw.println("The donation period is open please start donating your bloods\nto:");
            while (resultset.next()){
                pw.println(resultset.getString("Email"));
            }
        pw.close();


    }

}
