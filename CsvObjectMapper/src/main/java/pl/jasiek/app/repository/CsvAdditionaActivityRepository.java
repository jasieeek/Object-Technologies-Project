package pl.jasiek.app.repository;

import pl.jasiek.app.csv.repo.CsvBaseRepo;

public class CsvAdditionaActivityRepository extends CsvBaseRepo {
    protected CsvAdditionaActivityRepository() {
        super("pl.jasiek.app.model.AdditionalActivity");
    }
}
