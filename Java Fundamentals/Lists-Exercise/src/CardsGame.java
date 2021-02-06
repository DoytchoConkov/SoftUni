import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> cards1 = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> cards2 = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int i = 0;
        while (cards1.size() > 0 && cards2.size() > 0) {
            if (cards1.get(i) > cards2.get(i)) {
                cards1.add(cards1.get(i));
                cards1.remove(i);
                cards1.add(cards2.get(i));
                cards2.remove(i);
            } else if (cards2.get(i) > cards1.get(i)) {
                cards2.add(cards2.get(i));
                cards2.remove(i);
                cards2.add(cards1.get(i));
                cards1.remove(i);
            } else {
                cards1.remove(i);
                cards2.remove(i);
            }
        }

        int sum = 0;
        if (cards1.size() > 0) {
            for (int card : cards1) {
                sum += card;
            }
                System.out.printf("First player wins! Sum: %d", sum);
        } else {
            for (int card : cards2) {
                sum += card;
            }
                System.out.printf("Second player wins! Sum: %d", sum);
        }
    }
}
