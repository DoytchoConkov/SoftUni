import java.util.*;

public class exam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Integer>> plants = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("<->");
            String plant = token[0];
            plants.put(plant, new ArrayList<>());
            plants.get(plant).add(Integer.parseInt(token[1]));

        }
        String input = scan.nextLine();
        while (!"Exhibition".equals(input)) {
            String[] command = input.split("\\s+");
            String plant = command[1];
            switch (command[0]) {
                case "Rate:":
                    if (plants.containsKey(plant)) {
                        plants.get(plant).add(Integer.parseInt(command[3]));
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update:":
                    if (plants.containsKey(plant)) {
                        plants.get(plant).add(0, Integer.parseInt(command[3]));
                    } else {
                        System.out.println("error");
                    }

                    break;
                case "Reset:":
                    if (plants.containsKey(plant)) {
                        int temp = plants.get(plant).get(0);
                        plants.get(plant).clear();
                        plants.get(plant).add(temp);
                    } else {
                        System.out.println("error");
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = p2.getValue().get(0) - p1.getValue().get(0);
                    if (result == 0) {
                        double averagee1 = (p1.getValue().stream().mapToInt(Integer::intValue).sum() - p1.getValue().get(0)) / (p1.getValue().size() - 1);
                        double averagee2 = (p2.getValue().stream().mapToInt(Integer::intValue).sum() - p2.getValue().get(0)) / (p2.getValue().size() - 1);
                        return Double.compare(averagee2, averagee1);
                    }
                    return result;

                })
                .forEach(e -> {
                    double averagee=0;
                    if (e.getValue().size() == 1) {
                        averagee = (e.getValue().stream().mapToInt(Integer::intValue).sum() - e.getValue().get(0)) / (e.getValue().size());

                    } else {
                         averagee = (e.getValue().stream().mapToInt(Integer::intValue).sum() - e.getValue().get(0)) / (e.getValue().size()-1);
                    }
                    System.out.println(String.format("- %s; Rarity: %d; Rating: %.2f", e.getKey(), e.getValue().get(0), averagee));
                });
    }
}
