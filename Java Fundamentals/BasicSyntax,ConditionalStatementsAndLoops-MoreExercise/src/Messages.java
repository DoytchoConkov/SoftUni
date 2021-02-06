import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            int code = Integer.parseInt(scan.nextLine());
            String stringDigit = "" + code;
            int numberOfDigits = stringDigit.length();
            int mainDigit = code % 10;
            int offset = (mainDigit - 2) * 3;
            if (mainDigit == 8 || mainDigit == 9) {
                offset++;
            }
            int position = offset + numberOfDigits - 1;
            if (mainDigit == 0) {
                System.out.print(" ");
            } else {
                System.out.printf("%c", 'a' + position);
            }
        }
    }
}
