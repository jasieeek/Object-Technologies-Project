package pl.jasiek.app.controller;

import pl.jasiek.app.model.Item;
import pl.jasiek.app.model.ItemDetails;
import pl.jasiek.app.repository.Repository;
import pl.jasiek.app.view.View;

import java.util.ArrayList;
import java.util.List;

public class AddItemCommand implements Command {
    private View view;
    private Repository repository;
    private ItemDetails itemDetails;

    public AddItemCommand(View view, Repository repository) {
        this.view = view;
        this.repository = repository;
        this.itemDetails = ItemDetails.getInstance();
    }

    @Override
    public void execute() {
        Item item = new Item();
        item.setId(repository.generateId());
        item.setValues(readFields());
        repository.create(item);
    }

    @Override
    public String getLabel() {
        return "Add item";
    }

    private List<String> readFields() {
        List<String> fieldValues = new ArrayList<>();
        itemDetails.getFields().forEach((key, value) -> {
            String stringValue = view.readValueAsString(key, value);
            if (!stringValue.equals("")) {
                fieldValues.add(stringValue);
            } else {
                System.out.println("Nieprawidlowa wartosc fielda w modelu");
            }
        });
        return fieldValues;
    }
}
