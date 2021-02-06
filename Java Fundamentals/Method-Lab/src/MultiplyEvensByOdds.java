import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        System.out.println(getMultipleOfEvensAndOdds(number));
    }

    public static int getMultipleOfEvensAndOdds(int n) {
        int evenSum = getEvemSum(n);
        int oddSum = getOddSum(n);
        return evenSum * oddSum;
    }

    public static int getEvemSum(int number) {
        int sum = 0;
        while (number != 0) {
            if ((number % 10) % 2 == 0) {
                sum += number % 10;
            }
            number /= 10;
        }
        return sum;
    }

    public static int getOddSum(int number) {
        int sum = 0;
        while (number != 0) {
            if ((number % 10) % 2 != 0) {
                sum += number % 10;
            }
            number /= 10;
        }
        return sum;
    }
}
