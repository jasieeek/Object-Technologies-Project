package pl.jasiek.app.model;

public class Car extends Vehicle {
    private String fuelType;
//    zamienic na enum/interface
    private String body;
    private String transmission;

    public enum DrivingMode {
        SHAFT_DRIVE, CHAIN_DRIVE, BELT_DRIVE
    }
}
