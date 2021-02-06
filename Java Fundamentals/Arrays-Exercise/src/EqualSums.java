import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int k = 0; k < numbers.length; k++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0; i < k; i++) {
                leftSum += numbers[i];
            }
            for (int j = k + 1; j < numbers.length; j++) {
                rightSum += numbers[j];

            }
            if (leftSum == rightSum && !flag) {
                System.out.println(k);
                flag = true;

            }
        }
        if (!flag) {
            System.out.println("no");
        }
    }
}
