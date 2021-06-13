package pl.jasiek.app.model;

import lombok.Data;
import pl.jasiek.app.csv.annotation.CsvClass;
import pl.jasiek.app.csv.annotation.CsvID;

@Data
@CsvClass("src\\main\\resources\\repo\\teacher.csv")
public class Teacher {
    @CsvID
    private long id;
    private String name;
    private String surname;
}
