package pl.jasiek.app.controller;

import pl.jasiek.app.model.Item;
import pl.jasiek.app.repository.Repository;
import pl.jasiek.app.view.View;

public class AddItemCommand implements Command {
    private View view;
    private Repository repository;

    public AddItemCommand(View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void execute() {
        Item item = new Item();

        repository.create(item);
    }

    @Override
    public String getLabel() {
        return "Add item";
    }

//    private Vehicle createVehicle(VehicleType type) {
//        return new Car();
//    }
}
