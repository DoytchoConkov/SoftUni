import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int capacity = 0;
        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(scan.nextLine());
            if (capacity + liters > 255) {
                System.out.println("Insufficient capacity!");
            } else {
                capacity += liters;
            }
        }
        System.out.println(capacity);
    }
}
