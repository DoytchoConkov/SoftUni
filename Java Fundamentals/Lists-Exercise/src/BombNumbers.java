import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int[] bomb = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        int bombValue = bomb[0];
        int bombLength = bomb[1];
        while (numbers.contains(bombValue)) {
            int bombIndex = numbers.indexOf(bombValue);
            int left = bombIndex - bombLength;
            int right = bombIndex + bombLength;
            right = Math.min(right, numbers.size() - 1);
            left = Math.max(left, 0);
            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
