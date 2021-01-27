import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int holidays = Integer.parseInt(scan.nextLine());
        int workingdays = 365 - holidays;
        int timeForGames = holidays * 127 + workingdays * 63;
        if (timeForGames < 30000) {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", (30000 - timeForGames) / 60, (30000 - timeForGames) % 60);
        } else {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", (timeForGames-30000) / 60, (timeForGames-30000) % 60);
        }
    }
}
