package pl.jasiek.app;

import pl.jasiek.app.config.Config;
import pl.jasiek.app.controller.Command;
import pl.jasiek.app.csv.mapper.initializer.CsvMapperInitializer;
import pl.jasiek.app.view.menu.ConsoleMenu;

import java.util.List;

public class Main {
    private static ConsoleMenu menu;
    private static List<Command> commandList;

    private static void init() {
        Config config = new Config();
        menu = config.initializeMenu();
        commandList = config.initializeCommands();
        CsvMapperInitializer.init();
    }

    public static void main(String[] args) {
        init();

        while(true) {
            menu.show(commandList);
            Command command = menu.getChoice(commandList);
            command.run();
        }

//        test("pl.jasiek.app.controller");
//        try {
//            System.out.println(Arrays.toString(CsvClassLoader.getClasses("C:.Users.user.IdeaProjects.JAVA.nauka.Figure.out.production.Figure")));
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }







//        String fieldName = "students";
//        try {
//            System.out.println(Arrays.toString(Group.class.getDeclaredField(fieldName).getAnnotations()));;
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//        try {
//            if (Group.class.getDeclaredField(fieldName).getAnnotation(OneToOne.class) != null) {
//                System.out.println("Relacja One to one");
//                System.out.println(Group.class.getDeclaredField(fieldName).getAnnotation(OneToOne.class).value());
//            } else if (Group.class.getDeclaredField(fieldName).getAnnotation(ManyToOne.class) != null) {
//                System.out.println("Relacja Many to one");
//                System.out.println(Group.class.getDeclaredField(fieldName).getAnnotation(ManyToOne.class).value());
//            } else if (Group.class.getDeclaredField(fieldName).getAnnotation(OneToMany.class) != null) {
//                System.out.println("Relacja One to many");
//                System.out.println(Group.class.getDeclaredField(fieldName).getAnnotation(OneToMany.class).value());
//            } else {
//                System.out.println("Brak adnotacji na tym polu");
//            }
//            System.out.println();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
        // po odczytaniu adnotacji...
        // 1.

    }
}
