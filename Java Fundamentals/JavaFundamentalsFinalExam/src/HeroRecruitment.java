import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List> heroes = new TreeMap<>();
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Enroll":
                    if (heroes.containsKey(tokens[1])) {
                        System.out.printf("%s is already enrolled.%n", tokens[1]);
                    } else {
                        heroes.put(tokens[1], new ArrayList());
                    }
                    break;
                case "Learn":
                    if (!heroes.containsKey(tokens[1])) {
                        System.out.printf("%s doesn't exist.%n", tokens[1]);
                    } else if (heroes.get(tokens[1]).contains(tokens[2])) {
                        System.out.printf("%s has already learnt %s.%n", tokens[1], tokens[2]);
                    } else {
                        heroes.get(tokens[1]).add(tokens[2]);
                    }
                    break;
                case "Unlearn":
                    if (!heroes.containsKey(tokens[1])) {
                        System.out.printf("%s doesn't exist.%n", tokens[1]);
                    } else if (heroes.get(tokens[1]).contains(tokens[2])) {
                        heroes.get(tokens[1]).remove(tokens[2]);
                    } else {
                        System.out.printf("%s doesn't know %s.%n", tokens[1], tokens[2]);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        System.out.println("Heroes:");
        heroes.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    return e2.getValue().size() - e1.getValue().size();
                })
                .forEach(e -> {
                    System.out.printf("== %s: ", e.getKey());
                    System.out.println(e.getValue().toString().replaceAll("[\\[\\]]", ""));
                });
    }
}
