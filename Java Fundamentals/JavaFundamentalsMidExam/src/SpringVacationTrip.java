import java.util.Scanner;

public class SpringVacationTrip {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        double budjet = Double.parseDouble(scan.nextLine());
        int peoles = Integer.parseInt(scan.nextLine());
        double priceFuelPerKilometer = Double.parseDouble(scan.nextLine());
        double foodExpensesPerDayPerPerson = Double.parseDouble(scan.nextLine());
        double roomPriceForDayForperson = Double.parseDouble(scan.nextLine());

        if (peoles > 10) {
            roomPriceForDayForperson = roomPriceForDayForperson * 0.75;
        }
        double totalExposes = peoles * days * roomPriceForDayForperson + peoles * days * foodExpensesPerDayPerPerson;

        for (int i = 1; i <= days; i++) {
            double distancePerDay = Double.parseDouble(scan.nextLine());
            totalExposes = totalExposes + distancePerDay * priceFuelPerKilometer;
            if (i % 3 == 0 || i % 5 == 0) {
                totalExposes = totalExposes * 1.4;
            }
            if (i % 7 == 0) {
                totalExposes = totalExposes - totalExposes / peoles;
            }
            if (totalExposes > budjet) {
                break;
            }
        }
        if (totalExposes > budjet) {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", totalExposes - budjet);
        } else {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budjet - totalExposes);
        }
    }
}
