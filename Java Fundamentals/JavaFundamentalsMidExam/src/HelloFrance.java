import java.util.Scanner;

public class HelloFrance {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] ithems = scan.nextLine().split("\\|");
        double budjet = Double.parseDouble(scan.nextLine());
        double totalMoney = -budjet;
        double startMoney=budjet;
        for (int i = 0; i < ithems.length; i++) {
            String[] tokens = ithems[i].split("->");
            double price = Double.parseDouble(tokens[1]);
            switch (tokens[0]) {
                case "Clothes":
                    if (price <= 50 && price <= budjet) {
                        System.out.printf("%.2f ", price * 1.4);
                        totalMoney = totalMoney + price * 1.4;
                        budjet = budjet - price;
                    }
                    break;
                case "Shoes":
                    if (price <= 35 && price <= budjet) {
                        System.out.printf("%.2f ", price * 1.4);
                        totalMoney = totalMoney + price * 1.4;
                        budjet = budjet - price;
                    }
                    break;
                case "Accessories":
                    if (price <= 20.50 && price <= budjet) {
                        System.out.printf("%.2f ", price * 1.4);
                        totalMoney = totalMoney + price * 1.4;
                        budjet = budjet - price;
                    }
                    break;
            }
        }
        totalMoney = totalMoney + budjet;
        System.out.println();
        System.out.printf("Profit: %.2f%n", totalMoney);
        if (totalMoney+startMoney >= 150) {
            System.out.printf("Hello, France!");
        } else {
            System.out.printf("Time to go.");
        }
    }
}
