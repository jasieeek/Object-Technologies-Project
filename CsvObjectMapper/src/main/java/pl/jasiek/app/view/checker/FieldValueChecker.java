package pl.jasiek.app.view.checker;

import pl.jasiek.app.view.ConsoleView;

public class FieldValueChecker extends ConsoleView {
    public static String checkEmptyFieldValue(String value) {
        while (value.equals("")) {
            System.out.println("You type an empty value! Please type something!");
            value = scanner.nextLine();
        }
        return value;
    }

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

    private static String checkString(String value) {
        // sprawdz czy to jest jedno slowo lub dwuczlonowe
        return value.isEmpty() ? "-1" : value;
    }

    private static double checkDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            System.out.println("Wrong value, please type a number that match x.xx format!");
            return -1;
        }
    }

    private static int checkYear(String value) {
        // przerobic zeby tylko zwracal 4 cyfry z zakresu 1920-currentYear
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Wrong value, please type a number!");
            return -1;
        }
    }
}
