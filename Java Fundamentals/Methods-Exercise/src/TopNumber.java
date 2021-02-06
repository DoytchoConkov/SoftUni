import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= n; i++) {
            if (printIsSpecialNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean printIsSpecialNumber(int i) {
        int sum = 0;
        boolean flag = false;
        while (i > 0) {
            int digit = i % 10;
            sum = sum + digit;
            if (digit % 2 != 0) {
                flag = true;
            }
            i = i / 10;
        }
        if (flag && sum % 8 == 0) {
            return true;
        }
        return false;
    }
}
