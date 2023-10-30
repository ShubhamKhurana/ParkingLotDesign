package ParkingLotCode.controller;

import ParkingLotCode.DTO.BillRequestDTO;
import ParkingLotCode.DTO.BillResponseDTO;
import ParkingLotCode.exception.ParkingLotNotFoundException;
import ParkingLotCode.models.*;
import ParkingLotCode.repository.ParkingLotRepository;
import ParkingLotCode.service.BillService;
import ParkingLotCode.service.BillServiceImpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BillController {
    private BillService billService;
    public BillController(ParkingLotRepository parkingLotRepository){
        this.billService = new BillServiceImpl(parkingLotRepository);
    }

    public BillResponseDTO generateBill(BillRequestDTO billRequestDTO) throws ParkingLotNotFoundException {
        Vehicle vehicle = new Vehicle(billRequestDTO.getNumber(), billRequestDTO.getName(), billRequestDTO.getColor(), billRequestDTO.getVehicleType());
        ParkingSlot parkingSlot = new ParkingSlot(billRequestDTO.getParkingSlotNumber(), billRequestDTO.getVehicleType(), billRequestDTO.getParkingSlotStatus(), vehicle);
        Gate gate = new Gate(billRequestDTO.getOperator(), billRequestDTO.getGateType(), billRequestDTO.getFloorNumber(), billRequestDTO.getParkingLotId(), billRequestDTO.getGateStatus(), billRequestDTO.getGateNumber());

        Ticket ticket = new Ticket(billRequestDTO.getEntryTime(), vehicle, parkingSlot, gate, billRequestDTO.getTicketStatus());
        LocalDateTime exitTime = LocalDateTime.now().plus(2, ChronoUnit.HOURS);

        Bill bill = billService.generateBill(ticket, exitTime);

        BillResponseDTO billResponseDTO = new BillResponseDTO();
        billResponseDTO.setAmountToPay(bill.getAmount());

        return billResponseDTO;
    }
}