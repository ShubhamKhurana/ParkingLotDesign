package ParkingLotCode.service.strategy.slotAllocationStrategy;

import ParkingLotCode.models.Gate;
import ParkingLotCode.models.ParkingLot;
import ParkingLotCode.models.ParkingSlot;
import ParkingLotCode.models.Vehicle;
import ParkingLotCode.models.constants.ParkingSlotStatus;
import ParkingLotCode.models.constants.VehicleType;

public class NearestSlotAllocationStrategy implements SlotAllocationStrategy{
    private ParkingSlot checkIfSlotAvailable(VehicleType vehicleType, ParkingLot parkingLot, int floorNumber){

        for(ParkingSlot slot : parkingLot.getParkingFloorList().get(floorNumber).getParkingSlotList()){
            if(slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE) &&
                    slot.getVehicleType().equals(vehicleType)){
                slot.setParkingSlotStatus(ParkingSlotStatus.NOT_AVAILABLE);
                return slot;
            }
        }

        return null;
    }
    public ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate){
        int floorNumber = entryGate.getFloorNumber();

        ParkingSlot parkingSlot = checkIfSlotAvailable(vehicleType, parkingLot, floorNumber);
        if(parkingSlot != null) return parkingSlot;

        int i = floorNumber-1;
        int j = floorNumber+1;

        while(i>=0 || j<parkingLot.getParkingFloorList().size()){
            if(i>=0){
                parkingSlot = checkIfSlotAvailable(vehicleType, parkingLot, i);
                if(parkingSlot != null) return parkingSlot;
            }

            if(j<parkingLot.getParkingFloorList().size()){
                parkingSlot = checkIfSlotAvailable(vehicleType, parkingLot, j);
                if(parkingSlot != null) return parkingSlot;
            }

            i--;
            j++;
        }

        return null;
    }
}
