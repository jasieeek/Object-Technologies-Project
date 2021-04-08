package pl.jasiek.app.controller;

import pl.jasiek.app.model.ItemDetails;
import pl.jasiek.app.repository.ItemRepository;

public class ShowItemsCommand implements Command {
    private ItemRepository itemRepository;
    private ItemDetails itemDetails;

    public ShowItemsCommand(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.itemDetails = ItemDetails.getInstance();
    }

    @Override
    public void execute() {
        printDataModelRow();
        itemRepository.findAll().forEach(System.out::println);
        System.out.println("\n--------------------End--------------------\n");
    }

    @Override
    public String getLabel() {
        return "Show items";
    }

    private void printDataModelRow() {
        StringBuilder result = new StringBuilder();
        final String dashes = "--------------------";
        result.append("\n");
        result.append(dashes);
        result.append(itemDetails.getName());
        result.append(" Repository");
        result.append(dashes);
        result.append("\n\n");
        result.append("| ");
        result.append("ID | ");
        itemDetails.getFields().forEach((key, value) -> {
            result.append(key);
            result.append(" | ");
        });
        result.append("\n");
        System.out.println(result.toString());
    }
}
