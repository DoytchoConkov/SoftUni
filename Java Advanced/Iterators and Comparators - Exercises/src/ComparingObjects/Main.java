package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        String input = scan.nextLine();

        while (!input.equals("END")) {
            String[] token = input.split("\\s+");
            Person person = new Person(token[0], Integer.parseInt(token[1]), token[2]);
            persons.add(person);
            input = scan.nextLine();
        }

        int n = Integer.parseInt(scan.nextLine());
        Person currentPerson = persons.get(n-1);

        int equalPersons = 0;
        int notEqualPersons = 0;
        int totalPersons = persons.size();

        for (Person person : persons) {
            if (person.compareTo(currentPerson) > 0) {
                equalPersons++;
            } else {
                notEqualPersons++;
            }
        }
        if (notEqualPersons != totalPersons) {
            System.out.println(equalPersons + " " + notEqualPersons + " " + totalPersons);
        } else {
            System.out.println("No matches");
        }
    }
}
