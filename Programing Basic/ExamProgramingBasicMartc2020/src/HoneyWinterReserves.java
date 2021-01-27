import java.util.Scanner;

public class HoneyWinterReserves {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double honeyForWinter = Double.parseDouble(scan.nextLine());
        double totalHarvestHoney = 0;
        String name = scan.nextLine();
        while (!"Winter has come".equals(name)) {
            double honeyPerBee = 0;
            for (int i = 0; i < 6; i++) {
                double honey = Double.parseDouble(scan.nextLine());
                honeyPerBee = honeyPerBee + honey;
            }
            if (honeyPerBee < 0) {
                System.out.printf("%s was banished for gluttony%n", name);
            }
            totalHarvestHoney = totalHarvestHoney + honeyPerBee;
            if (totalHarvestHoney >= honeyForWinter) {
                System.out.printf("Well done! Honey surplus %.2f.", totalHarvestHoney - honeyForWinter);
                break;
            }
            name = scan.nextLine();
        }
        if (totalHarvestHoney<honeyForWinter) {
            System.out.printf("Hard Winter! Honey needed %.2f.", honeyForWinter - totalHarvestHoney);
        }
    }
}
