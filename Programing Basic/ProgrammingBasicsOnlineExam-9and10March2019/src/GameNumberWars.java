import java.util.Scanner;

public class GameNumberWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String player1Name = scan.nextLine();
        String player2Name = scan.nextLine();
        String imput = scan.nextLine();
        int pointsPlayer1 = 0;
        int pointsPlayer2 = 0;
        boolean flag = false;
        while (!imput.equals("End of game")) {
            int card1 = Integer.parseInt(imput);
            int card2 = Integer.parseInt(scan.nextLine());
            if (card1 > card2) {
                if (flag) {
                    System.out.printf("%s is winner with %d points", player1Name, pointsPlayer1);
                    break;
                }
                pointsPlayer1 = pointsPlayer1 + card1 - card2;
            } else if (card1 < card2) {
                if (flag) {
                    System.out.printf("%s is winner with %d points", player2Name, pointsPlayer2);
                    break;
                }
                pointsPlayer2 = pointsPlayer2 + card2 - card1;
            } else {
                System.out.println("Number wars!");
                flag = true;
            }
            imput = scan.nextLine();
        }
        if (!flag) {
            System.out.printf("%s has %d points%n", player1Name, pointsPlayer1);
            System.out.printf("%s has %d points%n", player2Name, pointsPlayer2);
        }

    }
}
