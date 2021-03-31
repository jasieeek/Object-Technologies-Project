package pl.jasiek.app.view;

import java.time.Year;

public interface View {
    Year readDate(String label);
    String readString(String label);
    int readInt(String label);
    double readDouble(String label);
    String readValueAsString(String fieldName, String fieldType);
    void info(String message);
}
