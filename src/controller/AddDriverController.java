package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Driver;

import java.util.ArrayList;

public class AddDriverController {
    public AnchorPane addDriverContext;

    public TableView tblDriver;
    public TableColumn colName;
    public TableColumn colNIC;
    public TableColumn colLicense;
    public TableColumn colAddress;
    public TableColumn colContact;

    static ArrayList<Driver> drivers=new ArrayList();
    public TextField txtName;
    public TextField txtNIC;
    public TextField txtLicense;
    public TextField txtAddress;
    public TextField txtContact;

    public void initialize(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colLicense.setCellValueFactory(new PropertyValueFactory<>("liceneNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }
    public void addDriver(ActionEvent actionEvent) {
        Driver driver = new Driver(txtName.getText(),txtNIC.getText(),txtLicense.getText(),txtAddress.getText(),Integer.parseInt(txtContact.getText()));

        txtName.clear();txtNIC.clear();txtLicense.clear();txtAddress.clear();txtContact.clear();

        if (drivers.add(driver)){
            loadAllDriver();
            new Alert(Alert.AlertType.CONFIRMATION,"Saved successfully...", ButtonType.CLOSE).show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Try Again...", ButtonType.CLOSE).show();
        }
    }
    private void loadAllDriver(){
        ObservableList<Driver> observableList= FXCollections.observableArrayList();
        for (Driver temp : drivers){
            observableList.add(new Driver(temp.getName(),temp.getNIC(),temp.getLiceneNo(),temp.getAddress(),temp.getContact()));
        }
        tblDriver.setItems(observableList);
    }
}
