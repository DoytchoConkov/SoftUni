import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        int currentNumber = number;
        int sum = 0;
        while (currentNumber > 0) {
            sum = sum + currentNumber % 10;
            currentNumber = currentNumber / 10;
        }
        System.out.println(sum);
    }
}
