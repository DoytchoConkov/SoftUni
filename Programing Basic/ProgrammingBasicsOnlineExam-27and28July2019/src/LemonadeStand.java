import java.util.Scanner;

public class LemonadeStand {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double lemons = Double.parseDouble(scan.nextLine());
        double sugar = Double.parseDouble(scan.nextLine());
        double water = Double.parseDouble(scan.nextLine());
        double lemonJuice = lemons * 980;
        double totalJuice = lemonJuice + 0.3 * sugar + water * 1000;
        double cups = Math.floor(totalJuice / 150);
        System.out.printf("All cups sold: %.0f%n", cups);
        System.out.printf("Money earned: %.2f%n", cups * 1.2);
    }
}
