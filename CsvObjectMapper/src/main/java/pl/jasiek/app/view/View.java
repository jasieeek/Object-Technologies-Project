package pl.jasiek.app.view;

import java.time.Year;

public interface View {
    Year readDate(String label);
    String readString(String label);
    int readInt(String label);
    double readDouble(String label);
    void info(String message);
}
