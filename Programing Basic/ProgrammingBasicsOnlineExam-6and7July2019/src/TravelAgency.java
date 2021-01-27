import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destination = scan.nextLine();
        String packetType = scan.nextLine();
        String vip = scan.nextLine();
        boolean flag = false;
        int days = Integer.parseInt(scan.nextLine());
        double pricePerDays = 0;
        switch (destination) {
            case "Bansko":
            case "Borovets":
                if (packetType.equals("noEquipment")) {
                    pricePerDays = 80;
                    if (vip.equals("yes")) {
                        pricePerDays = pricePerDays * 0.95;
                    }
                } else if (packetType.equals("withEquipment")) {
                    pricePerDays = 100;
                    if (vip.equals("yes")) {
                        pricePerDays = pricePerDays * 0.9;
                    }
                } else {
                    System.out.println("Invalid input!");
                    flag = true;
                }
                break;
            case "Burgas":
            case "Varna":
                if (packetType.equals("noBreakfast")) {
                    pricePerDays = 100;
                    if (vip.equals("yes")) {
                        pricePerDays = pricePerDays * 0.93;
                    }
                } else if (packetType.equals("withBreakfast")) {
                    pricePerDays = 130;
                    if (vip.equals("yes")) {
                        pricePerDays = pricePerDays * 0.88;
                    }
                } else {
                    System.out.println("Invalid input!");
                    flag = true;
                }
                break;
            default:
                System.out.println("Invalid input!");
                flag = true;
        }
        if (days > 7) {
            days--;
        }
        if (days < 1) {
            System.out.println("Days must be positive number!");
        } else if (!flag) {
            System.out.printf("The price is %.2flv! Have a nice time!", days * pricePerDays);
        }

    }
}
