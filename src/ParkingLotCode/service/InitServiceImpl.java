package ParkingLotCode.service;

import ParkingLotCode.models.Gate;
import ParkingLotCode.models.ParkingFloor;
import ParkingLotCode.models.ParkingLot;
import ParkingLotCode.models.ParkingSlot;
import ParkingLotCode.models.constants.*;
import ParkingLotCode.repository.GateRepository;
import ParkingLotCode.repository.ParkingFloorRepository;
import ParkingLotCode.repository.ParkingLotRepository;
import ParkingLotCode.repository.ParkingSlotRepository;
import ParkingLotCode.service.InitService;
import ParkingLotCode.service.strategy.billCalculationStrategy.BillCalculationStrategy;
import ParkingLotCode.service.strategy.billCalculationStrategy.BillCalculationStrategyFactory;
import ParkingLotCode.service.strategy.billCalculationStrategy.BillCalculationStrategyType;
import ParkingLotCode.service.strategy.slotAllocationStrategy.SlotAllocationStrategy;
import ParkingLotCode.service.strategy.slotAllocationStrategy.SlotAllocationStrategyFactory;
import ParkingLotCode.service.strategy.slotAllocationStrategy.SlotAllocationStrategyType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitServiceImpl implements InitService {
    private ParkingSlotRepository parkingSlotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;

    public InitServiceImpl(ParkingSlotRepository parkingSlotRepository, ParkingFloorRepository parkingFloorRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
    }

    public void init(){
        ParkingLot parkingLot = new ParkingLot();

        parkingLot.setId(1);
        parkingLot.setName("Parking Lot 1");
        parkingLot.setAddress("Street A, CityB, State C");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setAllowedVehicleTypes(new ArrayList<>(Arrays.asList(VehicleType.BIKE, VehicleType.CAR)));

        // Set strategies
        parkingLot.setSlotAllocationStrategy(SlotAllocationStrategyFactory.getSlotAllocationStrategy(SlotAllocationStrategyType.NEAREST));
        parkingLot.setBillCalculationStrategy(BillCalculationStrategyFactory.getBillCalculationStrategy(BillCalculationStrategyType.HIGH));

        List<ParkingFloor> parkingFloors = new ArrayList<>();

        for(int i=0;i<10;i++){
            ParkingFloor floor = new ParkingFloor();
            floor.setId(i);
            floor.setFloorNumber(i);

            List<ParkingSlot> parkingSlots = new ArrayList<>();
            for(int j=1;j<=10;j++){
                ParkingSlot slot = new ParkingSlot();
                slot.setId(i*100 + j);
                slot.setNumber(i*100 + j);
                if(j%2 == 0) slot.setVehicleType(VehicleType.CAR);
                else slot.setVehicleType(VehicleType.BIKE);
                slot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);

                parkingSlots.add(slot);

                // add to repository when slot is created
                parkingSlotRepository.put(slot);
            }

            floor.setParkingSlotList(parkingSlots);
            floor.setParkingFloorStatus(ParkingFloorStatus.OPEN);

            Gate entryGate = new Gate();
            entryGate.setId(i*10 + 1);
            entryGate.setGateNumber(i*10 + 1);
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setOperator("Rahul");
            entryGate.setParkingLotId(1);
            entryGate.setFloorNumber(i);

            gateRepository.put(entryGate);

            Gate exitGate = new Gate();
            exitGate.setId(i*10 + 2);
            exitGate.setGateNumber(i*10 + 2);
            exitGate.setGateStatus(GateStatus.OPEN);
            exitGate.setGateType(GateType.EXIT);
            exitGate.setOperator("Raj");
            exitGate.setParkingLotId(1);
            exitGate.setFloorNumber(i);

            gateRepository.put(exitGate);

            List<Gate> gates = new ArrayList<>();
            gates.add(entryGate);
            gates.add(exitGate);

            floor.setGates(gates);

            parkingFloors.add(floor);

            parkingFloorRepository.put(floor);
        }

        parkingLot.setParkingFloorList(parkingFloors);
        parkingLotRepository.put(parkingLot);
    }
}
