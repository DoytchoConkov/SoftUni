import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double balance = Double.parseDouble(scan.nextLine());
        String game = scan.nextLine();
        double spent = 0;
        while (!"Game Time".equals(game)) {
            switch (game) {
                case "RoverWatch Origins Edition":
                case "OutFall 4":
                    if (balance >= 39.99) {
                        balance = balance - 39.99;
                        spent = spent + 39.99;
                        System.out.printf("Bought %s%n",game);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "CS: OG":
                    if (balance >= 15.99) {
                        balance = balance - 15.99;
                        spent = spent + 15.99;
                        System.out.printf("Bought %s%n",game);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Zplinter Zell":
                    if (balance >= 19.99) {
                        balance = balance - 19.99;
                        spent = spent + 19.99;
                        System.out.printf("Bought %s%n",game);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Honored 2":
                    if (balance >= 59.99) {
                        balance = balance - 59.99;
                        spent = spent + 59.99;
                        System.out.printf("Bought %s%n",game);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch":
                    if (balance >= 29.99) {
                        balance = balance - 29.99;
                        spent = spent + 29.99;
                        System.out.printf("Bought %s%n",game);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                default:
                    System.out.println("Not Found");
            }
            if (balance == 0) {
                System.out.println("Out of money!");
                break;
            }
            game = scan.nextLine();
        }
        if (balance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, balance);
        }
    }
}
