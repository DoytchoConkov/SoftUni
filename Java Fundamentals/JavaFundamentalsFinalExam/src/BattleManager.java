import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Integer> health = new TreeMap<>();
        Map<String, Integer> energy = new TreeMap<>();
        while (!"Results".equals(input)) {
            String[] tokens = input.split(":");
            switch (tokens[0]) {
                case "Add":
                    if (health.containsKey(tokens[1])) {
                        health.put(tokens[1], health.get(tokens[1]) + Integer.parseInt(tokens[2]));
                    } else {
                        health.put(tokens[1], Integer.parseInt(tokens[2]));
                        energy.put(tokens[1], Integer.parseInt(tokens[3]));
                    }
                    break;
                case "Attack":
                    if (health.containsKey(tokens[1]) && health.containsKey(tokens[2])) {
                        health.put(tokens[2], health.get(tokens[2]) - Integer.parseInt(tokens[3]));
                        if (health.get(tokens[2]) <= 0) {
                            System.out.printf("%s was disqualified!%n", tokens[2]);
                            health.remove(tokens[2]);
                            energy.remove(tokens[2]);
                        }
                        energy.put(tokens[1], energy.get(tokens[1]) - 1);
                        if (energy.get(tokens[1]) == 0) {
                            System.out.printf("%s was disqualified!%n", tokens[1]);
                            health.remove(tokens[1]);
                            energy.remove(tokens[1]);
                        }
                    }
                    break;
                case "Delete":
                    if ("All".equals(tokens[1])) {
                        health.clear();
                        energy.clear();
                    } else {
                        health.remove(tokens[1]);
                        energy.remove(tokens[1]);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.printf("People count: %d%n", health.size());
        health
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> {
                    System.out.printf("%s - %d - %d%n", entry.getKey(), entry.getValue(), energy.get(entry.getKey()));
                });
    }
}
