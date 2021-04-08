package pl.jasiek.app.repository.csv;

import pl.jasiek.app.model.Item;
import pl.jasiek.app.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemRepo implements ItemRepository {
    private List<Item> itemList = new ArrayList<>();

    @Override
    public long create(Item item) {
        itemList.add(item);
        return 0;
    }

    @Override
    public void init(List<Item> importData) {
        itemList.addAll(importData);
    }

    @Override
    public void modifyById(int id, Map<String, String> modifiedFields) {
        Item modifiedItem = itemList.get(id);
        modifiedItem.setFields(modifiedFields);
    }

    @Override
    public Item findById(int id) {
        return itemList.get(id);
    }

    @Override
    public int generateId() {
        if (itemList.size() == 0) {
            return 0;
        } else {
            return itemList.get(itemList.size() - 1).getId() + 1;
        }
    }

    @Override
    public void remove(int id) {
        itemList.remove(id);
    }

    @Override
    public List<Item> findAll() {
        return itemList;
    }
}
