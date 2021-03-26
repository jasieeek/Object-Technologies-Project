package pl.jasiek.app.repository.csv;

import pl.jasiek.app.model.Vehicle;
import pl.jasiek.app.repository.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VehicleCsvRepo implements Repository {
    private List<Vehicle> carList = new ArrayList<>();
    @Override
    public long create(Vehicle vehicle) {
        carList.add(vehicle);
        return 0;
    }

    @Override
    public Collection<Vehicle> findAll() {
        return carList;
    }
}
