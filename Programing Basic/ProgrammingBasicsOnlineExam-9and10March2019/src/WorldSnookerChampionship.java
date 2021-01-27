import java.util.Scanner;

public class WorldSnookerChampionship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String stage = scan.nextLine();
        String type = scan.nextLine();
        int tikets = Integer.parseInt(scan.nextLine());
        String photo = scan.nextLine();
        double tiketPrice = 0;
        double totalTiketPrice = 0;
        switch (stage) {
            case "Quarter final":
                switch (type) {
                    case "Standard":
                        tiketPrice = 55.5;
                        break;
                    case "Premium":
                        tiketPrice = 105.2;
                        break;
                    case "VIP":
                        tiketPrice = 118.9;
                        break;
                }
                break;
            case "Semi final":
                switch (type) {
                    case "Standard":
                        tiketPrice = 75.88;
                        break;
                    case "Premium":
                        tiketPrice = 125.22;
                        break;
                    case "VIP":
                        tiketPrice = 300.4;
                        break;
                }
                break;
            case "Final":
                switch (type) {
                    case "Standard":
                        tiketPrice = 110.1;
                        break;
                    case "Premium":
                        tiketPrice = 160.66;
                        break;
                    case "VIP":
                        tiketPrice = 400;
                        break;
                }
                break;
        }
        totalTiketPrice = tikets * tiketPrice;
        if (totalTiketPrice > 4000) {
            totalTiketPrice = totalTiketPrice * 0.75;
        } else if (totalTiketPrice > 2500) {
            totalTiketPrice = totalTiketPrice * 0.9;
        }
        if (photo.equals("Y") && totalTiketPrice <= 4000) {
            totalTiketPrice = totalTiketPrice + 40 * tikets;
        }
        System.out.printf("%.2f", totalTiketPrice);
    }
}