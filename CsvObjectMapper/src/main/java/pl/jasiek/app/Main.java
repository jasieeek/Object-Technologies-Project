package pl.jasiek.app;

import pl.jasiek.app.config.Config;
import pl.jasiek.app.controller.Command;
import pl.jasiek.app.view.menu.ConsoleMenu;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();
        List<Command> commandList = config.initializeCommands();
        ConsoleMenu menu = config.initializeMenu();

        while(true) {
            menu.show(commandList);
            Command command = menu.getChoice(commandList);
            command.execute();
        }
    }
}
