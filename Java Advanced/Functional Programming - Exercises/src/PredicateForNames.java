import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Arrays.stream(scan.nextLine().split("\\s+")).filter(e -> e.length() <= n).forEach(name ->
                System.out.println(name));
    }
}
