package pl.jasiek.app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class Item {
    private int id;
    private Map<String, String> fields;

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
