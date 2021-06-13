package pl.jasiek.app.csv.structure;

import lombok.Data;

import java.util.List;

@Data
public class CsvEntry {
    private List<CsvField> fields;
}
