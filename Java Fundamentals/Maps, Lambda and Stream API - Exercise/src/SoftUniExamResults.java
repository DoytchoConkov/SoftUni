import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> students = new TreeMap<>();
        Map<String, Integer> language = new TreeMap<>();
        String input = scan.nextLine();
        while (!"exam finished".equals(input)) {
            String[] tokens = input.split("-");
            if (tokens.length > 2) {
                students.put(tokens[0], Integer.parseInt(tokens[2]));
                language.putIfAbsent(tokens[1], 0);
                language.put(tokens[1], language.get(tokens[1]) + 1);
            } else {
                students.remove(tokens[0]);
            }
            input = scan.nextLine();
        }
        System.out.println("Results:");
        students
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> {
                    System.out.printf("%s | %d%n", e.getKey(), e.getValue());
                });
        System.out.println("Submissions:");
        language
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> {
                    System.out.printf("%s - %d%n", e.getKey(), e.getValue());
                });
    }
}