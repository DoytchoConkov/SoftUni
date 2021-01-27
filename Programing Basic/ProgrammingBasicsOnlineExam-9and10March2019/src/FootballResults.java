import java.util.Scanner;

public class FootballResults {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String game1 = scan.nextLine();
        String game2 = scan.nextLine();
        String game3 = scan.nextLine();
        int win = 0;
        int lose = 0;
        int equals = 0;
        if (game1.charAt(0) > game1.charAt(2)) {
            win++;
        } else if (game1.charAt(0) < game1.charAt(2)) {
            lose++;
        } else {
            equals++;
        }
        if (game2.charAt(0) > game2.charAt(2)) {
            win++;
        } else if (game2.charAt(0) < game2.charAt(2)) {
            lose++;
        } else {
            equals++;
        }
        if (game3.charAt(0) > game3.charAt(2)) {
            win++;
        } else if (game3.charAt(0) < game3.charAt(2)) {
            lose++;
        } else {
            equals++;
        }
        System.out.printf("Team won %d games.%n", win);
        System.out.printf("Team lost %d games.%n", lose);
        System.out.printf("Drawn games: %d", equals);
    }
}
