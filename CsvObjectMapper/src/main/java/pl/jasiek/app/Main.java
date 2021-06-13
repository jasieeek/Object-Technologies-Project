package pl.jasiek.app;

import pl.jasiek.app.config.Config;
import pl.jasiek.app.controller.Command;
import pl.jasiek.app.csv.mapper.initializer.CsvRepoInitializer;
import pl.jasiek.app.view.menu.ConsoleMenu;

import java.util.List;

public class Main {
    private static ConsoleMenu menu;
    private static List<Command> commandList;

    private static void init() {
        Config config = new Config();
        menu = config.initializeMenu();
        commandList = config.initializeCommands();
        CsvRepoInitializer.init();
    }


    public static void main(String[] args) {
        init();

        while(true) {
            menu.show(commandList);
            Command command = menu.getChoice(commandList);
            command.run();
        }







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

//        try {
//            System.out.println("Tworze repo dla " + "Teacher.csv");
//            Files.createFile(Paths.get("src\\main\\resources\\repo" + "\\" + "Teacher.csv".toLowerCase()));
//            PrintWriter zapis = new PrintWriter("src\\main\\resources\\repo" + "\\" + "Teacher.csv".toLowerCase());
//            zapis.println("id,name,surname");
//            zapis.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Field[] declaredFields = Student.class.getDeclaredFields();
//        for (Field field: declaredFields) {
//            System.out.println("Name: " + field.getName());
//            if (field.getAnnotation(ManyToOne.class) != null) {
//                System.out.println("powyzsze pole jest kluczem obcym");
//            }
//        }
//        String userName = "FU6GYAQ";
//        String[] usersArray = {"GGK3TXD"};
//        List<String> users = new ArrayList<>(Arrays.asList(usersArray));
////        String table = "<!-- MKS HTML --><table border='1' style='font-family: verdana,arial,sans-serif; font-size: 11px; border-width: 1px; border-spacing: 0; border-color: #999999; border-collapse: collapse; margin:10px 10px 10px 10px; width:100%;'><tr><td style='background:#ffffff;'></td><td>Offen</td><td style='background:#cdf3cd;'></td><td>Zugestimmt</td><td style='background:#efc1d6;'></td><td>Nicht zugestimmt</td><td style='background:#f2f2f2;'></td><td>Nicht relevant</td><td style='background:#ffffc1;'></td><td>Klarungsbedarf</td></tr></table><br /><table border='1' style='font-family: verdana,arial,sans-serif; font-size: 11px; border-width: 1px; border-spacing: 0; border-color: #999999; border-collapse: collapse; margin:10px 10px 10px 10px; width:100%;'><tr style='border-bottom-color: #BBBBBB; border-bottom-width: 2px; border-bottom-style: solid;'><td style='border-width: 1px;width:10%'>Name</td><td style='border-width: 1px;width:10%'>Datum</td><td style='border-width: 1px;width:10%'>Befund</td><td style='border-width: 1px;width:10%'>Gewichtung</td><td style='border-width: 1px;width:60%'>Kommentar</td></tr><tr id='GGK3TXD' style='background:#cdf3cd;'><td style='width:10%'>Systemuser, AVW1</td><td style='width:10%'>01.06.2021</td><td id='decision' style='width:10%'>Zugestimmt</td><td style='width:10%'> </td><td style='width:60%'>test</td></tr><tr id='FLX2U7S' style='background:#ffffff;'><td style='width:10%'>Systemuser, AVW2</td><td style='width:10%'>11.06.2021</td><td id='decision' style='width:10%'>Offen</td><td style='width:10%'>super</td><td style='width:60%'>comment</td></tr></table>";
//        String table = "<table border='1' style='font-family: verdana,arial,sans-serif; font-size: 11px; border-width: 1px; border-spacing: 0; border-color: #999999; border-collapse: collapse; margin:10px 10px 10px 10px; width:100%;'><tr><td style='background:#ffffff;'></td><td>Offen</td><td style='background:#cdf3cd;'></td><td>Zugestimmt</td><td style='background:#efc1d6;'></td><td>Nicht zugestimmt</td><td style='background:#f2f2f2;'></td><td>Nicht relevant</td><td style='background:#ffffc1;'></td><td>Klärungsbedarf</td></tr></table><br /><table border='1' style='font-family: verdana,arial,sans-serif; font-size: 11px; border-width: 1px; border-spacing: 0; border-color: #999999; border-collapse: collapse; margin:10px 10px 10px 10px; width:100%;'><tr style='border-bottom-color: #BBBBBB; border-bottom-width: 2px; border-bottom-style: solid;'><td style='border-width: 1px;width:10%'>Name</td><td style='border-width: 1px;width:10%'>Datum</td><td style='border-width: 1px;width:10%'>Befund</td><td style='border-width: 1px;width:10%'>Gewichtung</td><td style='border-width: 1px;width:60%'>Kommentar</td></tr><tr id='FU6GYAQ' style='background:#cdf3cd;'><td style='width:10%'>Systemuser, AVW</td><td style='width:10%'>11.06.2021</td><td id='decision' style='width:10%'>Zugestimmt</td><td style='width:10%'></td><td style='width:60%'></td></tr><tr id='GGK3TXD' style='background:#ffffff;'><td style='width:10%'>Systemuser, AVW</td><td style='width:10%'> </td><td id='decision' style='width:10%'>Offen</td><td style='width:10%'> </td><td style='width:60%'> </td></tr><tr id='FLX2U7S' style='background:#ffffff;'><td style='width:10%'>Systemuser, AVW</td><td style='width:10%'> </td><td id='decision' style='width:10%'>Offen</td><td style='width:10%'> </td><td style='width:60%'> asdasd</td></tr></table>";
//        String rowPattern = "(<tr id='%s'.*?</tr>)";
//        String rowsPattern = "";
//        for (String username : users) {
//            String format = String.format(rowPattern, username);
//            rowsPattern += format;
//        }
//
//        Pattern pattern = Pattern.compile(rowsPattern);
//        Matcher matcher = pattern.matcher(table);
//
//        List<String> rows = new ArrayList<>();
//
//
//        if (matcher.find()) {
//            for (int i = 0; i < users.size(); i++) {
////                System.out.println(matcher.group(i+1));
//                rows.add(matcher.group(i+1));
//            }
//        }
//
//        System.out.println(rows);
//
//        StringBuilder resultRows = new StringBuilder();
//
//        for (String row : rows) {
//            String patternCatcher = "<td.*>(.*)</td><td.*>(.*)</td><td.*>(.*)</td><td.*>(.*)</td><td.*>(.*)</td>";
//
//            Pattern mainPatter = Pattern.compile(patternCatcher);
//            Matcher mainMatcher = mainPatter.matcher(row);
//
//            while (mainMatcher.find()) {
//                for (int i = 1; i < 6; i++) {
//                    String tmpMatcherGroup = mainMatcher.group(i);
//                    if (!tmpMatcherGroup.trim().isEmpty()) {
//                        row = row.replaceAll(tmpMatcherGroup, "<strike>" + tmpMatcherGroup + "</strike>");
//                    }
//                }
//            }
//
//            System.out.println(row);
//        }
//
//        System.out.println(table.replaceAll(String.format(rowPattern, users.get(0)), resultRows.toString()));
//


//
//
//        while (matcher.find()) {
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//        }

//        String patternString = "<tr id='FU6GYAQ' style='background:#cdf3cd;'><td style='width:10%'>Systemuser, AVW</td><td style='width:10%'>01.06.2021</td><td id='decision' style='width:10%'>Zugestimmt</td><td style='width:10%'>Mittel</td><td style='width:60%'>test</td></tr>";
//        String patternCatcher = "<td.*>(.*)</td><td.*>(.*)</td><td.*>(.*)</td><td.*>(.*)</td><td.*>(.*)</td>";
//        Pattern pattern = Pattern.compile(patternCatcher);
//        Matcher matcher = pattern.matcher(patternString);
//
//        while (matcher.find()) {
//            System.out.println(matcher.group(1));
//            patternString = patternString.replaceAll(matcher.group(1), "<strike>" + matcher.group(1) + "</strike>");
//            System.out.println(matcher.group(2));
//            patternString = patternString.replaceAll(matcher.group(2), "<strike>" + matcher.group(2) + "</strike>");
//            System.out.println(matcher.group(3));
//            patternString = patternString.replaceAll(matcher.group(3), "<strike>" + matcher.group(3) + "</strike>");
//            System.out.println(matcher.group(4));
//            patternString = patternString.replaceAll(matcher.group(4), "<strike>" + matcher.group(4) + "</strike>");
//            System.out.println(matcher.group(5));
//            patternString = patternString.replaceAll(matcher.group(5), "<strike>" + matcher.group(5) + "</strike>");
//        }
//
//        System.out.println(patternString);
    }
}
