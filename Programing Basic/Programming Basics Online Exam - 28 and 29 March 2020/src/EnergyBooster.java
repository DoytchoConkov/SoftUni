import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fruit = scan.nextLine();
        String size = scan.nextLine();
        int amountSets = Integer.parseInt(scan.nextLine());
        double price = 0;
        switch (fruit) {
            case "Watermelon":
                if (size.equals("small")) {
                    price = 56 * amountSets * 2;
                } else {
                    price = 28.70 * amountSets * 5;
                }
                break;
            case "Mango":
                if (size.equals("small")) {
                    price = 36.66 * amountSets * 2;
                } else {
                    price = 19.60 * amountSets * 5;
                }
                break;
            case "Pineapple":
                if (size.equals("small")) {
                    price = 42.10 * amountSets * 2;
                } else {
                    price = 24.80 * amountSets * 5;
                }
                break;
            case "Raspberry":
                if (size.equals("small")) {
                    price = 20 * amountSets * 2;
                } else {
                    price = 15.20 * amountSets * 5;
                }
                break;
        }
        if (price > 1000) {
            price = price / 2;
        } else if (price >= 400) {
            price = price * 0.85;
        }
        System.out.printf("%.2f lv.", price);
    }
}
