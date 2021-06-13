package pl.jasiek.app.controller;

import pl.jasiek.app.csv.repo.CsvBaseRepo;
import pl.jasiek.app.csv.structure.CsvEntry;
import pl.jasiek.app.csv.structure.CsvField;
import pl.jasiek.app.model.AdditionalActivity;
import pl.jasiek.app.repository.CsvStudentRepository;
import pl.jasiek.app.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AddItemCommand implements Command {
    private View view;

    public AddItemCommand(View view) {
        this.view = view;;
    }

    @Override
    public void run() {
        System.out.println("[0] Additional activity\n[1] Group\n[2] Student\n[3] Teacher\n");
        switch (view.readInt("CHOOSE")) {
            case 0:
                AdditionalActivity additionalActivity = new AdditionalActivity();
                additionalActivity.setName(view.readString("Name"));
                additionalActivity.setPlace(view.readString("Place"));

                break;
            case 1:

                break;
//                ...
            default:
                System.out.println("Incorrect value! Returning to main menu...");
        }
        String name = "Student";
        CsvBaseRepo repository = new CsvStudentRepository();
        CsvEntry csvEntry = new CsvEntry();

        // to adjust
        List<CsvField> csvFields = new ArrayList<>();
        csvFields.add(new CsvField("id", "0", true, false));
        csvFields.add(new CsvField("name", "Kamil", false, false));
        csvFields.add(new CsvField("surname", "Jasiak", false, false));
        csvFields.add(new CsvField("idGroup", "3", false, true));
        csvEntry.setFields(csvFields);
        repository.save(csvEntry);

        List<CsvField> csvFields2 = new ArrayList<>();
        csvFields2.add(new CsvField("id", "1", true, false));
        csvFields2.add(new CsvField("name", "Jan", false, false));
        csvFields2.add(new CsvField("surname", "Nowak", false, false));
        csvFields2.add(new CsvField("idGroup", "1", false, true));
        csvEntry.setFields(csvFields2);
        repository.save(csvEntry);

        // wyswietl data model
//        Item item = new Item();
//        item.setId(repository.generateId());
//        item.setFields(readFields());
//        repository.create(item);
//        System.out.println("Item " + item.getId() + " has been created!");
    }

    private List<CsvField> readFieldsBaseEntry(CsvEntry csvEntry) {
        List<CsvField> csvFields = new ArrayList<>();

        List<String> collect = csvEntry.getFields().stream()
                .filter(csvField -> !csvField.isPrimaryKey())
                .map(CsvField::getName)
                .collect(Collectors.toList());

        for (String fieldName : collect) {
            CsvField csvField = new CsvField();

            csvField.setName(fieldName);
            csvField.setValue(view.readString(fieldName));
            csvField.setPrimaryKey(false);
            csvFields.add(csvField);
        }

        return csvFields;
    }

    @Override
    public String getLabel() {
        return "Add item";
    }
}
