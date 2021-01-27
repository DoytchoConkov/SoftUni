import java.util.Scanner;

public class Honeycombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bees = Integer.parseInt(scan.nextLine());
        int flowers = Integer.parseInt(scan.nextLine());
        double totalHoney = bees * flowers * 0.21;
        double honeycomb = Math.floor(totalHoney / 100);
        double restHoney = totalHoney - honeycomb * 100;
        System.out.printf("%.0f honeycombs filled.%n", honeycomb);
        System.out.printf("%.2f grams of honey left.", restHoney);
    }
}
