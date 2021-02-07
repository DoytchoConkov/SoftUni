import java.util.*;

public class citiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            continents.putIfAbsent(token[0], new LinkedHashMap<>());
            continents.get(token[0]).putIfAbsent(token[1], new ArrayList<>());
            continents.get(token[0]).get(token[1]).add(token[2]);
        }

        continents.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + ":");
            e.getValue().entrySet().stream().forEach(country -> {
                System.out.printf("%s -> %s%n", country.getKey(), String.join(", ", country.getValue()));
            });
        });
    }
}
