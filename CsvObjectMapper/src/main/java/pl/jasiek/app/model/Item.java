package pl.jasiek.app.model;

import lombok.Data;

import java.util.Map;

@Data
public class Item {
    private Map<String, String> values;
}
