package pl.jasiek.app.controller;

import pl.jasiek.app.view.View;

public class RemoveItemCommand implements Command {
    private View view;

    public RemoveItemCommand(View view) {
        this.view = view;
    }

    public void run() {
        int id = view.readInt("Type ID of the item to remove");
//        System.out.println("The item with id " + id + " has been removed");
        view.logging("The item with id " + id + " has been removed!");
    }

    @Override
    public String getLabel() {
        return "Remove item";
    }
}
