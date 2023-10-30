package ParkingLotCode;

import ParkingLotCode.DTO.BillRequestDTO;
import ParkingLotCode.DTO.BillResponseDTO;
import ParkingLotCode.DTO.TicketRequestDTO;
import ParkingLotCode.DTO.TicketResponseDTO;
import ParkingLotCode.controller.BillController;
import ParkingLotCode.controller.TicketController;
import ParkingLotCode.exception.GateNotFoundException;
import ParkingLotCode.exception.ParkingLotNotFoundException;
import ParkingLotCode.exception.TicketNotFoundException;
import ParkingLotCode.models.constants.*;
import ParkingLotCode.repository.*;
import ParkingLotCode.service.InitService;
import ParkingLotCode.service.InitServiceImpl;

public class ParkingLotMain {
    public static void main(String[] args) throws ParkingLotNotFoundException, TicketNotFoundException, GateNotFoundException {
        // First create the Repository objects
        // (similar to setting up DBC connection first)

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitService initService = new InitServiceImpl(parkingSlotRepository, parkingFloorRepository, parkingLotRepository, gateRepository);
        initService.init();

        TicketController ticketController = new TicketController(parkingLotRepository, gateRepository, ticketRepository);

        TicketRequestDTO ticketRequestDTO = new TicketRequestDTO();
        ticketRequestDTO.setParkingLotId(1);
        ticketRequestDTO.setGateId(31);
        ticketRequestDTO.setName("Mercedes");
        ticketRequestDTO.setColor("Blue");
        ticketRequestDTO.setVehicleType(VehicleType.CAR);
        ticketRequestDTO.setNumber("12345");

        TicketResponseDTO ticketResponseDTO = ticketController.createTicket(ticketRequestDTO);
        System.out.println(ticketResponseDTO.toString());


        BillController billController = new BillController(parkingLotRepository);

        BillRequestDTO billRequestDTO = new BillRequestDTO();
        billRequestDTO.setParkingLotId(1);
        billRequestDTO.setGateId(52);
        billRequestDTO.setGateNumber(52);
        billRequestDTO.setGateStatus(GateStatus.OPEN);
        billRequestDTO.setName("Mercedes");
        billRequestDTO.setColor("Blue");
        billRequestDTO.setVehicleType(VehicleType.CAR);
        billRequestDTO.setNumber("12345");
        billRequestDTO.setParkingSlotNumber(ticketResponseDTO.getSlotNumber());
        billRequestDTO.setEntryTime(ticketResponseDTO.getEntryTime());

        BillResponseDTO billResponseDTO = billController.generateBill(billRequestDTO);
        System.out.println(billResponseDTO.toString());

//        ParkingLot parkingLot = parkingLotRepository.get(1);
    }
}
