package ParkingLotCode.repository;

import ParkingLotCode.exception.ParkingLotNotFoundException;
import ParkingLotCode.models.ParkingLot;

import java.util.HashMap;

public class ParkingLotRepository {
    HashMap<Integer, ParkingLot> ParkingLotMap;

    public ParkingLotRepository() {
        this.ParkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int ParkingLotId) throws ParkingLotNotFoundException {
        ParkingLot ParkingLot = ParkingLotMap.get(ParkingLotId);

        if(ParkingLot == null){
            throw new ParkingLotNotFoundException("Parking Lot Not Found" + ParkingLotId);
        }

        return ParkingLot;
    }

    public ParkingLot put(ParkingLot ParkingLot){
        ParkingLotMap.put(ParkingLot.getId(), ParkingLot);
        return ParkingLot;
    }
}

