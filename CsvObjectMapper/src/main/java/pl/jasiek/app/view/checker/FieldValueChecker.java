package pl.jasiek.app.view.checker;

import pl.jasiek.app.view.ConsoleView;

import java.time.Year;

public class FieldValueChecker extends ConsoleView {
    public static String checkFieldValue(String fieldType, String value) {
        Object result;
        switch (fieldType) {
            case "string":
                do {
                    result = checkString(value);
                } while (result.toString().equals("-1"));
                break;
            case "double":
                while (checkDouble(value) == -1) {
                    value = String.valueOf(checkDouble(scanner.nextLine()));
                }
                result = checkDouble(value);
                break;
            case "year":
                while (checkYear(value) == -1) {
                    value = String.valueOf(checkYear(scanner.nextLine()));
                }
                result = checkYear(value);
                break;
            default:
                result = "";
                System.out.println("Wrong type of field! Please contact a administrator!");
        }
        return result.toString();
    }

    public static String checkEmptyFieldValue(String value) {
        while (value.equals("")) {
            System.out.println("You type an empty value! Please type something!");
            value = scanner.nextLine();
        }
        return value;
    }

    private static String checkString(String value) {
        return value.isEmpty() ? "-1" : value;
    }

    private static double checkDouble(String value) {
        try {
            double parseDouble = Double.parseDouble(value);
            if (parseDouble < 2000000) {
                return parseDouble;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong value, please type a number that match x.xx format!");
            return -1;
        }
        System.out.println("Wrong value, please type a number less than 2 000 000!");
        return -1;
    }

    private static int checkYear(String value) {
        try {
            int parseInt = Integer.parseInt(value);
            if (parseInt > 0 && parseInt <= Year.now().getValue()) {
                return parseInt;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong value, please type a number!");
            return -1;
        }
        System.out.println("Wrong value, please type a number from 1920 to current year!");
        return -1;
    }
}
