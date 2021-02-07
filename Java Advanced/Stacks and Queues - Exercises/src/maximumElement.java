import java.util.ArrayDeque;
import java.util.Scanner;

public class maximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            if (input.equals("3")) {
                int maxElement = Integer.MIN_VALUE;
                for (Integer number : numbers) {
                    if (number > maxElement) {
                        maxElement = number;
                    }
                }
                System.out.println(maxElement);
            } else if (input.equals("2")) {
                numbers.pop();
            } else {
                String[] token = input.split("\\s+");
                int number = Integer.parseInt(token[1]);
                numbers.push(number);
            }
        }
    }
}
