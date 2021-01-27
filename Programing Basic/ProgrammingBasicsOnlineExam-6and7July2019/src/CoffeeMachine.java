import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String drink = scan.nextLine();
        String sugar = scan.nextLine();
        int pieces = Integer.parseInt(scan.nextLine());
        double drinkPrice = 0;
        double totalDrinkPrice = 0;
        switch (drink) {
            case "Espresso":
                switch (sugar) {
                    case "Without":
                        drinkPrice = 0.9;
                        break;
                    case "Normal":
                        drinkPrice = 1;
                        break;
                    case "Extra":
                        drinkPrice = 1.2;
                        break;
                }
                break;
            case "Cappuccino":
                switch (sugar) {
                    case "Without":
                        drinkPrice = 1;
                        break;
                    case "Normal":
                        drinkPrice = 1.2;
                        break;
                    case "Extra":
                        drinkPrice = 1.6;
                        break;
                }
                break;
            case "Tea":
                switch (sugar) {
                    case "Without":
                        drinkPrice = 0.5;
                        break;
                    case "Normal":
                        drinkPrice = 0.6;
                        break;
                    case "Extra":
                        drinkPrice = 0.7;
                        break;
                }
                break;
        }
        totalDrinkPrice = drinkPrice * pieces;
        if (sugar.equals("Without")) {
            totalDrinkPrice = totalDrinkPrice * .65;
        }
        if (drink.equals("Espresso") && pieces >= 5) {
            totalDrinkPrice = totalDrinkPrice * .75;
        }
        if (totalDrinkPrice > 15) {
            totalDrinkPrice = totalDrinkPrice * .8;
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.", pieces, drink, totalDrinkPrice);
    }
}
