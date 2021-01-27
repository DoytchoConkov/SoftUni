import java.util.Scanner;

public class BestPlaneTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String imput = scan.nextLine();
        String flyMin = "";
        double priceMin = 0;
        int minutesMin = 600;
        while (!imput.equals("End")) {
            double price = Double.parseDouble(scan.nextLine());
            int minutes = Integer.parseInt(scan.nextLine());
            if (minutes < minutesMin) {
                flyMin = imput;
                priceMin = price;
                minutesMin = minutes;
            }
            imput= scan.nextLine();
        }
        System.out.printf("Ticket found for flight %s costs %.2f leva with %dh %dm stay",
                flyMin, priceMin*1.96, minutesMin / 60 , minutesMin % 60);
    }
}
