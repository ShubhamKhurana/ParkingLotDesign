package ParkingLotCode.repository;

import ParkingLotCode.exception.ParkingFloorNotFoundException;
import ParkingLotCode.models.ParkingFloor;

import java.util.HashMap;

public class ParkingFloorRepository {
    HashMap<Integer, ParkingFloor> ParkingFloorMap;

    public ParkingFloorRepository() {
        this.ParkingFloorMap = new HashMap<>();
    }

    public ParkingFloor get(int ParkingFloorId) throws ParkingFloorNotFoundException {
        ParkingFloor ParkingFloor = ParkingFloorMap.get(ParkingFloorId);

        if(ParkingFloor == null){
            throw new ParkingFloorNotFoundException("Parking Floor Not Found" + ParkingFloorId);
        }

        return ParkingFloor;
    }

    public ParkingFloor put(ParkingFloor ParkingFloor){
        ParkingFloorMap.put(ParkingFloor.getId(), ParkingFloor);
        return ParkingFloor;
    }
}

