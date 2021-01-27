import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tax = Integer.parseInt(scan.nextLine());
        double cecs = tax * 0.6;
        double wear = cecs * 0.8;
        double ball = wear / 4;
        double acesoars = ball / 5;
        double sum = tax + cecs + wear + ball + acesoars;
        System.out.printf("%.2f", sum);
    }
}
