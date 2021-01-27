import java.util.Scanner;

public class EasterBakery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double flourPrice = Double.parseDouble(scan.nextLine());
        double flourKilograms = Double.parseDouble(scan.nextLine());
        double sugarKilogram = Double.parseDouble(scan.nextLine());
        int eggPacks = Integer.parseInt(scan.nextLine());
        int maia = Integer.parseInt(scan.nextLine());
        double sugarPrice = flourPrice * 0.75;
        double eggPackPrice = flourPrice * 1.1;
        double maiaPrice = sugarPrice * 0.2;
        double totalPrice = flourPrice * flourKilograms + sugarKilogram * sugarPrice + eggPackPrice * eggPacks + maia * maiaPrice;
        System.out.printf("%.2f", totalPrice);
    }
}
