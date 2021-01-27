import java.util.Scanner;

public class Safari {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        double litersFuel = Double.parseDouble(scan.nextLine());
        String dayOfWeek = scan.nextLine();
        double totalCost = litersFuel * 2.1 + 100;
        if (dayOfWeek.equals("Saturday")) {
            totalCost = totalCost * 0.9;
        } else {
            totalCost = totalCost * 0.8;
        }
        if (totalCost <= budget) {
            System.out.printf("Safari time! Money left: %.2f lv. ", budget - totalCost);
        } else {
            System.out.printf("Not enough money! Money needed: %.2f lv.", totalCost - budget);
        }
    }
}
