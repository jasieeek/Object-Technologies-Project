package pl.jasiek.app.model;

import lombok.Getter;

@Getter
public class ItemBox<T> {
    private T item;

    public ItemBox(T item) {
        this.item = item;
    }
}
