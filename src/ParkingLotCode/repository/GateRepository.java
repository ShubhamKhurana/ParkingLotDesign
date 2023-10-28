package ParkingLotCode.repository;

import ParkingLotCode.exception.GateNotFoundException;
import ParkingLotCode.models.Gate;

import java.util.HashMap;

// HashMaps are considered as Database for this project

// Repo Layer should only have CRUD logic
// i.e., storing and retrieving data from database (here, hashmaps)
// No business logic should reside in Repository Layer
public class GateRepository {
    HashMap<Integer, Gate> gateMap;

    public GateRepository() {
        this.gateMap = new HashMap<>();
    }

    public Gate get(int gateId) throws GateNotFoundException {
        Gate gate = gateMap.get(gateId);

        if(gate == null){
            throw new GateNotFoundException("Gate Not Found" + gateId);
        }

        return gate;
    }

    public Gate put(Gate gate){
        gateMap.put(gate.getId(), gate);
        return gate;
    }
}
