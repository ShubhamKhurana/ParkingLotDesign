package ParkingLotCode.DTO;

import ParkingLotCode.models.Vehicle;
import ParkingLotCode.models.constants.VehicleType;

// DTO should have attributes only, no objects
// If you have to send objects, then also add attributes of those objects in the DTO
public class TicketRequestDTO {
    private int parkingLotId;
    private int gateId;
    private String name;
    private String number;
    private String color;
    private VehicleType vehicleType;

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
