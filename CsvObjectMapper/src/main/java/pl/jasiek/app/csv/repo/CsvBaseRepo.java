package pl.jasiek.app.csv.repo;

import pl.jasiek.app.csv.mapper.handler.CsvRepoEntryHandler;
import pl.jasiek.app.csv.structure.CsvEntry;
import pl.jasiek.app.csv.structure.CsvField;

import java.util.List;

public abstract class CsvBaseRepo {
    private String csvClassName;

    protected CsvBaseRepo(String csvClassName) {
        this.csvClassName = csvClassName;
    }

    public List<CsvEntry> findAll() {
        return CsvRepoEntryHandler.loadEntries(csvClassName);
    }

    public CsvEntry findById(long id) {
        return findAll().stream()
                .filter(csvEntry -> {
                    CsvField tmpCsvField = csvEntry.getFields().stream()
                            .filter(CsvField::isPrimaryKey)
                            .findFirst()
                            .orElse(null);
                    assert tmpCsvField != null;
                    return tmpCsvField.getValue().equals(String.valueOf(id));
                })
                .findFirst()
                .orElse(null);
    }

    public void save(CsvEntry csvEntry) {
        CsvRepoEntryHandler.addEntry(csvClassName, csvEntry);
    }

    public void remove(long id) {
        CsvRepoEntryHandler.removeEntry(csvClassName, String.valueOf(id));
    }

    public void modifyById(long id, CsvEntry csvEntry) {

    }
}
