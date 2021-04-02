package pl.jasiek.app.mapper;

import pl.jasiek.app.model.Item;
import pl.jasiek.app.model.ItemDetails;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataMapper {
    private static final String PATH_TO_REPO_CSV = "src\\main\\resources\\repository.csv";
    private static final String COMA = ",";
    private ItemDetails itemDetails;

    public DataMapper() {
        this.itemDetails = ItemDetails.getInstance();
    }

    public List<Item> importItemList() {
        List<Item> result = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_REPO_CSV))) {
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(COMA);
                Item item = new Item();
                item.setId(Integer.parseInt(splitLine[0]));
                Map<String, String> fields = new TreeMap<>();
                List<String> fieldNames = new ArrayList<>(itemDetails.getFields().keySet());
                for (int i = 0; i < fieldNames.size(); i++) {
                    fields.put(fieldNames.get(i), splitLine[i + 1]);
                }
                item.setFields(fields);
                result.add(item);
            }
        } catch (IOException e) {
//            do logow
            System.out.println("Error with load csv file");
        }
        return result;
    }

    public void exportItemList(List<Item> items) {
        Path path = Paths.get(PATH_TO_REPO_CSV);
        ArrayList<String> listToSave = new ArrayList<>();
        for (Item item : items) {
            String s = item.toCsvString();
            listToSave.add(s);
        }
        try {
            Files.write(path, listToSave);
        } catch (IOException e) {
            System.out.println("Unable to save file exchanges data :(");
        }
    }
}
