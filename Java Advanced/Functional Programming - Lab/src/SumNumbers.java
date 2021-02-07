import java.util.Arrays;
import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).toArray(Integer[]::new);

        if (numbers.length < 2) {

            System.out.println("Count = " + numbers.length);

            System.out.println("Sum = " + numbers[0]);

        } else {
            int sum = 0;
            for (Integer number : numbers) {
                sum += number;
            }
            System.out.println("Count = " + numbers.length);
            System.out.println("Sum = " + sum);
        }
    }
}
