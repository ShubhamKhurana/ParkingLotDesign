package ParkingLotCode.models;

import ParkingLotCode.models.constants.ParkingSlotStatus;
import ParkingLotCode.models.constants.VehicleType;

public class ParkingSlot extends BaseModel{
    private int number;
    private VehicleType vehicleType;
    private ParkingSlotStatus parkingSlotStatus;
    private Vehicle vehicle;

    public ParkingSlot(){

    }

    public ParkingSlot(int number, VehicleType vehicleType, ParkingSlotStatus parkingSlotStatus, Vehicle vehicle) {
        this.number = number;
        this.vehicleType = vehicleType;
        this.parkingSlotStatus = parkingSlotStatus;
        this.vehicle = vehicle;
    }

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
