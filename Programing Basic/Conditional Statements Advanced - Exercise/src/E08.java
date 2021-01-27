import java.util.Scanner;

public class E08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String mount = scan.nextLine();
        int days = Integer.parseInt(scan.nextLine());

        switch (mount) {
            case "May":
            case "October":
                if (days > 14) {
                    System.out.printf("Apartment: %.2f lv.%n", days * 65 * 0.9);
                } else {
                    System.out.printf("Apartment: %.2f lv.%n", days * 65.0);
                }
                if (days > 7 && days <= 14) {
                    System.out.printf("Studio: %.2f lv.", days * 50 * 0.95);
                } else if (days > 14) {
                    System.out.printf("Studio: %.2f lv.", days * 50 * 0.7);
                } else {
                    System.out.printf("Studio: %.2f lv.", 1.0 * days * 50);
                }
                break;
            case "June":
            case "September":
                if (days > 14) {
                    System.out.printf("Apartment: %.2f lv.%n", days * 68.70 * 0.9);
                } else {
                    System.out.printf("Apartment: %.2f lv.%n", days * 68.70);
                }
                if (days > 14) {
                    System.out.printf("Studio: %.2f lv.", days * 75.20 * 0.8);
                } else {
                    System.out.printf("Studio: %.2f lv.", days * 75.20);
                }
                break;
            case "July":
            case "August":
                if (days > 14) {
                    System.out.printf("Apartment: %.2f lv.%n", days * 77 * 0.9);
                } else {
                    System.out.printf("Apartment: %.2f lv.%n", days * 77.0);
                }
                System.out.printf("Studio: %.2f lv.", days * 76.0);
                break;

        }
    }
}
