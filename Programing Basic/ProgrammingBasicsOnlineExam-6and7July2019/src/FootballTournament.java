import java.util.Scanner;

public class FootballTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wins = 0;
        int loses = 0;
        int equals = 0;
        String team = scan.nextLine();
        int games = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < games; i++) {
            String result = scan.nextLine();
            switch (result) {
                case "W":
                    wins++;
                    break;
                case "D":
                    equals++;
                    break;
                case "L":
                    loses++;
                    break;
            }
        }
        if (games == 0) {
            System.out.printf("%s hasn't played any games during this season.", team);
        } else {
            System.out.printf("%s has won %d points during this season.%n", team, wins * 3 + equals);
            System.out.println("Total stats:");
            System.out.printf("## W: %d%n", wins);
            System.out.printf("## D: %d%n", equals);
            System.out.printf("## L: %d%n", loses);
            System.out.printf("Win rate: %.2f%%", 100.0 * wins / games);
        }
    }
}
