import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] number = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int i = 0; i < number.length ; i++) {
            boolean flag = true;
            for (int j = i+1; j < number.length; j++) {
                if (number[i] <= number[j]) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.print(number[i] + " ");
            }
        }
    }
}

