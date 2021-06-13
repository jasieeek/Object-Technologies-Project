package pl.jasiek.app.controller;

import pl.jasiek.app.repository.CsvStudentRepository;
import pl.jasiek.app.view.View;

public class ShowItemsCommand implements Command {
    private View view;

    public ShowItemsCommand(View view) {
        this.view = view;
    }

    @Override
    public void run() {
        CsvStudentRepository repo = new CsvStudentRepository();
        repo.findAll().forEach(System.out::println);
//        itemRepository.findAll().forEach(System.out::println);
        view.info("\n--------------------End--------------------\n");
    }

    @Override
    public String getLabel() {
        return "Show items";
    }
}
