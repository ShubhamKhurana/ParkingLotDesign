package ParkingLotCode.service.strategy.slotAllocationStrategy;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getSlotAllocationStrategy(SlotAllocationStrategyType slotAllocationStrategyType){
        return switch (slotAllocationStrategyType){
            case NEAREST -> new NearestSlotAllocationStrategy();
        };
    }
}
