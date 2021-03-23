package pl.jasiek.app.model;

import java.time.Year;

public abstract class Vehicle {
    private long id;
    //    zamienic na enum/interface
    private String make;
    private String model;
    private Year FirstRegistration;
    private String value;
    private String color;
}
