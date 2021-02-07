package StrategyPattern;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Person> personsByName = new ArrayList<>();
        List<Person> personsByAge = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            personsByName.add(person);
            personsByAge.add(person);
        }

        personsByName.stream().sorted(new PersonByName()).forEach(System.out::println);

        personsByAge.stream().sorted(new PersonByAge()).forEach(System.out::println);

    }
}
