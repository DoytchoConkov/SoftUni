package ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] peoples = scan.nextLine().split(";");
        String[] products = scan.nextLine().split(";");
        Map<String, Person> personMap = new LinkedHashMap<>();
        Map<String, Product> productsMap = new LinkedHashMap<>();
        for (String person : peoples) {
            String[] token = person.split("=");
            personMap.putIfAbsent(token[0], new Person(token[0], Double.parseDouble(token[1])));
        }
        for (String product : products) {
            String[] token = product.split("=");
            productsMap.putIfAbsent(token[0], new Product(token[0], Double.parseDouble(token[1])));
        }

        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            personMap.get(tokens[0]).buyProduct(productsMap.get(tokens[1]));
            input = scan.nextLine();
        }
        personMap.values()
                .forEach(System.out::println);
    }
}
