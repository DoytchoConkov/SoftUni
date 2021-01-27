import java.util.Scanner;

public class E03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = Integer.parseInt(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());
        int z = Integer.parseInt(scan.nextLine());
        int workers = Integer.parseInt(scan.nextLine());
        double wine = x * 0.4 * y / 2.5;
        if (wine < z) {
            double wineMinus = Math.floor(z - wine);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", wineMinus);
        } else {
            double wineLiters = Math.ceil(wine);
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", wineLiters);
            double winePerWorker = Math.ceil((wineLiters - z) / workers);
            System.out.printf("%.0f liters left -> %.0f liters per person.", wineLiters - z, winePerWorker);
        }
    }
}
