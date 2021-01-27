import java.nio.channels.ClosedSelectorException;
import java.util.Scanner;

public class BasketballTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wins = 0;
        int loses = 0;
        String imput = scan.nextLine();
        while (!imput.equals("End of tournaments")) {
            int n = Integer.parseInt(scan.nextLine());
            for (int i = 1; i <= n; i++) {
                int pointsTeam1 = Integer.parseInt(scan.nextLine());
                int pointsTeam2 = Integer.parseInt(scan.nextLine());
                if (pointsTeam1 > pointsTeam2) {
                    System.out.printf("Game %d of tournament %s: win with %d points.%n", i, imput, pointsTeam1 - pointsTeam2);
                    wins++;
                } else {
                    System.out.printf("Game %d of tournament %s: lost with %d points.%n", i, imput, pointsTeam2 - pointsTeam1);
                    loses++;
                }
            }
            imput = scan.nextLine();
        }
        System.out.printf("%.2f%% matches win%n", 100.0 * wins / (wins + loses));
        System.out.printf("%.2f%% matches lost", 100.0 * loses / (wins + loses));
    }
}
