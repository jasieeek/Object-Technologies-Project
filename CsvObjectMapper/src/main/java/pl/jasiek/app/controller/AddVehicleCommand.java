package pl.jasiek.app.controller;

import pl.jasiek.app.model.Car;
import pl.jasiek.app.model.Motorcycle;
import pl.jasiek.app.model.Vehicle;
import pl.jasiek.app.model.additions.VehicleType;
import pl.jasiek.app.repository.Repository;
import pl.jasiek.app.view.View;

public class AddVehicleCommand implements Command {
    private View view;
    private Repository repository;

    public AddVehicleCommand(View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getLabel() {
        return "Add vehicle";
    }

    private Vehicle createVehicle(VehicleType type) {
        Vehicle vehicle;
        switch (type) {
            case CAR:
                vehicle = new Car();
                vehicle.setMake(view.readString("Make"));
                vehicle.setModel(view.readString("Model"));
                vehicle.setFirstRegistration(view.readDate("First registration"));
                vehicle.setValue(view.readDouble("Value"));
                vehicle.setColor(view.readString("Color"));
                return vehicle;
            case MOTORCYCLE:
                // todo
                vehicle = new Motorcycle();
                return vehicle;
            default:
                // mozna zapisac to do logow aspektami
                System.out.println("Wprowadzono zły typ!");
                return null;
        }
    }
}
