import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        long number1 = 0;
        long number2 = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            number1 = scan.nextLong();
            number2 = scan.nextLong();

            if (number1 < number2) {
                sum = 0;
                while (number2 != 0) {
                    sum += number2 % 10;
                    number2 /= 10;

                }
                System.out.println(Math.abs(sum));
            } else {
                sum = 0;
                while (number1 != 0) {
                    sum += number1 % 10;
                    number1 /= 10;

                }
                System.out.println(Math.abs(sum));
            }
        }
    }
}

