package pl.jasiek.app.controller;

import pl.jasiek.app.model.ItemDetails;
import pl.jasiek.app.repository.Repository;
import pl.jasiek.app.view.View;

public class ShowItemsCommand implements Command {
    private View view;
    private Repository itemRepository;
    private ItemDetails itemDetails;

    public ShowItemsCommand(View view, Repository itemRepository) {
        this.view = view;
        this.itemRepository = itemRepository;
        this.itemDetails = ItemDetails.getInstance();
    }

    @Override
    public void execute() {
        printDataModelRow();
        itemRepository.findAll().forEach(System.out::println);
        System.out.println();
    }

    @Override
    public String getLabel() {
        return "Show items";
    }

    private void printDataModelRow() {
        StringBuilder result = new StringBuilder();
        final String dashes = "----------";
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
