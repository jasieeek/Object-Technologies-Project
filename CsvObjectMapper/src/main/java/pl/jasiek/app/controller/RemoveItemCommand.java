package pl.jasiek.app.controller;

import pl.jasiek.app.repository.Repository;
import pl.jasiek.app.view.View;

public class RemoveItemCommand implements Command {
    private View view;
    private Repository repository;

    public RemoveItemCommand(View view, Repository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void execute() {
        int id = view.readInt("Type ID of the item to remove");
        repository.remove(id);
        System.out.println("The item with id " + id + " has been removed");
        getIDsRight(id);
    }

    @Override
    public String getLabel() {
        return "Remove item";
    }

    private void getIDsRight(int removedItemID) {
        repository.findAll().stream()
                .filter(item -> item.getId() > removedItemID)
                .forEach(item -> {
                    int currentID = item.getId();
                    item.setId(--currentID);
                });
    }
}
