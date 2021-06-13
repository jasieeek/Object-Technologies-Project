package pl.jasiek.app.csv.mapper.initializer;

import pl.jasiek.app.csv.mapper.helper.CsvFileHelper;
import pl.jasiek.app.csv.mapper.helper.annotation.ManyToManyHelper;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class CsvRepoInitializer {

    public static void init() {
        // 1. Iterate whole model catalog: pl.jasiek.app.model
        if (CsvFileHelper.getModelFiles() != null) {
            Arrays.stream(CsvFileHelper.getModelFiles()).forEach(CsvRepoInitializer::createRepoIfNotExist);
        }
    }

    private static void createRepoIfNotExist(File file) {
        // 2. For each file: Extract all necessary data - class name and fields (with annotations), file name
        String tmpClassName = CsvFileHelper.extractClassName(file);
        String tmpFileName = CsvFileHelper.extractFileName(file);
        // 3. Check if the repository exist
        if (CsvFileHelper.isExistRepository(tmpFileName)) {
            System.out.println(tmpFileName + " repository exist!");
        } else {
            // 4. If it doesn't then extract field names as string from model class
            String fileNames = extractFieldsAsString(tmpClassName);
            CsvFileHelper.createRepo(tmpFileName, fileNames);
        }
    }

    //    to correct
    private static String extractFieldsAsString(String fileName) {
        StringBuilder fieldsString = new StringBuilder();
        try {
            Class<?> clazz = Class.forName(fileName);
            for (Field field : clazz.getDeclaredFields()) {
                String csvFieldName = convertField(clazz, field);
                if (csvFieldName != null) {
                    fieldsString.append(csvFieldName);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fieldsString.substring(0, fieldsString.length() - 1) + "\n";
    }

    private static String convertField(Class clazz, Field field) {
        for (Annotation annotation : field.getAnnotations()) {
            if (annotation.annotationType().toString().equals("interface pl.jasiek.app.csv.annotation.ManyToOne")) {
                return "@" + field.getName() + ",";
            } else if (annotation.annotationType().toString().equals("interface pl.jasiek.app.csv.annotation.ManyToMany")) {
                ManyToManyHelper.convertAnnotation(clazz, field);
                return null;
            }
        }
        return field.getName() + ",";
    }
}
