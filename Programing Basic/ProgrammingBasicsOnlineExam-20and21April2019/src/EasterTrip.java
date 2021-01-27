import java.util.Scanner;

public class EasterTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destination = scan.nextLine();
        String period = scan.nextLine();
        int days = Integer.parseInt(scan.nextLine());
        double pricePerDay = 0;
        switch (destination) {
            case "France":
                switch (period) {
                    case "21-23":
                        pricePerDay = 30;
                        break;
                    case "24-27":
                        pricePerDay = 35;
                        break;
                    case "28-31":
                        pricePerDay = 40;
                        break;
                }
                break;
            case "Italy":
                switch (period) {
                    case "21-23":
                        pricePerDay = 28;
                        break;
                    case "24-27":
                        pricePerDay = 32;
                        break;
                    case "28-31":
                        pricePerDay = 39;
                        break;
                }
                break;
            case "Germany":
                switch (period) {
                    case "21-23":
                        pricePerDay = 32;
                        break;
                    case "24-27":
                        pricePerDay = 37;
                        break;
                    case "28-31":
                        pricePerDay = 43;
                        break;
                }
                break;
        }
        System.out.printf("Easter trip to %s : %.2f leva.", destination, pricePerDay * days);

    }
}
