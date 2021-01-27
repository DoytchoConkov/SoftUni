import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int p = Integer.parseInt(scan.nextLine());
        double videoCardsPriceTotal = n * 250;
        double processorsPriceTotal = m * 0.35 * videoCardsPriceTotal;
        double ramPriceTotal = p * 0.1 * videoCardsPriceTotal;
        double total = videoCardsPriceTotal + processorsPriceTotal + ramPriceTotal;
        if (n > m) {
            total = total * 0.85;
        }
        if (total <= budget) {
            System.out.printf("You have %.2f leva left!", budget - total);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", total - budget);
        }
    }
}
