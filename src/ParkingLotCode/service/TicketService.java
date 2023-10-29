package ParkingLotCode.service;

import ParkingLotCode.exception.GateNotFoundException;
import ParkingLotCode.exception.ParkingLotNotFoundException;
import ParkingLotCode.exception.TicketNotFoundException;
import ParkingLotCode.models.Ticket;
import ParkingLotCode.models.Vehicle;

import java.time.LocalDateTime;

public interface TicketService {
    Ticket createTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws ParkingLotNotFoundException, GateNotFoundException, TicketNotFoundException;
}
