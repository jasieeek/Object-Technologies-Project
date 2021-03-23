package pl.jasiek.app.config;

import pl.jasiek.app.controller.Command;
import pl.jasiek.app.controller.ExitCommand;
import pl.jasiek.app.controller.RefreshCommand;
import pl.jasiek.app.view.ConsoleView;
import pl.jasiek.app.view.View;
import pl.jasiek.app.view.menu.ConsoleMenu;

import java.util.ArrayList;
import java.util.List;

public class Config {
    private View view = new ConsoleView();
//    private Repo clientMemoryRepo = new MemoryRepo();
//    private ClientXmlRepo clientXmlRepo = new ClientXmlRepo();
//    private static final String FILE_NAME = "C:\\Users\\user\\Desktop\\clients.xml";

    public List<Command> initializeCommands(){
        List<Command> commandList = new ArrayList<>();
//        commandList.add(new ShowAllClientsCommand(clientMemoryRepo, view));
        commandList.add(new RefreshCommand());
        commandList.add(new ExitCommand());

        return commandList;
    }

    public ConsoleMenu initializeMenu() {
        return new ConsoleMenu(view);
    }

//    public void initializeClients() {
//        clientXmlRepo.loadData(FILE_NAME);
//    }
}
