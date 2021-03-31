package pl.jasiek.app.repository;

import pl.jasiek.app.model.Item;

import java.util.Collection;
import java.util.List;

public interface Repository {
    long create(Item item);
    int generateId();
    void remove(int id);
    Collection<Item> findAll();

    void init(List<Item> importData);
}
