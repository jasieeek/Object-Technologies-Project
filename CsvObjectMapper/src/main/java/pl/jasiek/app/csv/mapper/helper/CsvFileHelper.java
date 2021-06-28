package pl.jasiek.app.csv.mapper.helper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class CsvFileHelper {
//    to think about generic paths
    private static final String MODEL_PATH = "src\\main\\java\\pl\\jasiek\\app\\model";
    private static final String REPOSITORY_PATH = "src\\main\\resources\\repo";
    private static final File repoDir = new File(REPOSITORY_PATH);

    public static String extractClassName(File file) {
        String fileName = file.getName();
        int indexOfDot = fileName.indexOf('.');
        return "pl.jasiek.app.model." + fileName.substring(0, indexOfDot);
    }

    public static String extractFileName(File file) {
        String fileName = file.getName();
        int indexOf = fileName.indexOf('.');
        return fileName.substring(0, indexOf) + ".csv";
    }

    public static File[] getModelFiles() {
        File modelDir = new File(MODEL_PATH);
        return modelDir.listFiles();
    }

    public static boolean isExistRepository(String name) {
        File[] repos = repoDir.listFiles();
        boolean result = false;

        if (repos != null) {
            result = Arrays.stream(repos)
                    .anyMatch(repo -> repo.getName()
                            .toLowerCase()
                            .equals(name.toLowerCase()
                            ));
        }
        return result;
    }

    public static void createRepo(String name, String fieldNames) {
        try {
            System.out.println("Creating repository file for " + name + "...");
            Files.createFile(Paths.get(REPOSITORY_PATH + "\\" + name.toLowerCase()));
            PrintWriter pw = new PrintWriter(REPOSITORY_PATH + "\\" + name.toLowerCase());
            pw.println(fieldNames.trim());
            pw.flush();
            pw.close();
            System.out.println("Creating repository file for " + name + " has been finished!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
