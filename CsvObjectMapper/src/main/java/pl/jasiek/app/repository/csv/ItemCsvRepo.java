package pl.jasiek.app.repository.csv;

import pl.jasiek.app.model.Item;
import pl.jasiek.app.repository.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemCsvRepo implements Repository {
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
    public int generateId() {
        if (itemList.size() == 0) {
            return 0;
        } else {
            return itemList.get(itemList.size()-1).getId() + 1;
        }
    }

    @Override
    public void remove(int id) {
        itemList.remove(id);
    }

    @Override
    public Collection<Item> findAll() {
        return itemList;
    }
}