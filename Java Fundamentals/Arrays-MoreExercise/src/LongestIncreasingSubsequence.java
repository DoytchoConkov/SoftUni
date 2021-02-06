import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] len = new int[numbers.length];
        int[] prev = new int[numbers.length];
        int maxLength = 0;
        int lastIndex = -1;
        for (int i = 0; i < numbers.length ; i++) {
            len[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }
            if (len[i] > maxLength) {
                maxLength = len[i];
                lastIndex = i;
            }
        }
        String[] lis = new String[maxLength];
        int currentIndex = maxLength - 1;

        while (lastIndex != -1) {
            lis[currentIndex] = "" + numbers[lastIndex];
            currentIndex--;
            lastIndex = prev[lastIndex];
        }
        System.out.println(String.join(" ", lis));
    }
}
