package pl.jasiek.app.repository;

import pl.jasiek.app.csv.repo.CsvBaseRepo;

public class CsvTeacherRepository extends CsvBaseRepo {
    public CsvTeacherRepository() {
        super("pl.jasiek.app.model.Teacher");
    }

    public CsvTeacherRepository(String csvClassName) {
        super(csvClassName);
    }
}
