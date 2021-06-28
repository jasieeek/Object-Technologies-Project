package pl.jasiek.app.csv.mapper.helper.annotation;

import pl.jasiek.app.csv.annotation.ManyToMany;
import pl.jasiek.app.csv.mapper.helper.CsvFileHelper;

import java.lang.reflect.Field;

public class ManyToManyHelper {
    private final static String COMMA = ",";
    private final static String DOT = ".";

    public static void convertAnnotation(Class clazz, Field field) {
        String intermediateTableName = field.getAnnotation(ManyToMany.class).intermediateTable();
        String relationshipCsvClassName = field.getAnnotation(ManyToMany.class).relationshipCsvClass();

        String fields = generateFieldsAsString(clazz, relationshipCsvClassName);
        CsvFileHelper.createRepo(intermediateTableName + ".csv", fields);
    }

    private static String generateFieldsAsString(Class clazz, String relationshipCsvClassName) {
        String result = "@id" + extractClassName(clazz.getName()) + COMMA;
        result += "@id" + extractClassName(relationshipCsvClassName);

        return result;
    }

    private static String extractClassName(String fullClassName) {
        return fullClassName.substring(fullClassName.lastIndexOf(DOT) + 1);
    }
}
