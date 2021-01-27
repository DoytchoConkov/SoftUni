import java.util.Scanner;

public class Darts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalPonts = 301;
        int counter = 0;
        int counterFail = 0;
        String playerName = scan.nextLine();
        String imput = scan.nextLine();
        while (!imput.equals("Retire")) {
            int points = Integer.parseInt(scan.nextLine());
            switch (imput) {
                case "Double":
                    points = points * 2;
                    break;
                case "Triple":
                    points = points * 3;
                    break;
            }
            if (points <= totalPonts) {
                totalPonts = totalPonts - points;
                counter++;
            } else {
                counterFail++;
            }
            if (totalPonts == 0) {
                break;
            }
            imput = scan.nextLine();
        }
        if (totalPonts == 0) {
            System.out.printf("%s won the leg with %d shots.", playerName, counter);
        } else {
            System.out.printf("%s retired after %d unsuccessful shots.", playerName, counterFail);
        }
    }
}
