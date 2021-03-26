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
        System.out.println(label + ": ");
        return scanner.nextLine();
    }

    @Override
    public double readDouble(String label) {
        System.out.println(label + ": ");
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    @Override
    public int readInt(String label) {
        System.out.println(label + ": ");
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }
}


