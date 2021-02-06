import java.util.Scanner;

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pounds = Integer.parseInt(scan.nextLine());
        double dolas = pounds * 1.31;
        System.out.printf("%.3f", dolas);
    }
}
