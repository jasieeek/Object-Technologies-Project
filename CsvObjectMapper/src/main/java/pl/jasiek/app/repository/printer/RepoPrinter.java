package pl.jasiek.app.repository.printer;

import pl.jasiek.app.model.ItemDetails;
import pl.jasiek.app.repository.ItemRepository;

public class RepoPrinter {
    private static ItemDetails itemDetails;

    static {
        itemDetails = ItemDetails.getInstance();
    }

    public static void print(ItemRepository itemRepository) {
        printDataModelRow();
        itemRepository.findAll().forEach(System.out::println);
        System.out.println("\n--------------------End--------------------\n");
    }

    private static void printDataModelRow() {
        StringBuilder result = new StringBuilder();
        final String dashes = "--------------------";
        result.append("\n");
        result.append(dashes);
        result.append(itemDetails.getName());
        result.append(" Repository");
        result.append(dashes);
        result.append("\n\n");
        result.append("| ");
        result.append("ID | ");
        itemDetails.getFields().forEach((key, value) -> {
            result.append(key);
            result.append(" | ");
        });
        result.append("\n");
        System.out.println(result.toString());
    }
}
