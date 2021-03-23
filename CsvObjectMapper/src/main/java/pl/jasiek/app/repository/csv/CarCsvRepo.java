package pl.jasiek.app.repository.csv;

import pl.jasiek.app.model.Car;
import pl.jasiek.app.repository.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarCsvRepo implements Repository {
    private List<Car> carList = new ArrayList<>();
    @Override
    public long create(Car car) {
        return 0;
    }

    @Override
    public Collection<Car> findAll() {
        return null;
    }
}
