package pl.jasiek.app.model;

import lombok.Data;
import pl.jasiek.app.model.additions.CarType;
import pl.jasiek.app.model.additions.TransmissionType;

@Data
public class Car extends Vehicle {
    private String fuelType;
    private CarType type;
    private TransmissionType transmission;
}
