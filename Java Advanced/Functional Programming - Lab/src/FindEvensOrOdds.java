import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] tokens = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        String numberType = scan.nextLine();
        Predicate<Integer> predict = createTester(numberType);

        for (int i = tokens[0]; i <= tokens[1]; i++) {
            if (predict.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> createTester(String numberType) {
        if (numberType.equals("odd")) {
            return e -> e % 2 == 1;
        } else {
            return e -> e % 2 == 0;
        }
    }
}
