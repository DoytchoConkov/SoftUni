import java.util.Scanner;

public class DivisionWithoutRemainder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int divide2 = 0;
        int divide3 = 0;
        int divide4 = 0;
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (number % 2 == 0) {
                divide2++;
            }
            if (number % 3 == 0) {
                divide3++;
            }
            if (number % 4 == 0) {
                divide4++;
            }
        }
        p1 = 100.0 * divide2 / n;
        p2 = 100.0 * divide3 / n;
        p3 = 100.0 * divide4 / n;
        System.out.printf("%.2f%%%n", p1);
        System.out.printf("%.2f%%%n", p2);
        System.out.printf("%.2f%%%n", p3);
    }
}
