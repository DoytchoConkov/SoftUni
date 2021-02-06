import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String coinsInTextFormat = scan.nextLine();
        double money = 0;
        while (!"Start".equals(coinsInTextFormat)) {
            double coins = Double.parseDouble(coinsInTextFormat) ;
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                money = money + coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins );
            }
            coinsInTextFormat = scan.nextLine();
        }
        String product = scan.nextLine();
        while (!"End".equals(product)) {
            switch (product) {
                case "Nuts":
                    if (money >= 2) {
                        money = money - 2;
                        System.out.println("Purchased " + product);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (money >= 0.7) {
                        money = money - 0.7;
                        System.out.println("Purchased " + product);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (money >= 1.5) {
                        money = money - 1.5;
                        System.out.println("Purchased " + product);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (money >= 0.8) {
                        money = money - 0.8;
                        System.out.println("Purchased " + product);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (money >= 1) {
                        money = money - 1;
                        System.out.println("Purchased " + product);
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }
            product = scan.nextLine();
        }
        System.out.printf("Change: %.2f%n", money );
    }
}
