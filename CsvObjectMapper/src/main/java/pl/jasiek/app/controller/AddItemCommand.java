package pl.jasiek.app.controller;

import pl.jasiek.app.model.Item;
import pl.jasiek.app.model.ItemDetails;
import pl.jasiek.app.repository.Repository;
import pl.jasiek.app.view.View;

import java.util.Map;
import java.util.TreeMap;


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
        // wyswietl data model
        Item item = new Item();
        item.setId(repository.generateId());
        item.setFields(readFields());
        repository.create(item);
    }

    @Override
    public String getLabel() {
        return "Add item";
    }

    private Map<String, String> readFields() {
        Map<String, String> fields = new TreeMap<>();
        itemDetails.getFields().forEach((key, value) -> {
            String stringValue = view.readFieldValueAsString(key, value, false);
            if (!stringValue.equals("")) {
                fields.put(key, stringValue);
            } else {
                System.out.println("Incorrect field value in model! Please contact administrator!");
            }
        });
        return fields;
    }
}
