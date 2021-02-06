import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> employers = new TreeMap<>();
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" -> ");
            employers.putIfAbsent(tokens[0], new ArrayList<>());
            if (!employers.get(tokens[0]).contains(tokens[1])) {
                employers.get(tokens[0]).add(tokens[1]);
            }
            input = scan.nextLine();
        }
        employers
                .entrySet()
                .stream()
                .forEach(e -> {
                    System.out.printf("%s%n", e.getKey());
                    e.getValue()
                            .stream()
                            .forEach(id -> {
                                System.out.printf("-- %s%n", id);
                            });
                });
    }
}
