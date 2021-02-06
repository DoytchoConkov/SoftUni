import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] number = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                evenSum += number[i];
            } else {
                oddSum += number[i];
            }
        }
        System.out.println(evenSum - oddSum);
    }
}
