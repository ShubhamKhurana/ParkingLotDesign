package ParkingLotCode.models;

import ParkingLotCode.models.constants.ParkingSlotStatus;
import ParkingLotCode.models.constants.VehicleType;

public class ParkingSlot extends BaseModel{
    private int number;
    private VehicleType vehicleType;
    private ParkingSlotStatus parkingSlotStatus;
    private Vehicle vehicle;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
