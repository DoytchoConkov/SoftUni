import java.util.Scanner;

public class Club {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double profit = Double.parseDouble(scan.nextLine());
        String imput = scan.nextLine();
        double total = 0;
        while (!imput.equals("Party!")) {
            int clients = Integer.parseInt(scan.nextLine());
            double cocktailPrice = imput.length();
            double order = clients * cocktailPrice;
            if (order % 2 != 0) {
                order = order * 0.75;
            }
            total = total + order;
            if (total >= profit) {
                System.out.println("Target acquired.");
                break;
            }
            imput = scan.nextLine();
        }
        if (total < profit) {
            System.out.printf("We need %.2f leva more.%n", profit - total);
        }
        System.out.printf("Club income - %.2f leva.", total);
    }
}
