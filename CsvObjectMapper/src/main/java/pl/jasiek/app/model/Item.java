package pl.jasiek.app.model;

import java.util.Map;


public class Item {
    private int id;
    private Map<String, String> fields;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(id);
        result.append(" | ");
        fields.values().forEach((value) -> result.append(value).append(" | "));
        return result.toString().trim();
    }

    public String toCsvString() {
        StringBuilder result = new StringBuilder();
        result.append(id).append(",");
        fields.values().forEach((value) -> result.append(value).append(","));
        return result.toString();
    }
}
