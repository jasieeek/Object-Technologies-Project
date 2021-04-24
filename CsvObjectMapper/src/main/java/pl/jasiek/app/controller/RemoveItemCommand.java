package pl.jasiek.app.controller;

import pl.jasiek.app.repository.csv.ItemRepository;
import pl.jasiek.app.view.View;

public class RemoveItemCommand implements Command {
    private View view;
    private ItemRepository repository;

    public RemoveItemCommand(View view, ItemRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void run() {
        int id = view.readInt("Type ID of the item to remove");
        repository.remove(id);
//        System.out.println("The item with id " + id + " has been removed");
        view.logging("The item with id " + id + " has been removed!");
    }

    @Override
    public String getLabel() {
        return "Remove item";
    }
}
