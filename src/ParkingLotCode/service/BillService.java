package ParkingLotCode.service;

import ParkingLotCode.exception.ParkingLotNotFoundException;
import ParkingLotCode.models.Bill;
import ParkingLotCode.models.Ticket;

import java.time.LocalDateTime;

public interface BillService {
    Bill generateBill(Ticket ticket, LocalDateTime exitTime) throws ParkingLotNotFoundException;
}
