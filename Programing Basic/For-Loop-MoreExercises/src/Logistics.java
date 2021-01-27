import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int totalPrice = 0;
        int microbusTonaz = 0;
        int truckTonaz = 0;
        int trainTonaz = 0;
        for (int i = 0; i < n; i++) {
            int tonaz = Integer.parseInt(scan.nextLine());
            if (tonaz <= 3) {
                totalPrice = totalPrice + 200 * tonaz;
                microbusTonaz += tonaz;
            } else if (tonaz >= 4 && tonaz <= 11) {
                totalPrice = totalPrice + 175 * tonaz;
                truckTonaz += tonaz;
            } else if (tonaz >= 12) {
                totalPrice = totalPrice + 120 * tonaz;
                trainTonaz += tonaz;
            }
        }
        System.out.printf("%.2f%n", 1.0 * totalPrice / (microbusTonaz + truckTonaz + trainTonaz));
        System.out.printf("%.2f%%%n", 100.0 * microbusTonaz / (microbusTonaz + truckTonaz + trainTonaz));
        System.out.printf("%.2f%%%n", 100.0 * truckTonaz / (microbusTonaz + truckTonaz + trainTonaz));
        System.out.printf("%.2f%%", 100.0 * trainTonaz / (microbusTonaz + truckTonaz + trainTonaz));
    }
}
