package pl.jasiek.app.view;

public interface View {
    int readInt(String label);
    String readValueAsString(String fieldName, String fieldType, boolean isModification);
    void info(String message);
}
