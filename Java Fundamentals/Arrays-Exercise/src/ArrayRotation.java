import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] number = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            int tempNumber = number[0];
            for (int j = 1; j < number.length; j++) {
                number[j - 1] = number[j];
            }
            number[number.length - 1] = tempNumber;
        }
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
    }
}
