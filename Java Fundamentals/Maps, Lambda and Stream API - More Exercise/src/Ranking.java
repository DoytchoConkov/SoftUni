import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(java.lang.System.in);
        Map<String, String> contest = new TreeMap<>();
        Map<String, Map<String, Integer>> users = new TreeMap<>();
        String input = scan.nextLine();
        while (!"end of contests".equals(input)) {
            String[] token = input.split(":");
            contest.put(token[0], token[1]);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!"end of submissions".equals(input)) {
            String[] token = input.split("=>");
            if (token[1].equals(contest.get(token[0]))) {
                int points = Integer.parseInt(token[3]);
                if (users.containsKey(token[2])) {
                    if (users.get(token[2]).containsKey(token[0])) {
                        if (users.get(token[2]).get(token[0]) < points) {
                            users.get(token[2]).put(token[0], points);
                        }
                    }else {
                        users.get(token[2]).put(token[0], points);
                    }
                } else {

                    users.put(token[2], new TreeMap<>());
                    users.get(token[2]).put(token[0], points);
                }
            }
            input = scan.nextLine();
        }
        int totalSum = 0;
        for (Map.Entry<String, Map<String, Integer>> user : users.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalSum) {
                totalSum = sum;
            }
        }

        for (Map.Entry<String, Map<String, Integer>> user : users.entrySet()) {
            if (user.getValue().values().stream().mapToInt(i -> i).sum() == totalSum) {
                System.out.printf("Best candidate is %s with total %d points.%n", user.getKey(), totalSum);
            }
        }

        System.out.println("Ranking:");
        users.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().
                    sorted((f, s) -> s.getValue() - f.getValue()).
                    forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });    }
}
