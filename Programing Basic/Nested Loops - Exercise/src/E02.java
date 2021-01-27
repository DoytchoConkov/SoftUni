import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1 = Integer.parseInt(scan.nextLine());
        int number2 = Integer.parseInt(scan.nextLine());
        for (int i = number1; i <= number2; i++) {
            int sumOdd = 0;
            int sumEven = 0;
            String currentNumber = "" + i;
            for (int j = 0; j < currentNumber.length(); j++) {
                int currentDigit = Integer.parseInt("" + currentNumber.charAt(j));
                if (j % 2 == 0) {
                    sumEven += currentDigit;
                } else {
                    sumOdd += currentDigit;
                }

            }
            if (sumEven == sumOdd) {
                System.out.print(i+" ");
            }
        }
    }
}