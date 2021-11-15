package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.ParkVehicleTM;

public class InParkingController {
    public TableView tblInParking;
    public TableColumn colNo;
    public TableColumn colType;
    public TableColumn colSlot;
    public TableColumn colTime;

    public static ObservableList<ParkVehicleTM> parkedVehiclesTMObservableList = FXCollections.observableArrayList();

    public void initialize(){
        tblInParking.setItems(parkedVehiclesTMObservableList);
        colNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        colType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));
    }
}
