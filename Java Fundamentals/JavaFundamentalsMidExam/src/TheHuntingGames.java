import java.util.Scanner;

public class TheHuntingGames {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = java.lang.Integer.parseInt(scan.nextLine());
        int players = Integer.parseInt(scan.nextLine());
        double groupEnergy = Double.parseDouble(scan.nextLine());
        double waterPerDayForOnePerson = Double.parseDouble(scan.nextLine());
        double foodPerDayForOnePerson = Double.parseDouble(scan.nextLine());

        double totalWater = days * players * waterPerDayForOnePerson;
        double totalFood = days * players * foodPerDayForOnePerson;

        for (int i = 1; i <= days; i++) {
            double energyLost = Double.parseDouble(scan.nextLine());

            groupEnergy = groupEnergy - energyLost;
            if (groupEnergy <= 0) {
                break;
            }

            if (i % 2 == 0) {
                groupEnergy = groupEnergy * 1.05;
                totalWater = totalWater * 0.7;
            }

            if (i % 3 == 0) {
                groupEnergy = groupEnergy * 1.10;
                totalFood = totalFood - totalFood / players;
            }

        }
        if (groupEnergy > 0) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", totalFood, totalWater);
        }
    }
}
