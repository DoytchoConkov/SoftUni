import java.util.Scanner;

public class FamilyTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int nights = Integer.parseInt(scan.nextLine());
        double nightPrice = Double.parseDouble(scan.nextLine());
        int extraCosts = Integer.parseInt(scan.nextLine());
        if (nights > 7) {
            nightPrice = nightPrice * 0.95;
        }
        double totalNightsPrice = nightPrice * nights;
        double totalExtraCosts = budget * extraCosts/100;
        double total = totalExtraCosts + totalNightsPrice;
        if (total <= budget) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget - total);
        } else {
            System.out.printf("%.2f leva needed.", total - budget);
        }
    }
}
