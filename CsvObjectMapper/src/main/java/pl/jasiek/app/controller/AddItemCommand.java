package pl.jasiek.app.controller;

import pl.jasiek.app.csv.mapper.helper.CsvClassHelper;
import pl.jasiek.app.csv.structure.CsvEntity;
import pl.jasiek.app.model.AdditionalActivity;
import pl.jasiek.app.model.Group;
import pl.jasiek.app.model.Student;
import pl.jasiek.app.model.Teacher;
import pl.jasiek.app.repository.CsvAdditionalActivityRepository;
import pl.jasiek.app.repository.CsvGroupRepository;
import pl.jasiek.app.repository.CsvStudentRepository;
import pl.jasiek.app.repository.CsvTeacherRepository;
import pl.jasiek.app.view.View;


public class AddItemCommand implements Command {
    private View view;

    public AddItemCommand(View view) {
        this.view = view;
    }

    @Override
    public void run() {
        System.out.println("[0] Additional activity\n[1] Group\n[2] Student\n[3] Teacher\n");
        switch (view.readInt("CHOOSE")) {
            case 0:
                CsvAdditionalActivityRepository csvAdditionalActivityRepository = new CsvAdditionalActivityRepository();
                CsvEntity csvEntityAdditionalActivity = CsvClassHelper.extractCsvEntity(AdditionalActivity.class.getName());
                csvAdditionalActivityRepository.save(CsvClassHelper.readCsvEntry(csvEntityAdditionalActivity, view));
                break;
            case 1:
                CsvGroupRepository csvGroupRepository = new CsvGroupRepository();
                CsvEntity csvEntityGroup = CsvClassHelper.extractCsvEntity(Group.class.getName());
                csvGroupRepository.save(CsvClassHelper.readCsvEntry(csvEntityGroup, view));
                break;
            case 2:
                CsvStudentRepository csvStudentRepo = new CsvStudentRepository();
                CsvEntity csvEntityStudent = CsvClassHelper.extractCsvEntity(Student.class.getName());
                csvStudentRepo.save(CsvClassHelper.readCsvEntry(csvEntityStudent, view));
                break;
            case 3:
                CsvTeacherRepository csvTeacherRepository = new CsvTeacherRepository();
                CsvEntity csvEntityTeacher = CsvClassHelper.extractCsvEntity(Teacher.class.getName());
                csvTeacherRepository.save(CsvClassHelper.readCsvEntry(csvEntityTeacher, view));
                break;
            default:
                System.out.println("Incorrect value! Returning to main menu...");
        }
    }

    @Override
    public String getLabel() {
        return "Add item";
    }
}
