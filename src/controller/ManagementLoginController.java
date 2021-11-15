package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class ManagementLoginController {
    public TextField txtUserName;
    public TextField txtPassword;
    public AnchorPane mngmntLoginContext;

    public void managementProcess(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().equals("Admin") & !txtPassword.getText().isEmpty()){
            if(txtPassword.getText().equals("1234") ){

                URL resource = getClass().getResource("../view/ManagementMainMenu.fxml");
                Parent load = FXMLLoader.load(resource);
                Stage window = (Stage) mngmntLoginContext.getScene().getWindow();
                window.setScene(new Scene(load));

            }
        }
    }
    public void moveToPassword(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }

    public void backToHome(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) mngmntLoginContext.getScene().getWindow();
        stage.close();
    }


}
