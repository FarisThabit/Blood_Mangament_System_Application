import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Requests_Controller implements Initializable {
    ArrayList<Donor_Request> DRs = new ArrayList<>();
    ArrayList<Recipent_Request> RDs = new ArrayList<>();

    String[] requstType = {"Donation Request", "Blood Request"};


    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private TextArea ta1;

    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private ChoiceBox<String> chob1 = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> chob2 = new ChoiceBox<>();

    @FXML
    private TextField tf1;

    @FXML
    private Label l4;


    String[] requestStatus = {"Approved","Disapproved"};


    @FXML
    void BackbuttIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Manger_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @FXML
    void ConfirmButtIsClicked(ActionEvent event) throws IOException {
        int i = 0;
      if(chob2.getValue().equals("Donation Request")){
            File fileName = new File("C://Users//faris//OneDrive//Desktop//New_Project//ICS321-PV0.1//src//Donor_Requests.txt");
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
            while (i<DRs.size()){

                if(Integer.parseInt(tf1.getText()) == (DRs.get(i).returenID())){
                    DRs.get(i).changeRequestStatus(chob1.getValue());
                    l3.setText("Your request has been "+chob1.getValue());
                }
                i++;
            }
            i =0;
            while(i<DRs.size()){
                pw.println(DRs.get(i).toString().strip());
                i++;
            }
            pw.close();


        }
        else{
            i =0;
          File fileName = new File("C://Users//faris//OneDrive//Desktop//New_Project//ICS321-PV0.1//src//Recipent_Requests.txt");
          FileWriter fw = new FileWriter(fileName);
          PrintWriter pw = new PrintWriter(fw);
          while (i<RDs.size()){

              if(Integer.parseInt(tf1.getText()) == (RDs.get(i).returnID())){
                  RDs.get(i).changeRewuestStatus(chob1.getValue());
                  l3.setText("Your request has been "+chob1.getValue());
              }
              i++;
          }
          i =0;
          while(i<RDs.size()){
              pw.println(RDs.get(i).toString().strip());
              i++;
          }
          pw.close();



        }





    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            chob2.getItems().addAll(requstType);
            chob1.getItems().addAll(requestStatus);
            File fileName = new File("C://Users//faris//OneDrive//Desktop//New_Project//ICS321-PV0.1//src//Donor_Requests.txt");
        File fileName2 = new File("C://Users//faris//OneDrive//Desktop//New_Project//ICS321-PV0.1//src//Recipent_Requests.txt");

        // donor requests
            try{
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
                sc.close();
                Scanner sc2 = new Scanner(fileName2);
                sc2.useDelimiter(",|\\n");

                requestID = 0;
                requestType = "";
                requestDate = "";
                requestStatus = "";
                String tbloodType2;
                int treaker2 = 0;
                while (sc2.hasNext()) {
                    if (treaker2 == 0 && sc2.hasNext()) {
                        requestID = Integer.parseInt(sc2.next());
                        treaker2++;
                    } else if (treaker2 == 1 && sc2.hasNext()) {
                        requestType = sc2.next();
                        treaker2++;
                    } else if (treaker2 == 2 && sc2.hasNext()) {
                        requestDate = sc2.next();
                        treaker2++;
                    } else if (treaker2 == 3 && sc2.hasNext()) {
                        requestStatus = sc2.next();
                        treaker2++;
                    } else if (treaker2 == 4 && sc2.hasNext()) {
                        tbloodType2 = sc2.next();
                        RDs.add(new Recipent_Request(requestID, requestType, requestDate, requestStatus, tbloodType2));
                        treaker2 = 0;

                    }

                }
                sc2.close();
                int i =0;
                int x = 0;
                while (i< RDs.size()){
                    ta1.appendText(RDs.get(i).toString());
                    i++;
                }
                while (x<DRs.size()){
                    ta1.appendText(DRs.get(x).toString());
                    x++;
                }

            }
            catch(Exception ex){
                System.out.println(ex);
            }

    }
    }

