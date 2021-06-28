package pl.jasiek.app.controller;

import pl.jasiek.app.csv.repo2.CsvSimpleRepo;
import pl.jasiek.app.csv.structure.CsvEntry;
import pl.jasiek.app.model.Student;
import pl.jasiek.app.repository.CsvStudentRepository;
import pl.jasiek.app.view.View;

import java.util.ArrayList;

public class ModifyItemCommand implements Command {
    private View view;

    public ModifyItemCommand(View view) {
        this.view = view;
    }

    @Override
    public void run() {
//        int id = view.readInt("Type ID of the item to modify");
//        view.logging("The item with id " + id + " has been modified!");
//        Co zrobic zeby tak uzywac klasy repo np. do zapisu obiektu - stworzyc obiekt klasy Student
//        i przekazac go w parametrze do zapisu

//        nastepnie repozytorium majace metode save() oraz majaca ( w innej klasie/interfejsie )
//        generyczna implementacje tej metody dla klasy T

//        wtedy moglbym sprawdzac poprawnosc klas w relacjach oraz dziedziczeniu
        CsvSimpleRepo<Student> repo = new CsvSimpleRepo<>();
        Student student = new Student();
//        set fields of student...
        repo.save(student);


//        Na ten moment zapis polega na stworzeniu obiektu klasy ogolnej klasy modelowej CsvEntry,
//        czyli klasy przechowujacej liste CsvFieldow
        CsvStudentRepository csvStudentRepository = new CsvStudentRepository();
        CsvEntry csvEntry = new CsvEntry();
        csvEntry.setFields(new ArrayList<>());
        csvStudentRepository.save(csvEntry);
    }


    @Override
    public String getLabel() {
        return "Modify item";
    }
}
