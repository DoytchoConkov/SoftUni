import java.util.*;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> liliesNumbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
        Deque<Integer> lilies = new ArrayDeque<>();
        liliesNumbers.forEach(n -> lilies.push(n));

        List<Integer> rosesNumbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());
        Deque<Integer> roses = new ArrayDeque<>();
        rosesNumbers.forEach(n -> roses.offer(n));

        int wreaths = 0;
        int flowers = 0;

        while (lilies.size() > 0 && roses.size() > 0) {
            int currentLilies = lilies.pop();
            int currentRoses = roses.poll();
            if (currentLilies + currentRoses == 15) {
                wreaths++;
            } else {
                while (currentLilies + currentRoses > 15) {
                    currentLilies -= 2;
                }
                flowers = flowers + currentLilies + currentRoses;

            }
        }
        wreaths += flowers / 15;
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}
