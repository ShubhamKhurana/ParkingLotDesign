package ParkingLotCode.models;

import ParkingLotCode.models.constants.GateStatus;
import ParkingLotCode.models.constants.GateType;

public class Gate extends BaseModel{
    private String operator;
    private GateType gateType;
    private int floorNumber;
    private int parkingLotId;
    private GateStatus gateStatus;
    private int gateNumber;

    public Gate(){

    }

    public Gate(String operator, GateType gateType, int floorNumber, int parkingLotId, GateStatus gateStatus, int gateNumber) {
        this.operator = operator;
        this.gateType = gateType;
        this.floorNumber = floorNumber;
        this.parkingLotId = parkingLotId;
        this.gateStatus = gateStatus;
        this.gateNumber = gateNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }
}
