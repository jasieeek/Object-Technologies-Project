package pl.jasiek.app.config;

import pl.jasiek.app.controller.*;
import pl.jasiek.app.mapper.DataMapper;
import pl.jasiek.app.mapper.DataModelMapper;
import pl.jasiek.app.repository.Repository;
import pl.jasiek.app.repository.csv.ItemCsvRepo;
import pl.jasiek.app.view.ConsoleView;
import pl.jasiek.app.view.View;
import pl.jasiek.app.view.menu.ConsoleMenu;

import java.util.ArrayList;
import java.util.List;

public class Config {
    private View view = new ConsoleView();
    private Repository itemCsvRepo = new ItemCsvRepo();
    private static DataModelMapper dataModelMapper = new DataModelMapper();
    private DataMapper dataMapper = new DataMapper();

    public Config() {
        initializeDataModel();
        initializeRepository();
    }

    public List<Command> initializeCommands(){
        List<Command> commandList = new ArrayList<>();
        commandList.add(new ShowDataModelCommand());
        commandList.add(new ShowItemsCommand(itemCsvRepo));
        commandList.add(new AddItemCommand(view, itemCsvRepo));
        commandList.add(new ModifyItemCommand(view, itemCsvRepo));
        commandList.add(new RemoveItemCommand(view, itemCsvRepo));
        commandList.add(new RefreshCommand());
        commandList.add(new ExitCommand(dataModelMapper, dataMapper, itemCsvRepo));

        return commandList;
    }

    public ConsoleMenu initializeMenu() {
        return new ConsoleMenu(view);
    }

    private static void initializeDataModel() {
        System.out.println("Starting importing data model...");
        dataModelMapper.importDataModel();
        System.out.println("Ending importing data model");
    }

    private void initializeRepository() {
        System.out.println("Starting importing data...");
        itemCsvRepo.init(dataMapper.importItemList());
        System.out.println("Ending importing data");
    }
}
