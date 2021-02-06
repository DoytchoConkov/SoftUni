import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();
        int cnt = Integer.parseInt(scan.nextLine());
        totalPrice(product, cnt);
    }

    public static void totalPrice(String order, int quatity) {
        double price = 0;
        switch (order) {
            case "coffee":
                price = 1.50;
                break;
            case "water":
                price = 1.00;
                break;
            case "coke":
                price = 1.40;
                break;
            case "snacks":
                price = 2.00;
                break;
        }
        double totalPrice = price * quatity;
        System.out.printf("%.2f", totalPrice);
    }
}
