import java.util.ArrayDeque;
import java.util.Scanner;

public class basicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        String[] numbers = scan.nextLine().split("\\s+");
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            numbersStack.offer(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < s; i++) {
            numbersStack.poll();
        }

        if (numbersStack.isEmpty()) {
            System.out.println(0);
            return;
        }
        int min = Integer.MAX_VALUE;
        for (Integer number : numbersStack) {
            if (number < min) {
                min = number;
            }
            if (number == x) {
                System.out.println("true");
                return;
            }
        }
        System.out.println(min);
    }
}
