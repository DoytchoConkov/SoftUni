import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Integer>> gamers = new TreeMap<>();

        String input = scan.nextLine();
        while (!"Season end".equals(input)) {
            if (input.contains(" -> ")) {
                String[] tokens = input.split(" -> ");
                gamers.putIfAbsent(tokens[0], new TreeMap<>());
                gamers.get(tokens[0]).put(tokens[1], Integer.parseInt(tokens[2]));
            } else {
                String[] tokens = input.split(" vs ");
                if (gamers.containsKey(tokens[0]) && gamers.containsKey(tokens[1])) {
                    Map<String, Integer> gamer = gamers.get(tokens[0]);
                    for (Map.Entry<String, Integer> temp : gamer.entrySet()) {
                        if (gamers.get(tokens[1]).containsKey(temp.getKey())) {
                            if (temp.getValue() > gamers.get(tokens[1]).get(temp.getKey())) {
                                gamers.remove(tokens[1]);
                            } else {
                                gamers.remove(tokens[0]);
                            }
                        }
                    }
                }
            }

            input = scan.nextLine();
        }
        gamers
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    e1.getValue().entrySet().stream().mapToInt(i -> i.getValue()).sum();
                    return e2.getValue().entrySet().stream().mapToInt(i -> i.getValue()).sum() - e1.getValue().entrySet().stream().mapToInt(i -> i.getValue()).sum();
                })
                .forEach(e -> {
                    System.out.printf("%s: %d skill%n", e.getKey(), e.getValue().entrySet().stream().mapToInt(i -> i.getValue()).sum());
                    e.getValue()
                            .entrySet()
                            .stream()
                            .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(p -> {
                                System.out.printf("- %s <::> %d%n", p.getKey(), p.getValue());
                            });
                });
    }
}
