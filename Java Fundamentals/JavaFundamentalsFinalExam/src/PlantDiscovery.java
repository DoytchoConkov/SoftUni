import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> plants = new LinkedHashMap<>();
        Map<String, List<Integer>> plantsRating = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("<->");
            plants.put(token[0], Integer.parseInt(token[1]));
            plantsRating.put(token[0], new ArrayList<>());
        }
        String input = scan.nextLine();
        while (!"Exhibition".equals(input)) {
            String[] command = input.split("\\s+");
            String plant = command[1];
            switch (command[0]) {
                case "Rate:":
                    if (plantsRating.containsKey(plant)) {
                        plantsRating.get(plant).add(Integer.parseInt(command[3]));
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update:":
                    if (plants.containsKey(plant)) {
                        plants.put(plant, Integer.parseInt(command[3]));
                    } else {
                        System.out.println("error");
                    }

                    break;
                case "Reset:":
                    if (plantsRating.containsKey(plant)) {
                        plantsRating.get(plant).clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
            }

            input = scan.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plants.entrySet().stream().sorted((p1, p2) -> {
            int result = p2.getValue() - p1.getValue();
            if (result == 0) {
                double average1 = plantsRating.get(p1.getKey()).stream().mapToInt(Integer::intValue).average().orElse(0);
                double average2 = plantsRating.get(p2.getKey()).stream().mapToInt(Integer::intValue).average().orElse(0);
                return Double.compare(average2, average1);
            }

            return result;
        })
                .forEach(p ->
                        System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", p.getKey(), p.getValue(), plantsRating.get(p.getKey()).stream().mapToInt(Integer::intValue).average().orElse(0)));
    }
}
