import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        Function<int[], Integer> func = x -> {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < x.length; i++) {
                if (min > x[i]) {
                    min = x[i];
                }
            }
            return min;
        };
        System.out.println(func.apply(numbers));
    }
}
