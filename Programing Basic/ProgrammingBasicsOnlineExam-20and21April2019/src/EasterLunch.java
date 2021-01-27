import java.util.Scanner;

public class EasterLunch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int easterBread = Integer.parseInt(scan.nextLine());
        int barkEggs = Integer.parseInt(scan.nextLine());
        int cookies = Integer.parseInt(scan.nextLine());
        double easterBreadPrice = easterBread * 3.2;
        double barkEggsPrice = barkEggs * 4.35;
        double colorForEggsPrice = barkEggs * 12 * 0.15;
        double cookiesPrice = cookies * 5.4;
        double totalPrice = easterBreadPrice + barkEggsPrice + colorForEggsPrice + cookiesPrice;
        System.out.printf("%.2f", totalPrice);
    }
}
