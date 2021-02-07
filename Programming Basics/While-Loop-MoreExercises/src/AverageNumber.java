import java.util.Scanner;

public class AverageNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            sum += number;
        }
        System.out.printf("%.2f", 1.0 * sum / n);
    }
}
