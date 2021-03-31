package pl.jasiek.app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ItemDetails {
    private String name;
    private Map<String, String> fields;

    private static ItemDetails instance = new ItemDetails();

    public static ItemDetails getInstance() {
        return instance;
    }
}
