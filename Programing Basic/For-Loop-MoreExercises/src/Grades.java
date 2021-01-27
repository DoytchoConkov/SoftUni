import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double avgMark = 0;
        double markDo3 = 0;
        double markDo4 = 0;
        double markDo5 = 0;
        double markDo6 = 0;

        for (int i = 0; i < n; i++) {
            double mark = Double.parseDouble(scan.nextLine());
            if (mark < 3) {
                markDo3++;
            } else if (mark < 4) {
                markDo4++;
            } else if (mark < 5) {
                markDo5++;
            } else {
                markDo6++;
            }
            avgMark += mark;
        }
        System.out.printf("Top students: %.2f%%%n", 100.0 * markDo6 / n);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", 100.0 * markDo5 / n);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", 100.0 * markDo4 / n);
        System.out.printf("Fail: %.2f%%%n", 100.0 * markDo3 / n);
        System.out.printf("Average: %.2f", 1.0 * avgMark / n);
    }
}
