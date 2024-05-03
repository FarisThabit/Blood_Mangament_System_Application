import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Blood_Mangement_System_Home_Controller {

    @FXML
    private Button butt1;

    @FXML
    private Button butt2;

    @FXML
    private ImageView imgv1;

    @FXML
    private ImageView imgv2;

    @FXML
    private Label l1;

    @FXML
    void loginbuttclicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login_Interface.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void signupbuttclicked(ActionEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("Blood_Mangement_System_Sign up.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        }



    }





