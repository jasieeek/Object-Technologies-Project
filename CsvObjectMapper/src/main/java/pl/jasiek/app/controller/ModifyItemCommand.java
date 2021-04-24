package pl.jasiek.app.controller;

import pl.jasiek.app.model.Item;
import pl.jasiek.app.model.ItemDetails;
import pl.jasiek.app.repository.csv.ItemRepository;
import pl.jasiek.app.view.View;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModifyItemCommand implements Command {
    private View view;
    private ItemRepository repository;
    private ItemDetails itemDetails;

    public ModifyItemCommand(View view, ItemRepository repository) {
        this.view = view;
        this.repository = repository;
        this.itemDetails = ItemDetails.getInstance();
    }

    @Override
    public void run() {
        int id = view.readInt("Type ID of the item to modify");
        showMessage(id);
        repository.modifyById(id, readFields(id));
    }

    private void showMessage(int id) {
        Item item = repository.findById(id);
        System.out.println("Item ID: " + id);
        System.out.println("Current values:");
        item.getFields().forEach((name, value) -> {
            System.out.println(name + ": " + value);
        });
        System.out.println("\nINFO! EMPTY VALUE = OLD VALUE\n");
    }

    @Override
    public String getLabel() {
        return "Modify item";
    }

    private Map<String, String> readFields(int id) {
        Map<String, String> fields = new LinkedHashMap<>();
        Item item = repository.findById(id);
        itemDetails.getFields().forEach((key, value) -> {
            String stringValue = view.readFieldValueAsString("NEW " + key, value, true);
            if (stringValue.equals("")) {
                System.out.println("Wrong field type in data model! Please contact a administrator!");
            } else if (stringValue.equals("0")) {
                System.out.println(key + " field hasn't been changed!");
                fields.put(key, item.getFields().get(key));
            } else {
                fields.put(key, stringValue);
            }
        });
        return fields;
    }
}
