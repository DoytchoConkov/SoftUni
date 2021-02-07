package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] token = scan.nextLine().split("\\s+");
        Pizza pizza = new Pizza(token[1], Integer.parseInt(token[2]));
        token = scan.nextLine().split("\\s+");
        Dough dough = new Dough(token[1], token[2], Double.parseDouble(token[3]));
        pizza.setDough(dough);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            token = input.split("\\s+");
            Topping topping = new Topping(token[1], Double.parseDouble(token[2]));
            pizza.addTopping(topping);
            input = scan.nextLine();
        }
        System.out.println(pizza.getName() + " - " + pizza.getOverallCalories());
    }
}
