import java.util.Scanner;

public class VetParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int hours = Integer.parseInt(scan.nextLine());
        double price = 0;
        double totalPrice = 0;
        for (int i = 1; i <= days; i++) {
            for (int j = 1; j <= hours; j++) {
                if (i % 2 == 0 && j % 2 != 0) {
                    totalPrice = totalPrice + 2.5;
                    price += 2.5;
                } else if (i % 2 != 0 && j % 2 == 0) {
                    totalPrice = totalPrice + 1.25;
                    price += 1.25;
                } else {
                    totalPrice = totalPrice + 1;
                    price += 1;
                }
            }
            System.out.printf("Day: %d - %.2f leva%n", i, price);
            price = 0;
        }
        System.out.printf("Total: %.2f leva", totalPrice);
    }
}
