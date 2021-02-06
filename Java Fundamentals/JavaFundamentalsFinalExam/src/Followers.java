import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Followers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> likes = new TreeMap<>();
        Map<String, Integer> coments = new TreeMap<>();
        String input = scan.nextLine();
        while (!"Log out".equals(input)) {
            String[] tokens = input.split(":\\s+");
            String name = tokens[1];
            switch (tokens[0]) {
                case "New follower":
                    likes.putIfAbsent(name, 0);
                    coments.putIfAbsent(name, 0);
                    break;
                case "Like":
                    likes.putIfAbsent(name, 0);
                    coments.putIfAbsent(name, 0);
                    likes.put(name, likes.get(name) + Integer.parseInt(tokens[2]));
                    break;
                case "Comment":
                    likes.putIfAbsent(name, 0);
                    coments.putIfAbsent(name, 0);
                    coments.put(name, coments.get(name) + 1);
                    break;
                case "Blocked":
                    if (likes.containsKey(name)) {
                        likes.remove(name);
                        coments.remove(name);
                    } else {
                        System.out.printf("%s doesn't exist.%n", name);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        Map<String, Integer> sum = new TreeMap<>();
        for (Map.Entry<String, Integer> like : likes.entrySet()) {
            sum.put(like.getKey(), like.getValue() + coments.get(like.getKey()));
        }
        System.out.printf("%d followers%n", sum.size());
        sum
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue());
                });
    }
}
