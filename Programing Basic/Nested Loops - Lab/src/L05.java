import java.util.Scanner;

public class L05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destination = scan.nextLine();
        while (!"End".equals(destination)) {
            int budget = Integer.parseInt(scan.nextLine());
            int price = 0;
            int currentMoney;
            while (price < budget) {
                currentMoney = Integer.parseInt(scan.nextLine());
                price = price+currentMoney;
            }
            System.out.println("Going to " + destination + "!");
            destination = scan.nextLine();
        }
    }
}
