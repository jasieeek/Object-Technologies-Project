package pl.jasiek.app.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Item {
    private int id;
    private List<String> values;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(id);
        result.append(" | ");
        values.forEach(value -> {
            result.append(value);
            result.append(" | ");
        });
        return result.toString();
    }

    public String toCsvString() {
        StringBuilder result = new StringBuilder();
        result.append(id).append(",");
        values.forEach(value -> result.append(value).append(","));
        return result.toString();
    }
}
