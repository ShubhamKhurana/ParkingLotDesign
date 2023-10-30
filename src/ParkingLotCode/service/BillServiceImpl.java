package ParkingLotCode.service;

import ParkingLotCode.exception.ParkingLotNotFoundException;
import ParkingLotCode.models.*;
import ParkingLotCode.repository.ParkingLotRepository;

import java.time.LocalDateTime;

public class BillServiceImpl implements BillService{
    private ParkingLotRepository parkingLotRepository;

    public BillServiceImpl(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }

    public Bill generateBill(Ticket ticket, LocalDateTime exitTime) throws ParkingLotNotFoundException {

        // Need to populate parkingLot, because this is containing strategy
        ParkingLot parkingLot = parkingLotRepository.get(ticket.getGate().getParkingLotId());

        double amountToPay = parkingLot.getBillCalculationStrategy().calculateBillAmount(ticket, exitTime);

        Bill bill = new Bill();
        bill.setExitTime(exitTime);
        bill.setAmount(amountToPay);
        bill.setTicket(ticket);

        return bill;
    }
}
