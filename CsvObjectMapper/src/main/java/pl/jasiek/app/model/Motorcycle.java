package pl.jasiek.app.model;

import lombok.Data;
import pl.jasiek.app.model.additions.DrivingMode;
import pl.jasiek.app.model.additions.MotorcycleType;

@Data
public class Motorcycle extends Vehicle {
    private MotorcycleType type;
    private DrivingMode drivingMode;
}
