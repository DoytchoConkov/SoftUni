import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> users = new TreeMap<>();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            switch (tokens[0]) {
                case "Add":
                    if (users.containsKey(tokens[1])) {
                        System.out.printf("%s is already registered%n", tokens[1]);
                    } else {
                        users.put(tokens[1], new ArrayList<>());
                    }
                    break;
                case "Send":
                    users.get(tokens[1]).add(tokens[2]);
                    break;
                case "Delete":
                    if (users.containsKey(tokens[1])) {
                        users.remove(tokens[1]);
                    } else {
                        System.out.printf("%s not found!%n", tokens[1]);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Users count: %d%n", users.size());
        users.entrySet().stream().sorted((e1, e2) -> {
            return e2.getValue().size() - e1.getValue().size();
        })
                .forEach(n -> {
                    System.out.printf("%s%n", n.getKey());
                    n.getValue().stream().forEach(mail -> {
                        System.out.printf(" - %s%n", mail);
                    });
                    System.out.println();
                });
    }
}
