package ParkingLotCode.models;

import java.time.LocalDateTime;

public class BaseModel {
    private int id;
    // auditing columns
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
