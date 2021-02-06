import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Double> productPrice = new LinkedHashMap<>();
        Map<String, Integer> productQuantity = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"buy".equals(input)) {
            String[] token = input.split("\\s+");
            String product = token[0];
            double price = Double.parseDouble(token[1]);
            int quantity = Integer.parseInt(token[2]);
            productPrice.put(product, price);
            productQuantity.putIfAbsent(product, 0);
            int newQuantity = productQuantity.get(product) + quantity;
            productQuantity.put(product, newQuantity);
            input = scan.nextLine();
        }
        productPrice
                .forEach((k, v) -> {
                    System.out.printf("%s -> %.2f%n", k, v * productQuantity.get(k));
                });
    }
}
