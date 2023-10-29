package ParkingLotCode.service.strategy.billCalculationStrategy;

import ParkingLotCode.models.Ticket;

import java.time.LocalDateTime;

public interface BillCalculationStrategy {
    public double calculateBillAmount(Ticket ticket, LocalDateTime exitTime);
}
