import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String season = scan.nextLine();
        double kilometersPerMount = Double.parseDouble(scan.nextLine());
        double pricePerKilometer = 0;
        switch (season) {
            case "Spring":
            case "Autumn":
                if (kilometersPerMount <= 5000) {
                    pricePerKilometer = 0.75;
                } else if (kilometersPerMount <= 10000) {
                    pricePerKilometer = 0.95;
                } else if (kilometersPerMount <= 20000) {
                    pricePerKilometer = 1.45;
                }
                break;
            case "Summer":
                if (kilometersPerMount <= 5000) {
                    pricePerKilometer = 0.9;
                } else if (kilometersPerMount <= 10000) {
                    pricePerKilometer = 1.1;
                } else if (kilometersPerMount <= 20000) {
                    pricePerKilometer = 1.45;
                }
                break;
            case "Winter":
                if (kilometersPerMount <= 5000) {
                    pricePerKilometer = 1.05;
                } else if (kilometersPerMount <= 10000) {
                    pricePerKilometer = 1.25;
                } else if (kilometersPerMount <= 20000) {
                    pricePerKilometer = 1.45;
                }
                break;
        }
        double totalSum = 4 * pricePerKilometer * kilometersPerMount*0.9;
        System.out.printf("%.2f", totalSum);
    }
}
