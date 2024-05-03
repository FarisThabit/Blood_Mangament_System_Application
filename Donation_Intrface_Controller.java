import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Donation_Intrface_Controller implements Initializable {
    int DID = Blood_Mangement_System_Sign_up_Controller.ID;

    @FXML
    private Button butt1;

    @FXML
    private Button butt2;


    @FXML
    private CheckBox chob1;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    @FXML
    private Label l3;

    @FXML
    void DonateButtISclicked(ActionEvent event) throws SQLException, IOException {
        ArrayList<Donor_Request> DRs = new ArrayList<>();
        LocalDateTime currentDateTime = LocalDateTime.now();
        File fileName = new File("C://Users//faris//OneDrive//Desktop//New_Project//ICS321-PV0.1//src//Donor_Requests.txt");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/system_schema","root","FARISSQL20ics321"
        );
        // Get MRN
        Statement statement = connection.createStatement();
        System.out.println();
        String sqlCommand = "Select DMRN from donor where ID = "+DID;
        ResultSet resultset = statement.executeQuery(sqlCommand);
        int MRN =0;
        if(resultset.next()){
            MRN = resultset.getInt("DMRN");

        }
        // ENTER MH
        String sqlCommand2 = "Select Age, Weight, Major_diseases from medical_history where MRN ="+ MRN;
        ResultSet resultset2 = statement.executeQuery(sqlCommand2);
        boolean NoError = true;
            if(resultset2.next()){
                if(resultset2.getInt("Age")<17){
                    l2.setText("You can't donate: Your age is less than 17");
                    NoError = false;
                }
                if(resultset2.getInt("Weight")<52){
                    l2.setText("You can't donate: Your Weight is less than 52 KG");
                    NoError = false;
                }
                if(resultset2.getString("Major_diseases").equals("Yes")){
                    l2.setText("You can't donate: You have a major disease");
                    NoError = false;

                }

            }
        if(NoError){
            l3.setText("Your Donation Request has been sent to the adminstrator");
            if(fileName.length() == 0){
                FileWriter fileWriter = new FileWriter(fileName);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(new Donor_Request(DID,"Donation Request",currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Pending").toString().strip());
                printWriter.close();
            }
            else{
                Scanner sc = new Scanner (fileName);
                sc.useDelimiter(",|\\n");
                int requestID = 0;
                String requestType = "";
                String requestDate = "";
                String requestStatus = "";
                int treaker =0;
                while (sc.hasNext ()) {
                    if(treaker ==0 && sc.hasNext()){
                        requestID = Integer.parseInt(sc.next());
                        treaker++;
                    }
                    else if(treaker == 1 && sc.hasNext()){
                        requestType = sc.next();
                        treaker++;
                    }
                    else if(treaker == 2 && sc.hasNext()){
                        requestDate = sc.next();
                        treaker++;
                    }
                    else if(treaker == 3 && sc.hasNext()){
                        requestStatus = sc.next();
                        DRs.add(new Donor_Request(requestID,requestType,requestDate,requestStatus));
                        treaker = 0;
                    }

                }
                sc.close ();
                FileWriter fileWriter = new FileWriter(fileName);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                Donor_Request TDR= new Donor_Request(DID,"Donation Request",currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),"Pending");
                DRs.add(TDR);
                int i =0;
                while (i<DRs.size()){
                    printWriter.println(DRs.get(i).toString().strip());
                    i++;
                }
                printWriter.close();




            }

        }

    }

    @FXML
    void FastingChoiseboxIsClicked(MouseEvent event) {
        if(chob1.isSelected()){
            butt1.setDisable(false);
        }
        else{
            butt1.setDisable(true);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        butt1.setDisable(true);
    }
    @FXML
    void BackButtISClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Donor_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
