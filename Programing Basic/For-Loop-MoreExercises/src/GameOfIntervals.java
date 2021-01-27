import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double result = 0;
        int do10 = 0;
        int do20 = 0;
        int do30 = 0;
        int do40 = 0;
        int do50 = 0;
        int invalidNumbers = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (number >= 0 && number <= 9) {
                result = result + 0.2 * number;
                do10++;
            } else if (number >= 10 && number <= 19) {
                result = result + 0.3 * number;
                do20++;
            } else if (number >= 20 && number <= 29) {
                result = result + 0.4 * number;
                do30++;
            } else if (number >= 30 && number <= 39) {
                result = result + 50;
                do40++;
            } else if (number >= 40 && number <= 50) {
                result = result + 100;
                do50++;
            } else {
                invalidNumbers++;
                result = result / 2;
            }
        }
        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", 100.0 * do10 / n);
        System.out.printf("From 10 to 19: %.2f%%%n", 100.0 * do20 / n);
        System.out.printf("From 20 to 29: %.2f%%%n", 100.0 * do30 / n);
        System.out.printf("From 30 to 39: %.2f%%%n", 100.0 * do40 / n);
        System.out.printf("From 40 to 50: %.2f%%%n", 100.0 * do50 / n);
        System.out.printf("Invalid numbers: %.2f%%", 100.0 * invalidNumbers / n);
    }
}
