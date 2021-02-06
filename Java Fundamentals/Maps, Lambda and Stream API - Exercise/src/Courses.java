import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            String[] token = input.split(" : ");
            courses.putIfAbsent(token[0], new ArrayList<>());
            List<String> newList = courses.get(token[0]);
            newList.add(token[1]);
            courses.put(token[0], newList);
            input = scan.nextLine();
        }
        courses
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    return e2.getValue().size() - e1.getValue().size();
                })
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().sort((n1, n2) -> n1.compareTo(n2));
                    for (String name : e.getValue()) {
                        System.out.printf("-- %s%n", name);
                    }
                });
    }
}
