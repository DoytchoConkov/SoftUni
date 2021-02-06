import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 1; i <= 10; i++) {
            String text = String.format("%d X %d = %d", n, i, n * i);
            System.out.println(text);
        }
    }
}
