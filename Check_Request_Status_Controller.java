import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Check_Request_Status_Controller implements Initializable {
    int ID =  Show_And_Update_Medical_History.RDID;
    ArrayList<Recipent_Request> RDs = new ArrayList<>();
    @FXML
    private Button butt1;

    @FXML
    private Label l1;

    @FXML
    private TextArea ta1;

    @FXML
    void BackButtIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Recipient_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            File fileName2 = new File("C://Users//faris//OneDrive//Desktop//New_Project//ICS321-PV0.1//src//Recipent_Requests.txt");
            Scanner sc2 = new Scanner(fileName2);
            sc2.useDelimiter(",|\\n");
            int requestID = 0;
            String requestType = "";
            String requestDate = "";
            String requestStatus = "";
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
            while (i<RDs.size()){
                if(RDs.get(i).returnID() == ID){
                    ta1.appendText(RDs.get(i).toString());
                }
                i++;
            }



        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
