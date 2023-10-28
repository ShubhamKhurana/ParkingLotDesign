package ParkingLotCode.models;

import ParkingLotCode.models.constants.ParkingLotStatus;
import ParkingLotCode.models.constants.VehicleType;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloorList;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> allowedVehicleTypes;
    private SlotAllocationStrategy slotAllocationStrategy;
    private BillAllocationStrategy billAllocationStrategy;
}
