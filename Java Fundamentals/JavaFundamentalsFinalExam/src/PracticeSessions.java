import java.util.*;

public class PracticeSessions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> roads = new TreeMap<>();
        String input = scan.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("->");
            switch (tokens[0]) {
                case "Add":
                    roads.putIfAbsent(tokens[1], new ArrayList<>());
                    roads.get(tokens[1]).add(tokens[2]);
                    break;
                case "Move":
                    if (roads.get(tokens[1]).contains(tokens[2])) {
                        roads.putIfAbsent(tokens[3], new ArrayList<>());
                        roads.get(tokens[1]).remove(tokens[2]);
                        roads.get(tokens[3]).add(tokens[2]);
                    }
                    break;
                case "Close":
                    if (roads.containsKey(tokens[1])) {
                        roads.remove(tokens[1]);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println("Practice sessions:");
        roads
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    return e2.getValue().size() - e1.getValue().size();
                })
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue().stream().forEach(racer -> {
                        System.out.printf("++%s%n", racer);
                    });
                });
    }
}
