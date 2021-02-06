import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        double priceLighters = Double.parseDouble(scan.nextLine());
        double priceRobes = Double.parseDouble(scan.nextLine());
        double priceBelts = Double.parseDouble(scan.nextLine());
        double totalLightersPrice = priceLighters * Math.ceil(students * 1.1);
        double totalRobesPrice = priceRobes * students;
        double totalBeltsPrice = priceBelts * (students - students / 6);
        double totalPrice = totalBeltsPrice + totalLightersPrice + totalRobesPrice;
        if (totalPrice <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", totalPrice - budget);
        }
    }
}
