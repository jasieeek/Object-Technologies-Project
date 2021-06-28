package pl.jasiek.app.controller;

import pl.jasiek.app.csv.repo.CsvBaseRepo;
import pl.jasiek.app.csv.structure.CsvEntry;
import pl.jasiek.app.csv.structure.CsvField;
import pl.jasiek.app.repository.CsvAdditionalActivityRepository;
import pl.jasiek.app.repository.CsvGroupRepository;
import pl.jasiek.app.repository.CsvStudentRepository;
import pl.jasiek.app.repository.CsvTeacherRepository;
import pl.jasiek.app.view.View;

public class ShowItemsCommand implements Command {
    private View view;

    public ShowItemsCommand(View view) {
        this.view = view;
    }

    @Override
    public void run() {
        System.out.println("[0] Additional activity\n[1] Group\n[2] Student\n[3] Teacher\n");
        switch (view.readInt("CHOOSE")) {
            case 0:
                view.info("\n--------------------Additional activity repo--------------------\n");
                CsvAdditionalActivityRepository additionalActivityRepository = new CsvAdditionalActivityRepository();
                showItems(additionalActivityRepository);
                view.info("\n--------------------End--------------------\n");
                break;
            case 1:
                view.info("\n--------------------Group repo--------------------\n");
                CsvGroupRepository groupRepository = new CsvGroupRepository();
                showComplexItems(groupRepository);
                view.info("\n--------------------End--------------------\n");
                break;
            case 2:
                view.info("\n--------------------Student repo--------------------\n");
                CsvStudentRepository studentRepository = new CsvStudentRepository();
                showComplexItems(studentRepository);
                view.info("\n--------------------End--------------------\n");
                break;
            case 3:
                view.info("\n--------------------Teacher repo--------------------\n");
                CsvTeacherRepository teacherRepository = new CsvTeacherRepository();
                showItems(teacherRepository);
                view.info("\n--------------------End--------------------\n");
                break;
            default:
                System.out.println("Incorrect value! Returning to main menu...");
        }
    }

    private void showItems(CsvBaseRepo repo) {
        repo.findAll().forEach(element -> {
            element.getFields().forEach(field -> System.out.println(field.toShortString()));
            System.out.println("---------------");
        });
    }

    private void showComplexItems(CsvBaseRepo repo) {
        for (CsvEntry csvEntry : repo.findAll()) {
            for (CsvField field : csvEntry.getFields()) {
                if (field.isForeignKey()) {
                    String relatedClassName = "pl.jasiek.app.model." + field.getName().substring(2);
                    CsvTeacherRepository csvBaseRepo = new CsvTeacherRepository(relatedClassName);
                    CsvEntry byId = csvBaseRepo.findById(Long.parseLong(field.getValue()));
                    System.out.println(field.getName() + " = ");
                    byId.getFields().forEach(relatedField -> System.out.println(relatedField.relatedFieldToString()));
                    System.out.println("---------------");
                } else {
                    System.out.println(field.getName() + " = " + field.getValue());
                }
            }
        }
    }

    @Override
    public String getLabel() {
        return "Show items";
    }
}
