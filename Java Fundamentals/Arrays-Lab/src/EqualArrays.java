import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] number1 = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] number2 = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < number1.length; i++) {
            if (number1[i] != number2[i]) {
                flag = false;
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
            sum += number1[i];
        }
        if (flag) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
