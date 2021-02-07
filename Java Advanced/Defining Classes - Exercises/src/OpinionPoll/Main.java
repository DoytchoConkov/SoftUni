package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] token = scan.nextLine().split("\\s+");
            int years = Integer.parseInt(token[1]);
            String name = token[0];
            if (years > 30) {
                Person person = new Person(name, years);
                persons.add(person);
            }
        }
        persons.stream().sorted((a, b) -> a.getName().compareTo(b.getName())).forEach(e -> System.out.printf("%s - %d%n", e.getName(), e.getAge()));
    }
}
