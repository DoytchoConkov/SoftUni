import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> persons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split(", ");
            persons.put(token[0], Integer.parseInt(token[1]));
        }

        String condition = scan.nextLine();
        int age = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        printFilteredStudent(persons, tester, printer);
    }

    private static void printFilteredStudent(Map<String, Integer> persons, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String, Integer> person : persons.entrySet()) {

            if (tester.test(persons.get(person.getKey()))) {
                printer.accept(person);
            }

        }
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        switch (format) {
            case "name age":
                printer = person -> System.out.printf("%s - %d%n",
                        person.getKey(), person.getValue());
                break;
            case "name":
                printer = person -> System.out.printf("%s%n",
                        person.getKey());
                break;
            case "age":
                printer = person -> System.out.printf("%d%n",
                        person.getValue());
                break;
        }
        return printer;
    }


    private static Predicate<Integer> createTester(String condition, int age) {
        if (condition.equals("younger")) {
            return e -> e <= age;
        } else {
            return e -> e >= age;
        }
    }
}
