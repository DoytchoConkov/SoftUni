import java.util.Scanner;

public class E08_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fuelType = scan.nextLine();
        double liters = Double.parseDouble(scan.nextLine());
        String clubCard = scan.nextLine();
        double fuelPrice = 0;
        double totalPrice = 0;
        switch (fuelType) {
            case "Gas":
                if (clubCard.equals("Yes")) {
                    fuelPrice = 0.93 - 0.08;
                } else {
                    fuelPrice = 0.93;
                }
                break;
            case "Gasoline":
                if (clubCard.equals("Yes")) {
                    fuelPrice = 2.22 - 0.18;
                } else {
                    fuelPrice = 2.22;
                }
                break;
            case "Diesel":
                if (clubCard.equals("Yes")) {
                    fuelPrice = 2.33 - 0.12;
                } else {
                    fuelPrice = 2.33;
                }
                break;
        }
        totalPrice = fuelPrice * liters;
        if (liters >= 20 && liters <= 25) {
            totalPrice = totalPrice * 0.92;
        }
        if (liters > 25) {
            totalPrice = totalPrice * 0.9;
        }
        System.out.printf("%.2f lv.", totalPrice);
    }
}
