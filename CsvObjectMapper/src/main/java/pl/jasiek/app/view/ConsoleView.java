package pl.jasiek.app.view;

import pl.jasiek.app.model.ItemDetails;

import java.util.Scanner;

public class ConsoleView implements View {
    private Scanner scanner;
    private ItemDetails itemDetails;

    public ConsoleView() {
        scanner = new Scanner(System.in);
        itemDetails = ItemDetails.getInstance();
    }

    @Override
    public String readValueAsString(String fieldName, String fieldType, boolean isModification) {
        showLabel(fieldName);
        String scannerValue = scanner.nextLine();

        if (isModification && scannerValue.equals("")) {
            return "0";
        }

        while (scannerValue.equals("")) {
            System.out.println("You type an empty value! Please type something!");
            scannerValue = scanner.nextLine();
        }

        Object result;
        switch (fieldType) {
            case "string":
                do {
                    result = checkString(scannerValue);
                } while (result.toString().equals("-1"));
                break;
            case "double":
                while (checkDouble(scannerValue) == -1) {
                    scannerValue = String.valueOf(checkDouble(scanner.nextLine()));
                }
                result = checkDouble(scannerValue);
                break;
            case "year":
                while (checkYear(scannerValue) == -1) {
                    scannerValue = String.valueOf(checkYear(scanner.nextLine()));
                }
                result = checkYear(scannerValue);
                break;
            default:
                result = "";
                System.out.println("Wrong type of field! Please contact a administrator!");
        }
        return result.toString();
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

    private String checkString(String value) {
        // sprawdz czy to jest jedno slowo lub dwuczlonowe
        return value.isEmpty() ? "-1" : value;
    }

    private double checkDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            System.out.println("Wrong value, please type a number that match x.xx format!");
            return -1;
        }
    }

    private int checkYear(String value) {
        // przerobic zeby tylko zwracal 4 cyfry z zakresu 1920-currentYear
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Wrong value, please type a number!");
            return -1;
        }
    }

    private void showLabel(String label) {
        label = label.toUpperCase() + ": ";
        System.out.println(label);
    }
}


