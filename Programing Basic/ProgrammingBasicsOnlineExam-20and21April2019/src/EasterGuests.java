import java.util.Scanner;

public class EasterGuests {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int guests = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());
        double kozunaks = Math.ceil(1.0 * guests / 3);
        double sum = kozunaks * 4 + guests * 2 * 0.45;
        if (sum <= budget) {
            System.out.printf("Lyubo bought %.0f Easter bread and %d eggs.%n", kozunaks, guests * 2);
            System.out.printf("He has %.2f lv. left.", budget - sum);
        } else {
            System.out.printf("Lyubo doesn't have enough money.%n");
            System.out.printf("He needs %.2f lv. more.", sum - budget);
        }


    }
}
