package pl.jasiek.app.model;

import lombok.Data;
import lombok.Setter;
import pl.jasiek.app.csv.annotation.CsvClass;
import pl.jasiek.app.csv.annotation.CsvID;
import pl.jasiek.app.csv.annotation.ManyToOne;

@Data
@CsvClass("src\\main\\resources\\repo\\group.csv")
public class Group {
    @CsvID
    private long id;
    private String name;
    @Setter
    @ManyToOne("groups")
    private long idTeacher;
}
