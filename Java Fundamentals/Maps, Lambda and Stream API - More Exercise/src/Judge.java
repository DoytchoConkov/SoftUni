import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Judge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Integer>> judge = new LinkedHashMap<>();
        Map<String, Integer> students = new TreeMap<>();
        String input = scan.nextLine();
        while (!"no more time".equals(input)) {
            String[] token = input.split(" -> ");
            judge.putIfAbsent(token[1], new TreeMap<>());
            if (judge.get(token[1]).containsKey(token[0])) {
                students.put(token[0], students.get(token[0]) + Integer.parseInt(token[2]) - judge.get(token[1]).get(token[0]));
            } else {
                students.putIfAbsent(token[0], 0);
                students.put(token[0], students.get(token[0]) + Integer.parseInt(token[2]));
            }
            judge.get(token[1]).putIfAbsent(token[0], 0);
            if (judge.get(token[1]).get(token[0]) < Integer.parseInt(token[2])) {
                judge.get(token[1]).put(token[0], Integer.parseInt(token[2]));
            }

            input = scan.nextLine();
        }
        judge
                .forEach((k, v) -> {
                    System.out.printf("%s: %d participants%n", k, v.size());
                    final int[] i = {1};
                    v
                            .entrySet()
                            .stream()
                            .sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue()))
                            .forEach(e -> {
                                System.out.printf("%d. %s <::> %d%n", i[0], e.getKey(), e.getValue());
                                i[0]++;
                            });
                });
        System.out.println("Individual standings:");
        final int[] j = {1};
        students
                .entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .forEach(e -> {
                    System.out.println(String.format("%d. %s -> %d", j[0], e.getKey(), e.getValue())
                    );
                    j[0]++;
                });
    }
}
