import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hrizantemsCnt = Integer.parseInt(scan.nextLine());
        int rosesCnt = Integer.parseInt(scan.nextLine());
        int tulupCnt = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        String holiday = scan.nextLine();
        double hrizantemsPrice = 0;
        double rosesPrice = 0;
        double tulupPrice = 0;
        double totalPrice = 0;
        switch (season) {
            case "Spring":
            case "Summer":
                hrizantemsPrice = 2;
                rosesPrice = 4.1;
                tulupPrice = 2.5;
                break;
            case "Autumn":
            case "Winter":
                hrizantemsPrice = 3.75;
                rosesPrice = 4.5;
                tulupPrice = 4.15;
                break;
        }
        totalPrice = hrizantemsPrice * hrizantemsCnt + rosesCnt * rosesPrice + tulupCnt * tulupPrice;
        if (holiday.equals("Y")) {
            totalPrice = totalPrice * 1.15;
        }
        if (tulupCnt > 7 && season.equals("Spring")) {
            totalPrice = totalPrice * 0.95;
        }
        if (rosesCnt >= 10 && season.equals("Winter")) {
            totalPrice = totalPrice * 0.9;
        }
        if (hrizantemsCnt + rosesCnt + tulupCnt > 20) {
            totalPrice = totalPrice * 0.8;
        }
        System.out.printf("%.2f", totalPrice + 2);
    }
}
