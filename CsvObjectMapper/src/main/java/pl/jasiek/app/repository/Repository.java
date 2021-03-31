package pl.jasiek.app.repository;

import pl.jasiek.app.model.Item;

import java.util.Collection;

public interface Repository {
    long create(Item item);
    Collection<Item> findAll();
}
