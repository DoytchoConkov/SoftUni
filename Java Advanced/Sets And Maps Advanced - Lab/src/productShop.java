import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class productShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Map<String, Double>> shops = new TreeMap<>();
        while (!input.equals("Revision")) {
            String[] token = input.split(", ");
            shops.putIfAbsent(token[0], new LinkedHashMap<>());
            shops.get(token[0]).putIfAbsent(token[1], 0.0);
            shops.get(token[0]).put(token[1], Double.parseDouble(token[2]));
            input = scan.nextLine();
        }

        shops.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + "->");
            e.getValue().entrySet().stream().forEach(prod -> {
                System.out.printf("Product: %s, Price: %.1f\n", prod.getKey(), prod.getValue());
            });
        });
    }
}
