package pl.jasiek.app.repository;

import pl.jasiek.app.model.Item;

import java.util.List;

public interface Repository {
    long create(Item item);
    int generateId();
    void remove(int id);
    List<Item> findAll();

    void init(List<Item> importData);
}
