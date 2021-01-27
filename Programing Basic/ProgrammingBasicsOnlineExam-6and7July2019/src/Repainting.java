import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nailon = Integer.parseInt(scan.nextLine());
        int pain = Integer.parseInt(scan.nextLine());
        int diluent = Integer.parseInt(scan.nextLine());
        int hours = Integer.parseInt(scan.nextLine());
        double totalConsumptivesSum = (nailon + 2) * 1.5 + pain * 1.1 * 14.5 + diluent * 5 + 0.4;
        double mastersPrice = totalConsumptivesSum * 0.3 * hours;
        System.out.printf("Total expenses: %.2f lv.", totalConsumptivesSum + mastersPrice);
    }
}
