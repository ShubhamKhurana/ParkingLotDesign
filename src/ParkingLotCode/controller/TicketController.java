package ParkingLotCode.controller;

import ParkingLotCode.DTO.TicketRequestDTO;
import ParkingLotCode.DTO.TicketResponseDTO;
import ParkingLotCode.exception.GateNotFoundException;
import ParkingLotCode.exception.ParkingLotNotFoundException;
import ParkingLotCode.exception.TicketNotFoundException;
import ParkingLotCode.models.Ticket;
import ParkingLotCode.models.Vehicle;
import ParkingLotCode.repository.GateRepository;
import ParkingLotCode.repository.ParkingLotRepository;
import ParkingLotCode.repository.TicketRepository;
import ParkingLotCode.service.TicketService;
import ParkingLotCode.service.TicketServiceImpl;

import java.time.LocalDateTime;

public class TicketController {
    private TicketService ticketService;

    public TicketController(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository){
        this.ticketService = new TicketServiceImpl(parkingLotRepository, gateRepository, ticketRepository);
    }

    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) throws TicketNotFoundException, ParkingLotNotFoundException, GateNotFoundException {
        Vehicle vehicle = new Vehicle(ticketRequestDTO.getNumber(), ticketRequestDTO.getName(), ticketRequestDTO.getColor(), ticketRequestDTO.getVehicleType());
        Ticket ticket = ticketService.createTicket(vehicle, ticketRequestDTO.getGateId(), ticketRequestDTO.getParkingLotId(), LocalDateTime.now());

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
        ticketResponseDTO.setEntryTime(ticket.getEntryTime().toString());
        ticketResponseDTO.setVehicleNumber(ticket.getVehicle().getNumber());
        ticketResponseDTO.setSlotNumber(ticket.getParkingSlot().getNumber());

        return ticketResponseDTO;
    }
}
