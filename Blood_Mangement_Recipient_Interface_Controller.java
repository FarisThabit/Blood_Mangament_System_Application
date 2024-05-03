import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.xml.datatype.DatatypeConstants;
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
import java.util.Timer;

public class Blood_Mangement_Recipient_Interface_Controller implements Initializable {
    @FXML
    private CheckBox ch1;


    int RDID = Show_And_Update_Medical_History.RDID;

    String blood_type;

    ArrayList<Recipent_Request> DRs = new ArrayList<>();
    LocalDateTime currentDateTime = LocalDateTime.now();
    File fileName = new File("C://Users//faris//OneDrive//Desktop//New_Project//ICS321-PV0.1//src//Recipent_Requests.txt");



    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private Button Butt3;

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
    private ChoiceBox<String> chb1;
    String[] requestPayment = {"Free","Paid"};



    @FXML
    private TextField tf1;



    @FXML
    void RBDbuttisclicked(ActionEvent event) throws InterruptedException, IOException, SQLException {
        if (chb1.getValue().equals("Paid")) {
            l3.setText("You have to pay 100$ for the blood request");

            // Create a PauseTransition with a duration of 5 seconds
            PauseTransition pause = new PauseTransition(Duration.seconds(3));

            // Set the action to perform at the end of the pause
            pause.setOnFinished(e -> {
                l3.setText("Your request has been sent to the administrator");
                try{
                    System.out.println(fileName.length());
                    if (fileName.length() == 0) {
                        FileWriter fileWriter = new FileWriter(fileName);
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        Connection connection = DriverManager.getConnection(
                                "jdbc:mysql://127.0.0.1:3306/system_schema", "root", "FARISSQL20ics321"
                        );
                        Statement statement = connection.createStatement();
                        ResultSet resultset = statement.executeQuery("Select RMRN from recipent" +
                                " where ID = " + RDID);
                        int RMRN = 0;
                        if (resultset.next()) {
                            RMRN = resultset.getInt("RMRN");
                            String sqlCommand = "select Blood_Type from medical_history where MRN =" + RMRN;
                            resultset = statement.executeQuery(sqlCommand);
                            if (resultset.next()){
                                blood_type = resultset.getString("Blood_Type");
                                printWriter.println(new Recipent_Request(RDID, "Blood Request", currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Pending", blood_type).toString().strip());
                                printWriter.close();
                            }

                        }
                    }
                    else{
                        Scanner sc = new Scanner(fileName);
                        sc.useDelimiter(",|\\n");
                        int requestID = 0;
                        String requestType = "";
                        String requestDate = "";
                        String requestStatus = "";
                        String tbloodType;
                        int treaker = 0;
                        while (sc.hasNext()) {
                            if (treaker == 0 && sc.hasNext()) {
                                System.out.println("Tracker = " + treaker);
                                requestID = Integer.parseInt(sc.next());
                                System.out.println(requestID);
                                treaker++;
                            } else if (treaker == 1 && sc.hasNext()) {
                                System.out.println("Tracker = " + treaker);
                                requestType = sc.next();
                                System.out.println(requestType);
                                treaker++;
                            } else if (treaker == 2 && sc.hasNext()) {
                                System.out.println("Tracker = " + treaker);
                                requestDate = sc.next();
                                System.out.println(requestDate);
                                treaker++;
                            } else if (treaker == 3 && sc.hasNext()) {
                                System.out.println("Tracker = " + treaker);
                                requestStatus = sc.next();
                                System.out.println(requestStatus);
                                treaker++;
                            } else if (treaker == 4 && sc.hasNext()) {
                                System.out.println("Tracker = " + treaker);
                                tbloodType = sc.next();
                                System.out.println(tbloodType);
                                DRs.add(new Recipent_Request(requestID, requestType, requestDate, requestStatus, tbloodType));
                                treaker = 0;

                            }

                        }
                        sc.close();
                        FileWriter fileWriter = new FileWriter(fileName);
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        Connection connection = DriverManager.getConnection(
                                "jdbc:mysql://127.0.0.1:3306/system_schema", "root", "FARISSQL20ics321"
                        );
                        Statement statement = connection.createStatement();
                        ResultSet resultset = statement.executeQuery("Select RMRN from recipent" +
                                " where ID = " + RDID);
                        int RMRN = 0;
                        if (resultset.next()) {
                            RMRN = resultset.getInt("RMRN");
                            String sqlCommand = "select Blood_Type from medical_history where MRN =" + RMRN;
                            resultset = statement.executeQuery(sqlCommand);
                            if(resultset.next()){
                                blood_type = resultset.getString("Blood_Type");
                            }
                            Recipent_Request TRR = new Recipent_Request(RDID, "blood Request", currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Pending", blood_type);
                            DRs.add(TRR);
                            int i = 0;
                            while (i < DRs.size()) {
                                printWriter.println(DRs.get(i).toString().strip());
                                i++;
                            }
                            printWriter.close();

                        }

                    }


                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            });

            // Start the pause transition
            pause.play();
        } else {
            l3.setText("Your request has been sent to the administrator");
            System.out.println(fileName.length());
            if (fileName.length() == 0) {
                FileWriter fileWriter = new FileWriter(fileName);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/system_schema", "root", "FARISSQL20ics321"
                );
                Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery("Select RMRN from recipent" +
                        " where ID = " + RDID);
                int RMRN = 0;
                if (resultset.next()) {
                    RMRN = resultset.getInt("RMRN");
                    String sqlCommand = "select Blood_Type from medical_history where MRN =" + RMRN;
                    resultset = statement.executeQuery(sqlCommand);
                    if (resultset.next()){
                        blood_type = resultset.getString("Blood_Type");
                        printWriter.println(new Recipent_Request(RDID, "Blood Request", currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Pending", blood_type).toString().strip());
                        printWriter.close();
                    }

                }
            } else {
                Scanner sc = new Scanner(fileName);
                sc.useDelimiter(",|\\n");
                int requestID = 0;
                String requestType = "";
                String requestDate = "";
                String requestStatus = "";
                String tbloodType;
                int treaker = 0;
                while (sc.hasNext()) {
                    if (treaker == 0 && sc.hasNext()) {
                        System.out.println("Tracker = " + treaker);
                        requestID = Integer.parseInt(sc.next());
                        System.out.println(requestID);
                        treaker++;
                    } else if (treaker == 1 && sc.hasNext()) {
                        System.out.println("Tracker = " + treaker);
                        requestType = sc.next();
                        System.out.println(requestType);
                        treaker++;
                    } else if (treaker == 2 && sc.hasNext()) {
                        System.out.println("Tracker = " + treaker);
                        requestDate = sc.next();
                        System.out.println(requestDate);
                        treaker++;
                    } else if (treaker == 3 && sc.hasNext()) {
                        System.out.println("Tracker = " + treaker);
                        requestStatus = sc.next();
                        System.out.println(requestStatus);
                        treaker++;
                    } else if (treaker == 4 && sc.hasNext()) {
                        System.out.println("Tracker = " + treaker);
                        tbloodType = sc.next();
                        System.out.println(tbloodType);
                        DRs.add(new Recipent_Request(requestID, requestType, requestDate, requestStatus, tbloodType));
                        treaker = 0;

                    }

                }
                sc.close();
                FileWriter fileWriter = new FileWriter(fileName);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/system_schema", "root", "FARISSQL20ics321"
                );
                Statement statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery("Select RMRN from recipent" +
                        " where ID = " + RDID);
                int RMRN = 0;
                if (resultset.next()) {
                    RMRN = resultset.getInt("RMRN");
                    String sqlCommand = "select Blood_Type from medical_history where MRN =" + RMRN;
                    resultset = statement.executeQuery(sqlCommand);
                    if(resultset.next()){
                        blood_type = resultset.getString("Blood_Type");
                    }
                    Recipent_Request TRR = new Recipent_Request(RDID, "blood Request", currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), "Pending", blood_type);
                    DRs.add(TRR);
                    int i = 0;
                    while (i < DRs.size()) {
                        printWriter.println(DRs.get(i).toString().strip());
                        i++;
                    }
                    printWriter.close();

                }


                //  }

            }
        }
    }
    @FXML
    void exitButtIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Home.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);

    }

    @FXML
    void hospitalNameISbeingWritten(KeyEvent event) {
        butt1.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            butt1.setDisable(true);
            chb1.getItems().addAll(requestPayment);




    }
    @FXML
    void checkBoxClicked(MouseEvent event) {
        if(ch1.isSelected() == true){
            butt1.setDisable(false);
        }
        else{
            butt1.setDisable(true);

        }
    }



    @FXML
    void UpdatePersonalInfoButtIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Update_Personal_Info_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }


    @FXML
    void updateMedicalHistoryButtIsCliced(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Show_Medical_History.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);

    }
    @FXML
    void CheckRequestStatusButtIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Check_Reques_Status_Recipent_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }


}
