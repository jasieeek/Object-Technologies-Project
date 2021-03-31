package pl.jasiek.app.model.vehicle;

import lombok.Data;
import pl.jasiek.app.model.vehicle.additions.CarType;
import pl.jasiek.app.model.vehicle.additions.FuelType;
import pl.jasiek.app.model.vehicle.additions.TransmissionType;

@Data
public class Car extends Vehicle {
    private FuelType fuelType;
    private CarType type;
    private TransmissionType transmission;
}
