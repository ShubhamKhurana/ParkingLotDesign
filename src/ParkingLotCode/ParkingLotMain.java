package ParkingLotCode;

import ParkingLotCode.exception.ParkingLotNotFoundException;
import ParkingLotCode.models.ParkingLot;
import ParkingLotCode.repository.GateRepository;
import ParkingLotCode.repository.ParkingFloorRepository;
import ParkingLotCode.repository.ParkingLotRepository;
import ParkingLotCode.repository.ParkingSlotRepository;
import ParkingLotCode.service.InitService;
import ParkingLotCode.service.InitServiceImpl;

public class ParkingLotMain {
    public static void main(String[] args) throws ParkingLotNotFoundException {
        // First create the Repository objects
        // (similar to setting up DBC connection first)

        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        GateRepository gateRepository = new GateRepository();

        InitService initService = new InitServiceImpl(parkingSlotRepository, parkingFloorRepository, parkingLotRepository, gateRepository);
        initService.init();

        ParkingLot parkingLot = parkingLotRepository.get(1);
    }
}
