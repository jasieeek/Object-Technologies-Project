package pl.jasiek.app.controller;

import pl.jasiek.app.repository.CsvAdditionalActivityRepository;
import pl.jasiek.app.repository.CsvGroupRepository;
import pl.jasiek.app.repository.CsvStudentRepository;
import pl.jasiek.app.repository.CsvTeacherRepository;
import pl.jasiek.app.view.View;

public class RemoveItemCommand implements Command {
    private View view;

    public RemoveItemCommand(View view) {
        this.view = view;
    }

    public void run() {
        int id = 0;
        System.out.println("[0] Additional activity\n[1] Group\n[2] Student\n[3] Teacher\n");
        switch (view.readInt("CHOOSE")) {
            case 0:
                id = view.readInt("Type ID of the item to remove");
                CsvAdditionalActivityRepository csvAdditionalActivityRepository = new CsvAdditionalActivityRepository();
                csvAdditionalActivityRepository.remove(id);
                break;
            case 1:
                id = view.readInt("Type ID of the item to remove");
                CsvGroupRepository csvGroupRepository = new CsvGroupRepository();
                csvGroupRepository.remove(id);
                break;
            case 2:
                id = view.readInt("Type ID of the item to remove");
                CsvStudentRepository csvStudentRepo = new CsvStudentRepository();
                csvStudentRepo.remove(id);
                break;
            case 3:
                id = view.readInt("Type ID of the item to remove");
                CsvTeacherRepository csvTeacherRepository = new CsvTeacherRepository();
                csvTeacherRepository.remove(id);
                break;
            default:
                System.out.println("Incorrect value! Returning to main menu...");
        }
        view.logging("The item with id " + id + " has been removed!");
    }

    @Override
    public String getLabel() {
        return "Remove item";
    }
}
