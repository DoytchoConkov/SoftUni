import java.util.ArrayDeque;
import java.util.Scanner;

public class reverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> numbers = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            numbers.push(input[i]);
        }

        for (String number : numbers
        ) {
            System.out.print(number + " ");
        }
    }
}
