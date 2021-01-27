import java.util.Scanner;

public class L10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        String room = scan.nextLine();
        String mark = scan.nextLine();

        double price = 0;
        double percent = 1;
        double roomPrice = 0;
        switch (room) {
            case "room for one person":
                roomPrice = 18;
                break;
            case "apartment":
                roomPrice = 25;
                if (days <= 10) {
                    percent = 0.7;
                } else if (days < 15) {
                    percent = 0.65;
                } else {
                    percent = 0.5;
                }
                break;
            case "president apartment":
                roomPrice = 35;
                if (days <= 10) {
                    percent = 0.9;
                } else if (days < 15) {
                    percent = 0.85;
                } else {
                    percent = 0.8;
                }


                break;
        }
        price = roomPrice * percent * (days-1);
        if (mark.equals("negative")) {
            System.out.printf("%.2f", price * 0.9);
        } else {
            System.out.printf("%.2f", price * 1.25);
        }
    }
}
