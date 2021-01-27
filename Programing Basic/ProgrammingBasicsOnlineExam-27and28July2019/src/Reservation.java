import java.util.Scanner;

public class Reservation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double price = 0;
        int dayReservation = Integer.parseInt(scan.nextLine());
        int mountReservation = Integer.parseInt(scan.nextLine());
        int dayIncome = Integer.parseInt(scan.nextLine());
        int mountIncome = Integer.parseInt(scan.nextLine());
        int dayOut = Integer.parseInt(scan.nextLine());
        int mountOut = Integer.parseInt(scan.nextLine());
        if (mountReservation < mountIncome) {
            price = 25 * 0.8;
        } else if (dayReservation + 10 < dayIncome) {
            price = 25;
        } else {
            price = 30;
        }
        int days = dayOut - dayIncome;
        System.out.printf("Your stay from %d/%d to %d/%d will cost %.2f", dayIncome, mountIncome, dayOut, mountOut, price * days);
    }
}
