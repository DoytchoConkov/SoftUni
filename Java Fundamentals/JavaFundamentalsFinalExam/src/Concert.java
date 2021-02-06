import java.io.OutputStream;
import java.util.*;

public class Concert {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> bands = new LinkedHashMap<>();
        Map<String, Integer> duration = new TreeMap<>();
        String input = scan.nextLine();
        while (!"start of concert".equals(input)) {
            String[] tokens = input.split("; ");
            switch (tokens[0]) {
                case "Add":
                    bands.putIfAbsent(tokens[1], new ArrayList<>());
                    String[] members = tokens[2].split(", ");
                    duration.putIfAbsent(tokens[1], 0);
                    for (String member : members) {
                        if (!bands.get(tokens[1]).contains(member)) {
                            bands.get(tokens[1]).add(member);
                        }
                    }
                    break;
                case "Play":
                    duration.putIfAbsent(tokens[1], 0);
                    duration.put(tokens[1], duration.get(tokens[1]) + Integer.parseInt(tokens[2]));
                    break;
            }
            input = scan.nextLine();
        }
        int sum = duration.values().stream().mapToInt(i -> i).sum();
        System.out.printf("Total time: %d%n", sum);
        duration.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    System.out.printf("%s -> %d%n", e.getKey(), e.getValue());
                });
        input = scan.nextLine();
        System.out.printf("%s%n", input);
        bands.get(input).stream().forEach(m -> {
            System.out.printf("=> %s%n", m);
        });
    }
}
