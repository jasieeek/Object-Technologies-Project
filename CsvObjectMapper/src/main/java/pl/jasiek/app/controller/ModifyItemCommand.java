package pl.jasiek.app.controller;

import pl.jasiek.app.view.View;

public class ModifyItemCommand implements Command {
    private View view;

    public ModifyItemCommand(View view) {
        this.view = view;
    }

    @Override
    public void run() {
//        TODO
//        int id = view.readInt("Type ID of the item to modify");
//        view.logging("The item with id " + id + " has been modified!");
//        Co zrobic zeby tak uzywac klasy repo np. do zapisu obiektu - stworzyc obiekt klasy Student
//        i przekazac go w parametrze do zapisu

//        nastepnie repozytorium majace metode save() oraz majaca ( w innej klasie/interfejsie )
//        generyczna implementacje tej metody dla klasy T

//        wtedy moglbym sprawdzac poprawnosc klas w relacjach oraz dziedziczeniu
//        CsvSimpleRepo<Student> repo = new CsvSimpleRepo<>();
//        Student student = new Student();
//        set fields of student...
//        repo.save(student);


//        Na ten moment zapis polega na stworzeniu obiektu klasy ogolnej klasy modelowej CsvEntry,
//        czyli klasy przechowujacej liste CsvFieldow
//        CsvStudentRepository csvStudentRepository = new CsvStudentRepository();
//        CsvEntry csvEntry = new CsvEntry();
//        csvEntry.setFields(new ArrayList<>());
//        csvStudentRepository.save(csvEntry);
        System.out.println("TODO");
    }


    @Override
    public String getLabel() {
        return "Modify item";
    }
}
