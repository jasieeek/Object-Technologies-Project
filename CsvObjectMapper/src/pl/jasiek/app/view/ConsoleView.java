package pl.jasiek.app.view;

import java.util.Scanner;

public class ConsoleView implements View {
    private Scanner scanner;

    public ConsoleView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String readString(String label) {
        System.out.println(label + ": ");
        return scanner.nextLine();
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


