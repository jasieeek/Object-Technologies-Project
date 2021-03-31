package pl.jasiek.app.repository.csv;

import pl.jasiek.app.model.Item;
import pl.jasiek.app.repository.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemCsvRepo implements Repository {
    private List<Item> itemBoxList = new ArrayList<>();
    @Override
    public long create(Item item) {
        itemBoxList.add(item);
        return 0;
    }

    @Override
    public Collection<Item> findAll() {
        return itemBoxList;
    }
}
