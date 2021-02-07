import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> guests = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scan.nextLine();

        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");

            List<String> temp = new ArrayList<>();

            Predicate<String> predic = createPredicator(tokens[1], tokens[2]);

            for (String guest : guests) {
                if (predic.test(guest)) {
                    temp.add(guest);
                }
            }
            if (tokens[0].equals("Remove")) {
                guests.removeAll(temp);
            } else {
                guests.addAll(temp);
            }

            input = scan.nextLine();
        }
        if (guests.size() > 0) {
            System.out.println(guests
                    .stream()
                    .sorted(Comparator.naturalOrder())
                    .collect(Collectors.joining(", ")) + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }

    }

    private static Predicate<String> createPredicator(String command, String param) {
        Predicate<String> check = null;

        switch (command) {
            case "StartsWith":
                return check = str -> str.startsWith(param);
            case "EndsWith":
                return check = str -> str.endsWith(param);
            case "Length":
                return check = str -> str.length() == Integer.parseInt(param);
            default:
                return null;
        }
    }
}
