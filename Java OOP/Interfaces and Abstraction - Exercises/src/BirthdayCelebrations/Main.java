package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Birthable> animals = new ArrayList<>();
        while (!input.equals("End")) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "Citizen":
                    animals.add(new Citizen(token[1], Integer.parseInt(token[2]), token[3], token[4]));
                    break;
                case "Pet":
                    animals.add(new Pet(token[1], token[2]));
                    break;
            }

            input = scan.nextLine();
        }
        input = scan.nextLine();
        for (Birthable animal : animals) {
            if (animal.getBirthDate().endsWith(input)) {
                System.out.println(animal.getBirthDate());
            }
        }
    }
}
