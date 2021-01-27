import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int chicken = Integer.parseInt(scan.nextLine());
        int fish = Integer.parseInt(scan.nextLine());
        int vegan = Integer.parseInt(scan.nextLine());
        System.out.printf("Total: %.2f", (chicken * 10.35 + fish * 12.4 + vegan * 8.15) * 1.2 + 2.5);
    }
}
