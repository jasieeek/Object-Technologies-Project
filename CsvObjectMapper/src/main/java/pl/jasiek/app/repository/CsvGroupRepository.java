package pl.jasiek.app.repository;

import pl.jasiek.app.csv.repo.CsvBaseRepo;

public class CsvGroupRepository extends CsvBaseRepo {
    public CsvGroupRepository() {
        super("pl.jasiek.app.model.Group");
    }
}
