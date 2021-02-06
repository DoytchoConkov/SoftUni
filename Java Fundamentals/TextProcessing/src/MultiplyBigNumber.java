import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String bigNumber = scan.nextLine();
        StringBuilder result = new StringBuilder();
        int maind = 0;
        int number = Integer.parseInt(scan.nextLine());
        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int i1 = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
            int temp = i1 * number + maind;
            int digit = temp % 10;
            maind = temp / 10;
            result.append(digit);
        }
        if (maind > 0) {
            result.append(maind);
        }
        boolean isZero = true;
        while (isZero) {
            if (result.charAt(result.length() - 1) == '0') {
                result.replace(result.length() - 1, result.length(), "");
                isZero = true;
            } else {
                isZero = false;
            }
        }
        System.out.println(result.reverse());
    }
}
