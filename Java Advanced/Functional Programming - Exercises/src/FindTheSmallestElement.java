import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        Function<int[], Integer> func = x -> {
            int index = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < x.length; i++) {
                if (min > x[i]) {
                    min = x[i];
                    index = i;
                }
            }
            return index;
        };
        System.out.println(func.apply(numbers));
    }
}
