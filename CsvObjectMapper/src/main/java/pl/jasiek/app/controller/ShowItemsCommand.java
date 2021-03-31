package pl.jasiek.app.controller;

import pl.jasiek.app.repository.Repository;
import pl.jasiek.app.view.View;

public class ShowItemsCommand implements Command {
    private Repository itemRepository;
    private View view;

    public ShowItemsCommand(Repository itemRepository, View view) {
        this.itemRepository = itemRepository;
        this.view = view;
    }

    @Override
    public void execute() {
        itemRepository.findAll().forEach(System.out::println);
    }

    @Override
    public String getLabel() {
        return "Show items";
    }
}
