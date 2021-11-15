package model;

import static controller.InParkingController.parkedVehiclesTMObservableList;
import java.io.IOException;

public class Van extends Vehicle {
    int[] vanSlots = new int[]{1,2,3,4,12,13};
    public Van(){
        super();
    }
    public Van(String vehicleNo, String vehicleType, Integer maxWeight, Integer noOfPassengers) {
        super(vehicleNo,vehicleType,maxWeight,noOfPassengers);
    }

    @Override
    public int park(String vehicleNo,String vehicleType) throws IOException {
        L1: for (int i: vanSlots) {
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

