package pl.jasiek.app.model;

import lombok.Data;

import java.time.Year;

@Data
public abstract class Vehicle {
    private long id;
    //    zamienic na enum/interface
    private String make;
    private String model;
    private Year firstRegistration;
    private Double value;
    private String color;
}
