package pl.jasiek.app.controller;

import pl.jasiek.app.model.ItemDetails;

public class ShowDataModelCommand implements Command {
    private ItemDetails itemDetails;

    public ShowDataModelCommand() {
        itemDetails = ItemDetails.getInstance();
    }

    @Override
    public void execute() {
        System.out.println("----------Data model----------\n");
        System.out.println("Model name: " + itemDetails.getName());
        System.out.println("\nModel fields: ");
        itemDetails.getFields().entrySet()
                .forEach(System.out::println);
        System.out.println("\n----------End----------\n");
    }

    @Override
    public String getLabel() {
        return "Show data model";
    }
}
