package pl.jasiek.app.mapper;

abstract public class CsvMapper {
    protected static final String COMA = ",";

    public abstract void importData();
    public abstract void exportData();

}
