package pl.jasiek.app.repository;

import pl.jasiek.app.csv.repo.CsvBaseRepo;

public class CsvStudentRepository extends CsvBaseRepo {
    public CsvStudentRepository() {
        super("pl.jasiek.app.model.Student");
    }
}
