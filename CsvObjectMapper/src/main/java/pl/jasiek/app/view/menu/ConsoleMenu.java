package pl.jasiek.app.view.menu;

import pl.jasiek.app.controller.Command;
import pl.jasiek.app.view.View;

import java.util.List;

public class ConsoleMenu {
    private View view;
    private static final String OPTION_FORMAT = "[%d] %s";

    public ConsoleMenu(View view) {
        this.view = view;
    }

    public void show(List<Command> commandList) {
        for (Command command : commandList) {
            String message = String.format(OPTION_FORMAT, commandList.indexOf(command), command.getLabel());
            view.info(message);
        }
    }

    public Command getChoice(List<Command> commands) {
        try {
            int choice = view.readInt("Choose");
            return commands.get(choice);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wprowadzona wartosc jest nieprawidlowa, prosze wpisac poprawna wartosc!");
        }
        return commands.stream().filter(command -> command.getLabel().equals("Refresh")).findFirst().orElse(null);
    }
}
