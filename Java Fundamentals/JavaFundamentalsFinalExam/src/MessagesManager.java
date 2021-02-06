import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> senders = new TreeMap<>();
        Map<String, Integer> receivers = new TreeMap<>();
        String input = scan.nextLine();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("=");
            switch (tokens[0]) {
                case "Add":
                    senders.putIfAbsent(tokens[1], Integer.parseInt(tokens[2]));
                    receivers.putIfAbsent(tokens[1], Integer.parseInt(tokens[3]));
                    break;
                case "Message":
                    if (senders.containsKey(tokens[1]) && senders.containsKey(tokens[2])) {
                        senders.put(tokens[1], senders.get(tokens[1]) + 1);
                        receivers.put(tokens[2], receivers.get(tokens[2]) + 1);
                        if (senders.get(tokens[1]) + receivers.get(tokens[1]) == n) {
                            System.out.printf("%s reached the capacity!%n", tokens[1]);
                            senders.remove(tokens[1]);
                            receivers.remove(tokens[1]);
                        }
                        if (senders.get(tokens[2]) + receivers.get(tokens[2]) == n) {
                            System.out.printf("%s reached the capacity!%n", tokens[2]);
                            senders.remove(tokens[2]);
                            receivers.remove(tokens[2]);
                        }
                    }
                    break;
                case "Empty":
                    if ("All".equals(tokens[1])) {
                        senders.clear();
                        receivers.clear();
                    } else {
                        senders.remove(tokens[1]);
                        receivers.remove(tokens[1]);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Users count: %d%n", senders.size());
        receivers
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
            System.out.printf("%s - %d%n", e.getKey(), e.getValue() + senders.get(e.getKey()));
        });
    }
}
