import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, String> forceUsers = new LinkedHashMap<>();
        while (!"Lumpawaroo".equals(input)) {
            String[] tokens = new String[2];
            if (input.contains(" | ")) {
                tokens = input.split(" \\| ");
                forceUsers.putIfAbsent(tokens[1], tokens[0]);
            } else {
                tokens = input.split(" -> ");
                System.out.printf("%s joins the %s side!%n", tokens[0], tokens[1]);
                if (forceUsers.get(tokens[0]) != null) {
                    forceUsers.put(tokens[0], tokens[1]);
                } else {
                    forceUsers.put(tokens[0], tokens[1]);
                }
            }
            input = scan.nextLine();
        }
        Map<String, List<String>> forceUsersList = new TreeMap<>();
        for (Map.Entry<String, String> user : forceUsers.entrySet()) {
            forceUsersList.putIfAbsent(user.getValue(), new ArrayList<>());
            forceUsersList.get(user.getValue()).add(user.getKey());
        }
        forceUsersList
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed())
                .forEach(e -> {
                    System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(person -> System.out.printf("! %s%n", person));
                });
    }
}
