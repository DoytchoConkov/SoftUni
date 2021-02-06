import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] number = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int n = number.length;
        while (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                number[i] = number[i] + number[i + 1];
            }
            n--;
        }
        System.out.println(number[0]);
    }
}
