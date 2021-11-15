package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.util.ArrayList;

public class AddVehicleController {
    public AnchorPane addVehicleContext;
    public TableView tblVehicle;
    public TableColumn colVNo;
    public TableColumn colMWeight;
    public TableColumn colVPassengers;
    public TableColumn colVType;

    static ArrayList<Vehicle> vehicles = new ArrayList();
    public ComboBox vehicleCmb;
    public TextField vehicleNo;
    public TextField maxWeight;
    public TextField noOfPassengers;

    public void initialize(){
        colVType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colMWeight.setCellValueFactory(new PropertyValueFactory<>("maxWeight"));
        colVNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colVPassengers.setCellValueFactory(new PropertyValueFactory<>("noOfPassengers"));

        vehicleCmb.getItems().addAll("Van","Bus","Cargo Lorry");
    }

    public void addVehicle(ActionEvent actionEvent) {
        if(vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Van")){
            Van van = new Van(vehicleNo.getText(),vehicleCmb.getValue().toString(),Integer.parseInt(noOfPassengers.getText()),Integer.parseInt(maxWeight.getText()));
            vehicleNo.clear();
            noOfPassengers.clear();
            maxWeight.clear();
            /*try {
                //vehicleCmb.getSelectionModel().clearSelection();
                vehicleCmb.getItems().clear();
            }catch (Exception e){}*/

            if (vehicles.add(van)){
                loadAllVehicle();
                new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
            }
        }

        if(vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Bus")){
            Bus bus = new Bus(vehicleNo.getText(),vehicleCmb.getValue().toString(),Integer.parseInt(noOfPassengers.getText()),Integer.parseInt(maxWeight.getText()));
            vehicleNo.clear();
            noOfPassengers.clear();
            maxWeight.clear();
           /* try {
                //vehicleCmb.getSelectionModel().clearSelection();
                vehicleCmb.getItems().clear();
            }catch (Exception e){}*/

            if (vehicles.add(bus)){
                loadAllVehicle();
                new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
            }
        }

        if(vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Cargo Lorry")){
            CargoLorry cargoLorry = new CargoLorry(vehicleNo.getText(),vehicleCmb.getValue().toString(),Integer.parseInt(noOfPassengers.getText()),Integer.parseInt(maxWeight.getText()));
            vehicleNo.clear();
            noOfPassengers.clear();
            maxWeight.clear();
            /*try {
                //vehicleCmb.getSelectionModel().clearSelection();
                vehicleCmb.getItems().clear();
            }catch (Exception e){}*/

            if (vehicles.add(cargoLorry)){
                loadAllVehicle();
                new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
            }
        }

    }
    private void loadAllVehicle(){
        ObservableList<Vehicle> observableList= FXCollections.observableArrayList();
        if (vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Cargo Lorry")){
            for (Vehicle t : vehicles){
                observableList.add(new CargoLorry(t.getVehicleNo(),t.getVehicleType(),t.getNoOfPassengers(),t.getMaxWeight()));
            }
            tblVehicle.setItems(observableList);
        }
        if (vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Van")){
            for (Vehicle t1 : vehicles){
                observableList.add(new Van(t1.getVehicleNo(),t1.getVehicleType(),t1.getNoOfPassengers(),t1.getMaxWeight()));
            }
            tblVehicle.setItems(observableList);
        }
        if (vehicleCmb.getSelectionModel().getSelectedItem().toString().equals("Bus")){
            for (Vehicle t2 : vehicles){
                observableList.add(new Bus(t2.getVehicleNo(),t2.getVehicleType(),t2.getNoOfPassengers(),t2.getMaxWeight()));
            }
            tblVehicle.setItems(observableList);
        }
    }
}
