import java.util.Scanner;

public class MovieDay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalTime = Integer.parseInt(scan.nextLine());
        int scenes = Integer.parseInt(scan.nextLine());
        int sceneDuration = Integer.parseInt(scan.nextLine());
        if (1.0 * totalTime > 1.0*sceneDuration * scenes + totalTime * 0.15) {
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!",
                    totalTime - sceneDuration * scenes - totalTime * 0.15);
        } else {
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.",
                    sceneDuration * scenes + totalTime * 0.15 - totalTime);
        }
    }
}
