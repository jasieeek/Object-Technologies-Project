package pl.jasiek.app.model;

import java.util.Map;

public class ItemDetails {
    private String name;
    private Map<String, String> fields;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    private static ItemDetails instance = new ItemDetails();

    public static ItemDetails getInstance() {
        return instance;
    }
}
