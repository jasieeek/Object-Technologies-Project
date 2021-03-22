package pl.jasiek.app.repository;

import pl.jasiek.app.model.Car;

import java.util.Collection;

public interface Repository {
    long create(Car car);
    Collection<Car> findAll();
}
