package ParkingLotCode.service;

import ParkingLotCode.exception.GateNotFoundException;
import ParkingLotCode.exception.ParkingLotNotFoundException;
import ParkingLotCode.exception.TicketNotFoundException;
import ParkingLotCode.models.*;
import ParkingLotCode.repository.GateRepository;
import ParkingLotCode.repository.ParkingLotRepository;
import ParkingLotCode.repository.TicketRepository;

import java.time.LocalDateTime;

public class TicketServiceImpl implements TicketService{
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;

    public TicketServiceImpl(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository){
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws ParkingLotNotFoundException, GateNotFoundException, TicketNotFoundException {
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);
        Gate gate = gateRepository.get(gateId);

        ParkingSlot assignedParkingSlot = parkingLot.getSlotAllocationStrategy().findParkingSlot(vehicle.getVehicleType(), parkingLot, gate);

        Ticket ticket = new Ticket();
        ticket.setEntryTime(entryTime);
        ticket.setVehicle(vehicle);
        ticket.setParkingSlot(assignedParkingSlot);

        ticketRepository.put(ticket);

        return ticket;
    }
}
