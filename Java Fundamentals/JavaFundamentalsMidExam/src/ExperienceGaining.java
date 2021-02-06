import java.util.Scanner;

public class ExperienceGaining {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int neededExpirience = Integer.parseInt(scan.nextLine());
        int battles = Integer.parseInt(scan.nextLine());
        double expirience = 0;
        int winnedBattles = 0;
        for (int i = 1; i <= battles; i++) {
            double battleexpirience = Double.parseDouble(scan.nextLine());
            if (i % 3 == 0) {
                battleexpirience *= 1.15;
            }
            if (i % 5 == 0) {
                battleexpirience *= 0.9;
            }
            expirience = expirience +battleexpirience;
            if (expirience >= neededExpirience) {
                winnedBattles = i;
                break;
            }
        }
        if (winnedBattles > 0) {
            System.out.printf("Player successfully collected his needed experience for %d battles.", winnedBattles);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.",
                    neededExpirience - expirience);
        }
    }
}
