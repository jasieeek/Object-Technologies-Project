package pl.jasiek.app.csv.mapper.handler;

import pl.jasiek.app.csv.annotation.CsvClass;
import pl.jasiek.app.csv.annotation.CsvID;
import pl.jasiek.app.csv.annotation.ManyToOne;
import pl.jasiek.app.csv.structure.CsvEntry;
import pl.jasiek.app.csv.structure.CsvField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvRepoEntryHandler {
    private static final String COMA = ",";

    public static List<CsvEntry> loadEntries(String csvClassName) {
        List<CsvEntry> csvEntries = new ArrayList<>();
        String line;
        int startCounter = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(extractRepoPath(csvClassName)))) {
            while ((line = br.readLine()) != null) {
                startCounter++;
                // iteruje od drugiego bo pomijam wiersz z nazwami kolumn
                if (startCounter > 1) {
                    CsvEntry tmpCsvEntry = new CsvEntry();
                    String[] splitLine = line.split(COMA);
                    List<CsvField> csvRepoFieldsWithoutValue = extractCsvFieldsWithoutValue(csvClassName);
                    List<CsvField> csvRepoFields = new ArrayList<>();
                    for (int i = 0; i < splitLine.length; i++) {
                        String tmpValue = splitLine[i];
                        CsvField tmpCsvField = csvRepoFieldsWithoutValue.get(i);
                        tmpCsvField.setValue(tmpValue);
                        csvRepoFields.add(tmpCsvField);
                    }
                    tmpCsvEntry.setFields(csvRepoFields);
                    csvEntries.add(tmpCsvEntry);
                }
            }
        } catch (IOException e) {
            System.out.println("Error with load csv file");
        }
        return csvEntries;
    }

    public static void addEntry(String repoClassName, CsvEntry csvEntry) {
        try {
            Class<?> clazz = Class.forName(repoClassName);
            String repoPath = clazz.getAnnotation(CsvClass.class).value();
//            get existing repository and add row based on csvEntry
            String existingRepo = extractRepoAsString(repoPath);
            String updatedRepo = addRowToRepo(existingRepo, csvEntry);
            Files.write(Paths.get(repoPath), updatedRepo.lines().collect(Collectors.toList()));
        } catch (ClassNotFoundException e) {
            System.out.println(repoClassName + " hasn't been found!");
        } catch (IOException e) {
            System.out.println("Unable to save file exchanges data :(");
        }
    }

    public static void removeEntry(String repoClassName, String id) {
        try {
            Class<?> clazz = Class.forName(repoClassName);
            String repoPath = clazz.getAnnotation(CsvClass.class).value();
            String existingRepo = extractRepoAsString(repoPath);
            List<String> updatedRepo = removeRowFromRepo(existingRepo, id);
            Files.write(Paths.get(repoPath), updatedRepo);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to save file exchanges data :(");
        }
    }

    private static List<CsvField> extractCsvFieldsWithoutValue(String csvClassName) {
        List<CsvField> result = new ArrayList<>();
        try {
            Class<?> clazz = Class.forName(csvClassName);
            result = Arrays.stream(clazz.getDeclaredFields())
                    .map(field -> {
                        CsvField tmpCsvField = new CsvField();
                        tmpCsvField.setName(field.getName());
                        tmpCsvField.setPrimaryKey(isFieldPrimaryKey(field));
                        tmpCsvField.setForeignKey(isFieldForeignKey(field));
                        return tmpCsvField;
                    })
                    .collect(Collectors.toList());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static boolean isFieldPrimaryKey(Field field) {
        CsvID annotation = field.getAnnotation(CsvID.class);
        return annotation != null;
    }

    private static boolean isFieldForeignKey(Field field) {
        ManyToOne annotation = field.getAnnotation(ManyToOne.class);
        return annotation != null;
    }

    private static String extractRepoPath(String csvClassName) {
        String result = "";
        try {
            Class<?> clazz = Class.forName(csvClassName);
            result = clazz.getAnnotation(CsvClass.class).value();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static List<String> removeRowFromRepo(String existingRepo, String id) {
        List<String> existingRows = existingRepo.lines().collect(Collectors.toList());
        List<String> resultRows = new ArrayList<>();
        for (String row : existingRows) {
            int indexOfComma = row.indexOf(",");
            String tmpId = row.substring(0, indexOfComma);
            if (!id.equals(tmpId)) {
                resultRows.add(row);
            }
        }
        return resultRows;
    }

    private static String addRowToRepo(String existingRepo, CsvEntry csvEntry) {
        String result = existingRepo;
        StringBuilder newRow = new StringBuilder();
        for (CsvField csvField: csvEntry.getFields()) {
            newRow.append(csvField.getValue()).append(",");
        }
        result += newRow.substring(0, newRow.length() - 1) + "\n";
        return result;
    }

    private static String extractRepoAsString(String repoPath) {
        StringBuilder result = new StringBuilder();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(repoPath))) {
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error with load csv file");
        }
        return result.toString();
    }
}
