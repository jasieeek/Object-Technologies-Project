package pl.jasiek.app.controller;

import pl.jasiek.app.mapper.DataMapper;
import pl.jasiek.app.repository.csv.ItemRepository;

public class ExitCommand implements Command {
    private DataMapper dataMapper;
    private ItemRepository repository;

    public ExitCommand(DataMapper dataMapper, ItemRepository repository) {
        this.dataMapper = dataMapper;
        this.repository = repository;
    }

    @Override
    public void run() {
        System.out.println("Starting saving data...");
        dataMapper.exportItemList(repository.findAll());
        System.out.println("Ending saving data");
        System.exit(1);
    }

    @Override
    public String getLabel() {
        return "Exit";
    }
}
