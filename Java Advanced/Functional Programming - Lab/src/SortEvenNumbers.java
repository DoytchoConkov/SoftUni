import java.util.Arrays;
import java.util.Scanner;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] eveneNumbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(num->num.toString())
                .toArray(String[]::new);

        System.out.println(String.join(", ", eveneNumbers));
        String[] sortedEvenNumber= Arrays.stream(eveneNumbers)
                .map(Integer::parseInt)
                .sorted()
                .map(num->num.toString())
                .toArray(String[]::new);
        System.out.println(String.join(", ", sortedEvenNumber));

    }
}
