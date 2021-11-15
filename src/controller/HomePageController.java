package controller;

import static controller.InParkingController.parkedVehiclesTMObservableList;
import static controller.OnDeliveryController.onDeliveryVehiclesTMObservableList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;
import model.Vehicle;
import view.tm.OnDeliveryVehicleTM;
import view.tm.ParkVehicleTM;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import static controller.AddDriverController.drivers;
import static controller.AddVehicleController.vehicles;

public class HomePageController {
    public ComboBox <String> cmbVehicle;
    public ComboBox <String> cmbDriver;
    public TextField time;
    public AnchorPane homePagecontext;
    public TextField slotNumber;
    public TextField vType;
    public Button parkVehicle;
    public Button onDeliveryShift;
    public TextField Date;

    public void initialize(){
        for (Vehicle temp : vehicles) {
            cmbVehicle.getItems().add(temp.getVehicleNo());
        }

        cmbVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            slotNumber.clear();
            cmbVehicle.setAccessibleText(newValue);
            for (Vehicle temp : vehicles) {
                if (newValue.equals(temp.getVehicleNo())) {
                    vType.setText(temp.getVehicleType());
                    disableAndEnable(cmbVehicle.getValue().toString());
                    if(!parkVehicle.isDisable()){
                        try {
                            slotNumber.setText(temp.park(temp.getVehicleNo(), temp.getVehicleType()) + "");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        for (Driver d : drivers) {
            cmbDriver.getItems().add(d.getName());
        }

        Thread clock = new Thread() {
            public void run() {
                for (; ; ) {
                    DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                    Calendar cal = Calendar.getInstance();

                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    //System.out.println(hour + ":" + (minute) + ":" + second);
                    try {
                        String state = null;
                        if (hour >= 12) {
                            state = "PM";
                        } else {
                            state = "AM";
                        }
                        time.setText("    " + String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second) + " " + state);
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    }catch (NullPointerException e){
                        System.out.println(e);
                    }
                }
            }
        };
        clock.start();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        // System.out.println(dateFormat.format(date));
        Date.setText(dateFormat.format(date));

    }

    public void disableAndEnable(String vehicleNo){
        parkVehicle.setDisable(false);
        onDeliveryShift.setDisable(false);
        for (ParkVehicleTM temp:parkedVehiclesTMObservableList) {
            if(temp.getVehicleNo().equals(vehicleNo)){
                parkVehicle.setDisable(true);
            }
        }
        if(!parkVehicle.isDisable()){
            onDeliveryShift.setDisable(true);
        }
    }

    public void openMngmntLogin(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManagementLogin.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void parkingOnAction(ActionEvent actionEvent) {
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            ParkVehicleTM parkedVehicleTM = new ParkVehicleTM(cmbVehicle.getValue().toString(),vType.getText(), Integer.parseInt(slotNumber.getText()),java.time.LocalDateTime.now().format(dateTimeFormatter));
            parkedVehiclesTMObservableList.add(parkedVehicleTM);

            slotNumber.clear();
        }catch (NullPointerException e){

        }
    }

    public void deliveryOnAction(ActionEvent actionEvent) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm a");
            parkedVehiclesTMObservableList.removeIf(temp -> temp.getVehicleNo().equals(cmbVehicle.getValue().toString()));
            OnDeliveryVehicleTM onDeliveryVehicleTM = new OnDeliveryVehicleTM(cmbVehicle.getValue().toString(),vType.getText(),cmbDriver.getValue().toString(),java.time.LocalDateTime.now().format(dateTimeFormatter));
            onDeliveryVehiclesTMObservableList.add(onDeliveryVehicleTM);
        }catch (NullPointerException e){

        }
    }

    public void refresh(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/HomePage.fxml");
        Parent load = FXMLLoader.load(resource);
        homePagecontext.getChildren().clear();
        homePagecontext.getChildren().add(load);
    }
}
