package pl.jasiek.app.controller;

import pl.jasiek.app.mapper.DataMapper;
import pl.jasiek.app.mapper.DataModelMapper;
import pl.jasiek.app.repository.Repository;

public class ExitCommand implements Command {
    private DataModelMapper dataModelMapper;
    private DataMapper dataMapper;
    private Repository repository;

    public ExitCommand(DataModelMapper dataModelMapper, DataMapper dataMapper, Repository repository) {
        this.dataModelMapper = dataModelMapper;
        this.dataMapper = dataMapper;
        this.repository = repository;
    }

    @Override
    public void execute() {
        System.out.println("Starting saving data");
        dataMapper.exportItemList(repository.findAll());
        System.out.println("Ending saving data");
        System.exit(1);
    }

    @Override
    public String getLabel() {
        return "Exit";
    }
}
