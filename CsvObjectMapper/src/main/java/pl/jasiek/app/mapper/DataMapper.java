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
import java.util.Arrays;
import java.util.List;

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
        final int counter = itemDetails.getFields().size() + 1;

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_REPO_CSV))) {
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(COMA);
                Item item = new Item();
                item.setId(Integer.parseInt(splitLine[0]));
                item.setValues(new ArrayList<>(Arrays.asList(splitLine).subList(1, counter)));
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
