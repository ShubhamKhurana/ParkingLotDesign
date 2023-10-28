package ParkingLotCode.service.strategy.slotAllocationStrategy;

import ParkingLotCode.models.Gate;
import ParkingLotCode.models.ParkingLot;
import ParkingLotCode.models.ParkingSlot;
import ParkingLotCode.models.Vehicle;
import ParkingLotCode.models.constants.VehicleType;

public interface SlotAllocationStrategy {
    ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate);
}
