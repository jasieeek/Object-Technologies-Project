package pl.jasiek.app.model;

import lombok.Data;
import pl.jasiek.app.csv.annotation.CsvClass;
import pl.jasiek.app.csv.annotation.CsvID;
import pl.jasiek.app.csv.annotation.ManyToMany;

@Data
@CsvClass("src\\main\\resources\\repo\\additionalactivity.csv")
public class AdditionalActivity {
    @CsvID
    private long id;
    private String name;
    private String place;
    @ManyToMany(relationshipCsvClass = "pl.jasiek.app.model.Student", intermediateTable = "additionalactivity_student")
    private boolean value;
}
