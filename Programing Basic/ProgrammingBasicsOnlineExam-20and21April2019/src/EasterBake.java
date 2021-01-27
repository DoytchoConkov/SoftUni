import java.util.Scanner;

public class EasterBake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int sugarMax = Integer.MIN_VALUE;
        int floorMax = Integer.MIN_VALUE;
        int sugarTotal = 0;
        int floorTotal = 0;
        for (int i = 0; i < n; i++) {
            int sugar = Integer.parseInt(scan.nextLine());
            int floor = Integer.parseInt(scan.nextLine());
            sugarTotal = sugarTotal + sugar;
            floorTotal = floorTotal + floor;
            if (sugar > sugarMax) {
                sugarMax = sugar;
            }
            if (floor > floorMax) {
                floorMax = floor;
            }
        }
        System.out.printf("Sugar: %.0f%n", Math.ceil(1.0 * sugarTotal / 950));
        System.out.printf("Flour: %.0f%n", Math.ceil((1.0 * floorTotal / 750)));
        System.out.printf("Max used flour is %d grams, max used sugar is %d grams.", floorMax, sugarMax);
    }
}
