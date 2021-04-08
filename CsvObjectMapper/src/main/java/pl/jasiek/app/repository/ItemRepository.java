package pl.jasiek.app.repository;

import pl.jasiek.app.model.Item;

import java.util.List;
import java.util.Map;

public interface ItemRepository {
    long create(Item item);
    int generateId();
    void remove(int id);
    void modifyById(int id, Map<String, String> modifiedFields);
    Item findById(int id);
    List<Item> findAll();

    void init(List<Item> importData);
}