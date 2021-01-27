import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int minDifference = Integer.MAX_VALUE;
        int maxDifference = Integer.MIN_VALUE;
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int number1 = Integer.parseInt(scan.nextLine());
            int number2 = Integer.parseInt(scan.nextLine());
            sum = number1 + number2;
            if (sum > maxDifference) {
                maxDifference = sum;
            }
            if (sum < minDifference) {
                minDifference = sum;
            }
        }
        if (minDifference == maxDifference) {
            System.out.printf("Yes, value=%d", minDifference);
        } else {
            System.out.printf("No, maxdiff=%d", maxDifference - minDifference);
        }

    }
}
