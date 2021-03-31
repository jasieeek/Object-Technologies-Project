package pl.jasiek.app.controller;

import pl.jasiek.app.repository.Repository;
import pl.jasiek.app.view.View;

public class ShowItemsCommand implements Command {
    private View view;
    private Repository itemRepository;

    public ShowItemsCommand(View view, Repository itemRepository) {
        this.view = view;
        this.itemRepository = itemRepository;
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
