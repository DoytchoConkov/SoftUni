import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class vionaNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<Integer> player1;
        LinkedHashSet<Integer> player2;
        player1 = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
        player2 = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));

        int cnt = 50;
        while (cnt-- > 0) {
            int firstPlayerCard = player1.iterator().next();
            player1.remove(firstPlayerCard);
            int secondPlayerCard = player2.iterator().next();
            player2.remove(secondPlayerCard);


            if (firstPlayerCard > secondPlayerCard) {
                player1.add(firstPlayerCard);
                player1.add(secondPlayerCard);
            } else {
                player2.add(firstPlayerCard);
                player2.add(secondPlayerCard);
            }

            if (player1.size() == 0 || player2.size() == 0) {
                break;
            }
        }
        if (player1.size()==player2.size()){
            System.out.println("Draw!");
        }else if (player1.size()>player2.size()){
            System.out.println("First player win!");
        }else {
            System.out.println("Second player win!");
        }
    }
}
