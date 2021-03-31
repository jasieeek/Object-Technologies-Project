package pl.jasiek.app.mapper;

import pl.jasiek.app.model.ItemDetails;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class DataModelMapper extends CsvMapper {
    private static final String PATH_TO_DATA_MODEL = "src\\main\\resources\\dataModel.csv";

    private ItemDetails itemDetails;

    public DataModelMapper() {
        this.itemDetails = ItemDetails.getInstance();
    }

    @Override
    public void importData() {
        String line;
        Map<String, String> fields = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_DATA_MODEL))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] splitLine = line.split(COMA);
                if (splitLine.length == 1) {
                    itemDetails.setName(line);
                } else if (splitLine.length == 2) {
                    fields.put(splitLine[0], splitLine[1]);
                } else {
                    System.out.println("Wronga data model");
                    break;
                }

//                Optional<String> optionalName = Arrays.stream(dataModel).filter(element -> !element.contains(COMA)).findFirst();
//                optionalName.ifPresent(s -> itemDetails.setName(s));
//                Map<String, String> fields = new TreeMap<>();
//                Arrays.stream(dataModel)
//                        .filter(element -> element.contains(COMA))
//                        .forEach(element -> {
//                            String[] split = element.split(COMA);
//                            fields.put(split[0], split[1]);
//                        });
//                itemDetails.setFields(fields);
            }
            itemDetails.setFields(fields);
        } catch (IOException e) {
//            do logow
            System.out.println("Error with load csv file");
        }
    }

    @Override
    public void exportData() {

    }

//    public void saveCurrenciesData(Collection<Currency> currencies) {
//        Path path = Paths.get(PATH_TO_CURRENCIES_CSV);
//        ArrayList<String> listToSave = new ArrayList<>();
//        for (Currency currency : currencies) {
//            String s = currency.toStringCsv();
//            listToSave.add(s);
//        }
//        try {
//            Files.write(path, listToSave);
//        } catch (IOException e) {
//            System.out.println("Unable to save file currencies data :(");
//        }
//    }
}
