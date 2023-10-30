package ParkingLotCode.DTO;

public class BillResponseDTO {
    private double amountToPay;

    public double getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    @Override
    public String toString() {
        return "BillResponseDTO{" +
                "amountToPay=" + amountToPay +
                '}';
    }
}
