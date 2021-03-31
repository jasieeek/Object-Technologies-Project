package pl.jasiek.app.model.vehicle;

import lombok.Getter;
import lombok.Setter;
import pl.jasiek.app.model.vehicle.additions.DrivingMode;
import pl.jasiek.app.model.vehicle.additions.MotorcycleType;

@Getter
@Setter
public class Motorcycle extends Vehicle {
    private MotorcycleType type;
    private DrivingMode drivingMode;

    public Motorcycle(MotorcycleType type, DrivingMode drivingMode) {
        this.type = type;
        this.drivingMode = drivingMode;
    }
}
