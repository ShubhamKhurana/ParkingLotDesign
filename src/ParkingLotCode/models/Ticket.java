package ParkingLotCode.models;

import ParkingLotCode.models.constants.TicketStatus;

import java.time.LocalDateTime;

public class Ticket extends BaseModel{
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private Gate gate;
    private TicketStatus ticketStatus;

    private static int ticketCounter = 1;

    public Ticket(){
        super(ticketCounter++);
    }

    public Ticket(LocalDateTime entryTime, Vehicle vehicle, ParkingSlot parkingSlot, Gate gate, TicketStatus ticketStatus) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.gate = gate;
        this.ticketStatus = ticketStatus;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
