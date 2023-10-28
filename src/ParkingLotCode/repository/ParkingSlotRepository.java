package ParkingLotCode.repository;

import ParkingLotCode.exception.ParkingSlotNotFoundException;
import ParkingLotCode.models.ParkingSlot;

import java.util.HashMap;

public class ParkingSlotRepository {
    HashMap<Integer, ParkingSlot> parkingSlotMap;

    public ParkingSlotRepository() {
        this.parkingSlotMap = new HashMap<>();
    }

    public ParkingSlot get(int parkingSlotId) throws ParkingSlotNotFoundException {
        ParkingSlot parkingSlot = parkingSlotMap.get(parkingSlotId);

        if(parkingSlot == null){
            throw new ParkingSlotNotFoundException("Parking Slot Not Found" + parkingSlotId);
        }

        return parkingSlot;
    }

    public ParkingSlot put(ParkingSlot parkingSlot){
        parkingSlotMap.put(parkingSlot.getId(), parkingSlot);
        return parkingSlot;
    }
}

