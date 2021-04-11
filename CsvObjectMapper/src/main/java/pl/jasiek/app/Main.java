package pl.jasiek.app;

import pl.jasiek.app.config.Config;
import pl.jasiek.app.controller.Command;
import pl.jasiek.app.repository.ItemRepository;
import pl.jasiek.app.view.menu.ConsoleMenu;

import java.util.List;

public class Main {
    private static ConsoleMenu menu;
    private static List<Command> commandList;
    private static ItemRepository itemRepository;

    private static void init() {
        Config config = new Config();
        menu = config.initializeMenu();
        commandList = config.initializeCommands();
        itemRepository = config.initializeRepository();
    }

    public static void main(String[] args) {
        init();

        while(true) {
            menu.show(itemRepository, commandList);
            Command command = menu.getChoice(commandList);
            command.execute();
        }
    }
}
