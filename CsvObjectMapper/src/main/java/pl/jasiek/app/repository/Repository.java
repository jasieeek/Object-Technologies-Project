package pl.jasiek.app.repository;

import pl.jasiek.app.model.Vehicle;

import java.util.Collection;

public interface Repository {
    long create(Vehicle vehicle);
    Collection<Vehicle> findAll();
}
