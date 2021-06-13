package pl.jasiek.app.model;

import lombok.Data;
import pl.jasiek.app.csv.annotation.CsvClass;
import pl.jasiek.app.csv.annotation.CsvID;
import pl.jasiek.app.csv.annotation.ManyToOne;

@Data
@CsvClass("src\\main\\resources\\repo\\student.csv")
public class Student {
    @CsvID
    private long id;
    private String name;
    private String surname;
    @ManyToOne("students")
    private long idGroup;
}
