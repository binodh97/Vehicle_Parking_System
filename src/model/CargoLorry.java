package model;

import static controller.InParkingController.parkedVehiclesTMObservableList;
import java.io.IOException;

public class CargoLorry extends Vehicle {
    int[] cargoLorrySlots = new int[]{5,6,7,8,9,10,11};
    public CargoLorry(){
        super();
    }
    public CargoLorry(String vehicleNo, String vehicleType, Integer maxWeight, Integer noOfPassengers) {
        super(vehicleNo,vehicleType,maxWeight,noOfPassengers);
    }

    @Override
    public int park(String vehicleNo,String vehicleType) throws IOException {
        L1: for (int i: cargoLorrySlots) {
            if(parkedVehiclesTMObservableList.size()==0){
                return i;
            }
            else{
                L2: for (int j=0;j<parkedVehiclesTMObservableList.size();j++) {
                    if(parkedVehiclesTMObservableList.get(j).getParkingSlot()==i){
                        continue L1;
                    }
                    else{
                        if(j!=parkedVehiclesTMObservableList.size()-1){
                            continue L2;
                        }
                        else{
                            return i;
                        }
                    }
                }
            }
        }
        return 0;

    }

}
