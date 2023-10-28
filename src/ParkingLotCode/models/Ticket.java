package ParkingLotCode.models;

import ParkingLotCode.models.constants.TicketStatus;

import java.time.LocalDateTime;

public class Ticket extends BaseModel{
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private Gate gate;
    private TicketStatus ticketStatus;
}
