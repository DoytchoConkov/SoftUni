import java.util.*;

public class NikuldensMeals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, List<String>> guests = new TreeMap<>();
        int unlikeMealCnt = 0;
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String name = tokens[1];
            String meal = tokens[2];
            switch (command) {
                case "Like":
                    guests.putIfAbsent(name, new ArrayList<>());
                    if (!guests.get(name).contains(meal)) {
                        guests.get(name).add(meal);
                    }
                    break;
                case "Unlike":
                    if (guests.containsKey(name)) {
                        if (guests.get(name).contains(meal)) {
                            guests.get(name).remove(meal);
                            System.out.printf("%s doesn't like the %s.%n", name, meal);
                            unlikeMealCnt++;
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", name, meal);
                        }
                    } else {
                        System.out.printf("%s is not at the party.%n", name);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        guests
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    return e2.getValue().size() - e1.getValue().size();
                })
                .forEach(e -> {
                    System.out.printf("%s: ", e.getKey());
                    System.out.println(e.getValue().toString().replaceAll("[\\[\\]]", ""));
                });

        System.out.printf("Unliked meals: %d", unlikeMealCnt);
    }
}
