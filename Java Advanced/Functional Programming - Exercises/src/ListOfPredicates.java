import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Set<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        BiPredicate<Integer, Integer> pred = (num, i) -> i % num != 0;
        for (int i = 2; i <= n; i++) {
            boolean isValid = true;
            for (int number : numbers) {
                if (pred.test( number,i)) {
                    isValid = false;
                }
            }
            if (isValid) {
                System.out.print(i + " ");
            }
        }
    }
}
