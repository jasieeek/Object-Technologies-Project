package pl.jasiek.app.view;

import pl.jasiek.app.view.reader.FieldValueReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleView implements View {
    private static final String LOG_FILE_PATH = "src\\main\\resources\\log.txt";
    protected static Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String readFieldValueAsString(String fieldName, String fieldType, boolean isModification) {
        String fieldValue = readString(fieldName);

        if (isModification && fieldValue.equals("")) {
            return "0";
        } else {
            fieldValue = FieldValueReader.checkEmptyFieldValue(fieldValue);
            return FieldValueReader.checkFieldValue(fieldType, fieldValue);
        }
    }

    @Override
    public int readInt(String label) {
        try {
            showLabel(label);
            String value = scanner.nextLine();
            if (value.equals("")) {
                return 0;
            }
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Wrong value, please type a number!");
            return -1;
        }
    }

    @Override
    public String readString(String label) {
        showLabel(label);
        return scanner.nextLine();
    }

    @Override
    public void logging(String message) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true));
            String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
            writer.append("\n")
                    .append("[")
                    .append(currentTime)
                    .append("] ")
                    .append(message);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }

    private void showLabel(String label) {
        label = label.toUpperCase() + ": ";
        System.out.println(label);
    }
}


