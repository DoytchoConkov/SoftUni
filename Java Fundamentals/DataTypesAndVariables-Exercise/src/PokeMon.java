import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int m = Integer.parseInt(scan.nextLine());
        int y = Integer.parseInt(scan.nextLine());
        int target = n;
        int counter = 0;
        while (target >= m) {
            counter++;
            target -= m;
            if (target - n / 2.0 == 0) {
                if (y != 0) {
                    target = target / y;
                }
            }
        }
        System.out.println(target);
        System.out.println(counter);
    }
}
