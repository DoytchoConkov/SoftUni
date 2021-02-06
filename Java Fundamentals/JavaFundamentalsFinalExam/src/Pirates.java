import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Integer> cityPopulation = new TreeMap<>();
        Map<String, Integer> cityGold = new TreeMap<>();
        while (!"Sail".equals(input)) {
            String[] city = input.split("\\|\\|");
            cityPopulation.putIfAbsent(city[0], 0);
            cityPopulation.put(city[0], cityPopulation.get(city[0])+Integer.parseInt(city[1]));
            cityGold.putIfAbsent(city[0], 0);
            cityGold.put(city[0], cityGold.get(city[0])+Integer.parseInt(city[2]));
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("=>");
            String town = tokens[1];
            switch (tokens[0]) {
                case "Plunder":
                    int goldStolen = Integer.parseInt(tokens[3]);
                    int peoples = Integer.parseInt(tokens[2]);
                    cityGold.put(town, cityGold.get(town) - goldStolen);
                    cityPopulation.put(town, cityPopulation.get(town) - peoples);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, goldStolen, peoples);
                    if (cityGold.get(town) <= 0 || cityPopulation.get(town) <= 0) {
                        System.out.printf("%s has been wiped off the map!%n", town);
                        cityGold.remove(town);
                        cityPopulation.remove(town);
                    }
                    break;
                case "Prosper":
                    int gold = Integer.parseInt(tokens[2]);
                    if (gold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        cityGold.put(town, cityGold.get(town) + gold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n"
                                , gold, town, cityGold.get(town));
                    }
                    break;
            }
            input = scan.nextLine();
        }
        if (cityGold.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",cityGold.size());
            cityGold
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e -> {
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", e.getKey(), cityPopulation.get(e.getKey()), e.getValue());
                    });
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
