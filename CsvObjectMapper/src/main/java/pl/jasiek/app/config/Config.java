package pl.jasiek.app.config;

import pl.jasiek.app.controller.*;
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
    private Repository vehicleCsvRepo = new ItemCsvRepo();

    public Config() {
        initializeDataModel();
    }

    public List<Command> initializeCommands(){
        List<Command> commandList = new ArrayList<>();
//        commandList.add(new ShowAllClientsCommand(clientMemoryRepo, view));
        commandList.add(new ShowDataModelCommand());
        commandList.add(new AddItemCommand(view, vehicleCsvRepo));
        commandList.add(new RefreshCommand());
        commandList.add(new ExitCommand());

        return commandList;
    }

    public ConsoleMenu initializeMenu() {
        return new ConsoleMenu(view);
    }

    private void initializeDataModel() {
//        pobranie z pliku dataModel.csv wszystkich pol i zapisanie ich w klasie ItemDetails ( moze jako singleton )
        DataModelMapper dataModelMapper = new DataModelMapper();
        dataModelMapper.importData();
    }
}
