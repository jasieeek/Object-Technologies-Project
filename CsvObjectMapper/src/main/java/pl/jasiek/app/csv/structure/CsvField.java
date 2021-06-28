package pl.jasiek.app.csv.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CsvField {
    private String name;
    private String value;
    private boolean isPrimaryKey;
    private boolean isForeignKey;

    public CsvField(String name) {
        this.name = name;
    }

    public String toShortString() {
        return name + " = " + value;
    }

    public String relatedFieldToString() {
        return "\t" + name + " = " + value;
    }
}
