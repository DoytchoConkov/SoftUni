import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counter = 0;
        int turnirs = Integer.parseInt(scan.nextLine());
        int startingPoints = Integer.parseInt(scan.nextLine());
        int totalPoints = startingPoints;
        for (int i = 0; i < turnirs; i++) {
            String fase = scan.nextLine();
            switch (fase) {
                case "W":
                    totalPoints = totalPoints + 2000;
                    counter++;
                    break;
                case "F":
                    totalPoints = totalPoints + 1200;
                    break;
                case "SF":
                    totalPoints = totalPoints + 720;
                    break;
            }
        }
        System.out.printf("Final points: %d%n", totalPoints);
        System.out.printf("Average points: %d%n", (totalPoints - startingPoints) / turnirs);
        System.out.printf("%.2f%%", 100.0 * counter / turnirs);
    }
}
