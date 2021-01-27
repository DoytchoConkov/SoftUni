import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double inheretedMoney = Double.parseDouble(scan.nextLine());
        int year = Integer.parseInt(scan.nextLine());
        int ivanYears = 18;
        for (int i = 1800; i <= year; i++) {
            if (i % 2 == 0) {
                inheretedMoney = inheretedMoney - 12000;
            } else {
                inheretedMoney = inheretedMoney - 12000 - ivanYears * 50;
            }
            ivanYears++;
        }
        if (inheretedMoney >= 0) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", inheretedMoney);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(inheretedMoney));
        }
    }
}
