package Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Person> persons = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String[] token = input.split("\\s+");
            if (token[1].equals("car")) {
                persons.putIfAbsent(token[0], new Person(token[0]));
                Car car = new Car(token[2], Integer.parseInt(token[3]));
                persons.get(token[0]).setCar(car);
            } else if (token[1].equals("company")) {
                persons.putIfAbsent(token[0], new Person(token[0]));
                Company company = new Company(token[2], token[3], Double.parseDouble(token[4]));
                persons.get(token[0]).setCompany(company);
            } else if (token[1].equals("children")) {
                persons.putIfAbsent(token[0], new Person(token[0]));
                Children children = new Children(token[2], token[3]);
                persons.get(token[0]).getChildrens().add(children);
            } else if (token[1].equals("parents")) {
                persons.putIfAbsent(token[0], new Person(token[0]));
                Parent parent = new Parent(token[2], token[3]);
                persons.get(token[0]).getParents().add(parent);
            } else if (token[1].equals("pokemon")) {
                persons.putIfAbsent(token[0], new Person(token[0]));
                Pokemon pokemon = new Pokemon(token[2], token[3]);
                persons.get(token[0]).getPokemon().add(pokemon);
            }
            input = scan.nextLine();
        }
        input = scan.nextLine();
        Person person = persons.get(input);
        System.out.println(input);
        System.out.println("Company:");
        if (person.getCompany().getCompanyName() != "") {
            System.out.printf("%s %s %.2f%n", person.getCompany().getCompanyName(), person.getCompany().getCompanyDepartment(), person.getCompany().getSalary());
        }
        System.out.println("Car:");
        if (person.getCar().getModel() != "") {
            System.out.printf("%s %d%n", person.getCar().getModel(), person.getCar().getSpeed());
        }

        System.out.println("Pokemon:");
        if (person.getPokemon().size() > 0) {
            person.getPokemon().stream().forEach(p -> System.out.printf("%s %s%n", p.getName(), p.getType()));
        }

        System.out.println("Parents:");
        if (person.getParents().size() > 0) {
            person.getParents().stream().forEach(p -> System.out.printf("%s %s%n", p.getName(), p.getBirthday()));
        }

        System.out.println("Children:");
        if (person.getChildrens().size() > 0) {
            person.getChildrens().stream().forEach(p -> System.out.printf("%s %s%n", p.getName(), p.getBirthday()));
        }

    }
}
