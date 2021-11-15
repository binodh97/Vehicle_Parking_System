package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementMainMenuController {
    public AnchorPane mngmntMMenuContext;
    public AnchorPane window;
    public ComboBox cmbOptions;

    public void initialize(){
        cmbOptions.getItems().addAll("In Parking", "On Delivery");
        //cmbOptions.getSelectionModel().selectFirst();

        cmbOptions.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if(newValue.equals("On Delivery")){
                URL resource = getClass().getResource("../view/OnDelivery.fxml");
                Parent load = null;
                try {
                    load = FXMLLoader.load(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                window.getChildren().clear();
                window.getChildren().add(load);
            }
            else if(newValue.equals("In Parking")){
                URL resource = getClass().getResource("../view/InParking.fxml");
                Parent load = null;
                try {
                    load = FXMLLoader.load(resource);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                window.getChildren().clear();
                window.getChildren().add(load);
            }
        });
    }

    public void openAddVehicle(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicle.fxml");
        Parent load = FXMLLoader.load(resource);
        window.getChildren().clear();
        window.getChildren().add(load);
    }

    public void openAddDriver(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        window.getChildren().clear();
        window.getChildren().add(load);
    }

    public void logOut(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) mngmntMMenuContext.getScene().getWindow();
            stage.close();
        }catch (Exception e) {}

    }
}
