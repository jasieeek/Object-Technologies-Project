package pl.jasiek.app.mapper;

import pl.jasiek.app.model.ItemDetails;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataModelMapper {
    private static final String PATH_TO_DATA_MODEL = "src\\main\\resources\\dataModel.csv";
    private static final String COMA = ",";
    private ItemDetails itemDetails;

    public DataModelMapper() {
        this.itemDetails = ItemDetails.getInstance();
    }

    public void importDataModel() {
        String line;
        Map<String, String> fields = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_DATA_MODEL))) {
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(COMA);
                if (splitLine.length == 1) {
                    itemDetails.setName(line);
                } else if (splitLine.length == 2) {
                    fields.put(splitLine[0], splitLine[1]);
                } else {
                    System.out.println("Wrong data model");
                    break;
                }
            }
            itemDetails.setFields(fields);
        } catch (IOException e) {
//            do logow
            System.out.println("Error with load csv file");
        }
    }
}
