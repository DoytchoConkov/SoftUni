import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> firstBox = new ArrayDeque<>();
        Deque<Integer> secondBox = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int number : numbers) {
            firstBox.offer(number);
        }

        numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int number : numbers) {
            secondBox.push(number);
        }

        int claimedItems = 0;
        while (firstBox.size() > 0 && secondBox.size() > 0) {
            int firstIthem = firstBox.peek();
            int secondIthem = secondBox.peek();
            int sum = firstIthem + secondIthem;
            if (sum % 2 == 0) {
                firstBox.pop();
                secondBox.poll();
                claimedItems += sum;
            } else {
                firstBox.offer(secondBox.poll());
            }
        }
        if (firstBox.size() == 0) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if (claimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", claimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", claimedItems);
        }
    }
}
