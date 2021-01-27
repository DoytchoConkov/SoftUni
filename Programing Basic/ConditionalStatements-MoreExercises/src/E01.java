import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int v = Integer.parseInt(scan.nextLine());
        int p1 = Integer.parseInt(scan.nextLine());
        int p2 = Integer.parseInt(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());
        double volume = p1 * h + p2 * h;
        if (volume > v) {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, volume - v);
        } else {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", 100.0 * volume / v, 100.0 * p1 / (p1 + p2), 100.0 * p2 / (p1 + p2));
        }
    }
}
