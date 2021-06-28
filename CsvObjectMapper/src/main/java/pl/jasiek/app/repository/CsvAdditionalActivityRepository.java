package pl.jasiek.app.repository;

import pl.jasiek.app.csv.repo.CsvBaseRepo;

public class CsvAdditionalActivityRepository extends CsvBaseRepo {
    public CsvAdditionalActivityRepository() {
        super("pl.jasiek.app.model.AdditionalActivity");
    }
}
