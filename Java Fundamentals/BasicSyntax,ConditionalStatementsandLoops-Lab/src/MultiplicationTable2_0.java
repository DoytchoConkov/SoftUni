import java.util.Scanner;

public class MultiplicationTable2_0 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int time = Integer.parseInt(scan.nextLine());
        for (int i = time; i <= 10; i++) {
            String text = String.format("%d X %d = %d", n, i, n * i);
            System.out.println(text);
        }
        if (time > 10) {
            String text = String.format("%d X %d = %d", n, time, n * time);
            System.out.println(text);
        }
    }
}