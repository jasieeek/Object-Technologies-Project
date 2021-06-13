package pl.jasiek.app.csv.mapper.helper;

import pl.jasiek.app.csv.annotation.CsvID;
import pl.jasiek.app.csv.annotation.ManyToOne;
import pl.jasiek.app.csv.structure.CsvEntity;
import pl.jasiek.app.csv.structure.CsvField;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CsvClassHelper {
    public static CsvEntity extractCsvEntity(String className) {
        CsvEntity csvEntity = new CsvEntity();
        csvEntity.setName(className);
        csvEntity.setFields(extractCsvFields(className));
        return csvEntity;
    }

    private static List<CsvField> extractCsvFields(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            List<CsvField> result = new ArrayList<>();

            for (Field field: clazz.getDeclaredFields()) {
                CsvField tmpCsvField = new CsvField();
                tmpCsvField.setName(field.getName());
                tmpCsvField.setPrimaryKey(isFieldPrimaryKey(field));
                tmpCsvField.setForeignKey(isFieldForeignKey(field));
            }
            return result;
        } catch (ClassNotFoundException e) {
            System.out.println(className + " hasn't been found!");
        }
        return null;
    }

    private static boolean isFieldForeignKey(Field field) {
//        do obslugi reszta relacji
        if (field.getAnnotation(ManyToOne.class) != null) {
            return true;
        }
        return false;
    }

    private static boolean isFieldPrimaryKey(Field field) {
        return field.getAnnotation(CsvID.class) != null;
    }
}
