package pl.jasiek.app.view;

import java.time.Year;
import java.util.Scanner;

public class ConsoleView implements View {
    private Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Year readDate(String label) {
        System.out.println(label + ": ");
        return Year.of(scanner.nextInt());
    }

    @Override
    public String readString(String label) {
        showLabel(label);
        return scanner.nextLine();
    }

    @Override
    public String readValueAsString(String fieldName, String fieldType) {
        Object result;
        switch (fieldType) {
            case "string":
                result = readString(fieldName);
                break;
            case "double":
                result = readDouble(fieldName);
                break;
            case "year":
                result = readDate(fieldName);
                break;
            default:
                result = "";
                System.out.println("Wrong type of field!");
        }
        return result.toString();
    }

    @Override
    public double readDouble(String label) {
        showLabel(label);
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    @Override
    public int readInt(String label) {
        showLabel(label);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }

    private void showLabel(String label) {
        System.out.println(label);
    }
}


