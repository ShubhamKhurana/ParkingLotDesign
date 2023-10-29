package ParkingLotCode.service.strategy.billCalculationStrategy;

import ParkingLotCode.models.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowBillCalculationStrategy implements BillCalculationStrategy{
    private static final int PER_HOUR_CHARGE_2_WHEELER = 50;
    private static final int PER_HOUR_CHARGE_4_WHEELER = 100;
    private static final double INCREMENT_FACTOR = 0.1;

    private int getCostPerHour(Ticket ticket){
        return switch (ticket.getVehicle().getVehicleType()){
            case CAR -> PER_HOUR_CHARGE_4_WHEELER;
            case BIKE -> PER_HOUR_CHARGE_2_WHEELER;
            default -> 0;
        };
    }
    public double calculateBillAmount(Ticket ticket, LocalDateTime exitTime){
        LocalDateTime entryTime = ticket.getEntryTime();

        // gives ceil (eg, 61 minutes will give 2 hours, so we'll charge for 2 hours)
        long totalHours = ChronoUnit.HOURS.between(exitTime, entryTime);
        int costPerHour = getCostPerHour(ticket);

        double baseCost = costPerHour*totalHours;

        return baseCost + baseCost * INCREMENT_FACTOR * (totalHours-1);
    }
}

/*
   nth hour = (50*n) + (50*n * INCREMENT_FACTOR * (Number_Of_Hours - 1))

   1st hour -> 50*1
   2nd hour -> 50*2 + 100*0.1*(2-1) = 100 + 10 = 110
   3rd hour -> 50*3 + 150*0.1*(3-1) = 150 + 30 = 180

*/
