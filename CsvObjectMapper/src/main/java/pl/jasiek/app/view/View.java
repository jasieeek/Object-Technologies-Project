package pl.jasiek.app.view;

public interface View {
    int readInt(String label);
    String readFieldValueAsString(String fieldName, String fieldType, boolean isModification);
    void info(String message);
    void logging(String message);
    void clear();
}
