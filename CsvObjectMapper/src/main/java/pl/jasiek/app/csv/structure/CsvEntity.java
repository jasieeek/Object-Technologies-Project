package pl.jasiek.app.csv.structure;

import lombok.Data;

import java.util.List;

@Data
public class CsvEntity {
    private String name;
    private List<CsvField> fields;
}
