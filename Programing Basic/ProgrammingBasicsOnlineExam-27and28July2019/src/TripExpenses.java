import java.util.Scanner;

public class TripExpenses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        double money = 0;
        for (int i = 0; i < days; i++) {
            int products = 0;
            money = money + 60;
            String imput = scan.nextLine();
            while (!imput.equals("Day over")) {
                double price = Double.parseDouble(imput);
                if (price <= money) {
                    money = money - price;
                    products++;
                }
                if (money == 0) {
                    System.out.printf("Daily limit exceeded! You've bought %d products.%n", products);
                    break;
                }
                imput = scan.nextLine();
            }
            if (money > 0) {
                System.out.printf("Money left from today: %.2f. You've bought %d products.%n", money, products);
            }
        }
    }
}
