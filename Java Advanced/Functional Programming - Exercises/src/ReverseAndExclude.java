import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scan.nextLine());
        Collections.reverse(numbers);
        numbers = numbers.stream().filter(e -> e % n != 0).collect(Collectors.toList());
        numbers.stream().forEach(e -> System.out.print(e + " "));

    }
}
