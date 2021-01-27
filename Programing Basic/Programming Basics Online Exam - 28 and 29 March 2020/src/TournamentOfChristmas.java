import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int daysWin = 0;
        int daysWose = 0;
        double totalMoney = 0;
        for (int i = 1; i <= days; i++) {
            int winsAtDay = 0;
            int woseAtdays = 0;
            String imput = scan.nextLine();
            while (!imput.equals("Finish")) {
                String result = scan.nextLine();
                if (result.equals("win")) {
                    winsAtDay++;
                } else {
                    woseAtdays++;
                }
                imput = scan.nextLine();
            }
            if (winsAtDay > woseAtdays) {
                totalMoney = totalMoney + winsAtDay * 20 * 1.1;
                daysWin++;
            } else {
                totalMoney = totalMoney + winsAtDay * 20;
                daysWose++;
            }
        }
        if (daysWin > daysWose) {
            System.out.printf("You won the tournament! Total raised money: %.2f", totalMoney * 1.2);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalMoney);
        }
    }
}
