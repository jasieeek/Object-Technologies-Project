package pl.jasiek.app.controller;

import pl.jasiek.app.csv.repo.CsvBaseRepo;
import pl.jasiek.app.csv.structure.CsvEntry;
import pl.jasiek.app.repository.CsvAdditionalActivityRepository;
import pl.jasiek.app.repository.CsvGroupRepository;
import pl.jasiek.app.repository.CsvStudentRepository;
import pl.jasiek.app.repository.CsvTeacherRepository;
import pl.jasiek.app.view.View;

public class FindByIDCommand implements Command {
    private View view;

    public FindByIDCommand(View view) {
        this.view = view;
    }

    @Override
    public void run() {
        System.out.println("[0] Additional activity\n[1] Group\n[2] Student\n[3] Teacher\n");
        switch (view.readInt("CHOOSE")) {
            case 0:
                CsvAdditionalActivityRepository csvAdditionalActivityRepository = new CsvAdditionalActivityRepository();
                findItem(csvAdditionalActivityRepository);
                break;
            case 1:
                CsvGroupRepository csvGroupRepository = new CsvGroupRepository();
                findItem(csvGroupRepository);
                break;
            case 2:
                CsvStudentRepository csvStudentRepo = new CsvStudentRepository();
                findItem(csvStudentRepo);
                break;
            case 3:
                CsvTeacherRepository csvTeacherRepository = new CsvTeacherRepository();
                findItem(csvTeacherRepository);
                break;
            default:
                System.out.println("Incorrect value! Returning to main menu...");
        }
    }

    private void findItem(CsvBaseRepo repo) {
        CsvEntry collect = repo.findById(view.readInt("ID"));
//        zastosuj try/catch
        if (collect != null) {
            collect.getFields().forEach(csvField -> System.out.println(csvField.toShortString()));
        } else {
            System.out.println("The item hasn't been found!");
        }
    }

    @Override
    public String getLabel() {
        return "Find by ID";
    }
}
