package ParkingLotCode.DTO;

import ParkingLotCode.models.Vehicle;

import java.time.LocalDateTime;

public class TicketResponseDTO {
    private LocalDateTime entryTime;
    private String vehicleNumber;
    private int slotNumber; // User can know everything about slot from slotNumber

    @Override
    public String toString() {
        return "TicketResponseDTO{" +
                "entryTime='" + entryTime.toString() + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", slotNumber=" + slotNumber +
                '}';
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }
}
