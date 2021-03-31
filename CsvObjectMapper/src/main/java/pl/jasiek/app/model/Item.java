package pl.jasiek.app.model;

import lombok.Data;

import java.util.List;

@Data
public class Item {
    private int id;
    private List<String> values;

    public String toCsvString() {
        StringBuilder result = new StringBuilder();
        result.append(id).append(",");
        values.forEach(value -> result.append(value).append(","));
        return result.toString();
    }
}
