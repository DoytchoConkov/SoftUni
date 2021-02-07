package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Mammal> mammal = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            Mammal currentMammal;
            String[] token = input.split("\\s+");
            if (token[0].equals("Cat")) {
                currentMammal = new Cat(token[1], "Cat", Double.parseDouble(token[2]), token[3], token[4]);
            } else if (token[0].equals("Tiger")) {
                currentMammal = new Tiger(token[1], "Tiger", Double.parseDouble(token[2]), token[3]);
            } else if (token[0].equals("Zebra")) {
                currentMammal = new Zebra(token[1], "Zebra", Double.parseDouble(token[2]), token[3]);
            } else {
                currentMammal = new Mouse(token[1], "Mouse", Double.parseDouble(token[2]), token[3]);
            }
            token = scan.nextLine().split("\\s+");
            String foodType = token[0];
            int foodQuantity = Integer.parseInt(token[1]);
            Food food;
            if (foodType.equals("Vegetable")) {
                food = new Vegetable(foodQuantity);
            } else {
                food = new Meat(foodQuantity);
            }
            currentMammal.makeSound();
            currentMammal.eat(food);
            mammal.add(currentMammal);
            input = scan.nextLine();
        }
        mammal.forEach(System.out::println);
    }
}
