package OrderByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Worker> peoples = new ArrayList<>();
        while (!("End").equals(input)) {
            String[] token = input.split("\\s+");
            Worker people = new Worker(token[0], token[1], Integer.parseInt(token[2]));
            peoples.add(people);
            input = scan.nextLine();
        }
        peoples.stream()
                .sorted((p1, p2) -> p1.getYears() - p2.getYears())
                .forEach(p -> System.out.println(p));
    }


}
