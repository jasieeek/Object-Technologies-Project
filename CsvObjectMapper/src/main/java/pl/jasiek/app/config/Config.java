package pl.jasiek.app.config;

import pl.jasiek.app.controller.*;
import pl.jasiek.app.view.ConsoleView;
import pl.jasiek.app.view.View;
import pl.jasiek.app.view.menu.ConsoleMenu;

import java.util.ArrayList;
import java.util.List;

public class Config {
    private View view = new ConsoleView();

    public ConsoleMenu initializeMenu() {
        return new ConsoleMenu(view);
    }

    public List<Command> initializeCommands(){
        List<Command> commandList = new ArrayList<>();
        commandList.add(new AddItemCommand(view));
        commandList.add(new ShowItemsCommand(view));
        commandList.add(new FindByIDCommand(view));
        commandList.add(new ModifyItemCommand(view));
        commandList.add(new RemoveItemCommand(view));
        commandList.add(new RefreshCommand());
        commandList.add(new ExitCommand());

        return commandList;
    }
}
