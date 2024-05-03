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

public class Donor_Requests_Controller implements Initializable {
    ArrayList<Donor_Request> DRs = new ArrayList<>();
    File fileName = new File("C://Users//faris//OneDrive//Desktop//New_Project//ICS321-PV0.1//src//Donor_Requests.txt");

    int ID = Show_And_Update_Medical_History.RDID;
    @FXML
    private Button butt1;

    @FXML
    private Label l1;

    @FXML
    private TextArea ta1;

    @FXML
    void BackButtIsClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Donor_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Scanner sc = new Scanner(fileName);
            sc.useDelimiter(",|\\n");
            int requestID = 0;
            String requestType = "";
            String requestDate = "";
            String requestStatus = "";
            int treaker = 0;
            while (sc.hasNext()) {
                if (treaker == 0 && sc.hasNext()) {
                    requestID = Integer.parseInt(sc.next());
                    treaker++;
                } else if (treaker == 1 && sc.hasNext()) {
                    requestType = sc.next();
                    treaker++;
                } else if (treaker == 2 && sc.hasNext()) {
                    requestDate = sc.next();
                    treaker++;
                } else if (treaker == 3 && sc.hasNext()) {
                    requestStatus = sc.next();
                    DRs.add(new Donor_Request(requestID, requestType, requestDate, requestStatus));
                    treaker = 0;

                }

            }
            sc.close();
            int i =0;
            while (i<DRs.size()){
                if(DRs.get(i).returenID() == ID){
                    ta1.appendText(DRs.get(i).toString());
                }
                i++;
            }

        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}
