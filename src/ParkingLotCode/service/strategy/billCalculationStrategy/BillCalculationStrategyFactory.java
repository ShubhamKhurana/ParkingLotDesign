package ParkingLotCode.service.strategy.billCalculationStrategy;

// whenever we create Strategy, we need to create Factory
public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getBillCalculationStrategy(BillCalculationStrategyType billCalculationStrategyType){
        return switch(billCalculationStrategyType){
            case LOW -> new LowBillCalculationStrategy();
            case HIGH -> new HighBillCalculationStrategy();
        };
    }
}
