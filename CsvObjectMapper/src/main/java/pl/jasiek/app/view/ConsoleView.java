package pl.jasiek.app.view;

import pl.jasiek.app.view.checker.FieldValueChecker;

import java.util.Scanner;

public class ConsoleView implements View {
    protected static Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String readFieldValueAsString(String fieldName, String fieldType, boolean isModification) {
        showLabel(fieldName);
        String fieldValue = scanner.nextLine();

        if (isModification && fieldValue.equals("")) {
            return "0";
        } else {
            fieldValue = FieldValueChecker.checkEmptyFieldValue(fieldValue);
            return FieldValueChecker.checkFieldValue(fieldType, fieldValue);
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
    public void info(String message) {
        System.out.println(message);
    }

    private void showLabel(String label) {
        label = label.toUpperCase() + ": ";
        System.out.println(label);
    }
}


