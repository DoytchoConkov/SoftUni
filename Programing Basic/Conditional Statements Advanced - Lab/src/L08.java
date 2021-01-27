import java.util.Scanner;

public class L08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fruit = scan.nextLine();
        String day = scan.nextLine();
        double amount = Double.parseDouble(scan.nextLine());
        double price = 0;
        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                if (fruit.equals("banana")) {
                    price = amount * 2.5;
                } else if (fruit.equals("apple")) {
                    price = amount * 1.2;
                } else if (fruit.equals("orange")) {
                    price = amount * 0.85;
                } else if (fruit.equals("grapefruit")) {
                    price = amount * 1.45;
                } else if (fruit.equals("kiwi")) {
                    price = amount * 2.7;
                } else if (fruit.equals("pineapple")) {
                    price = amount * 5.5;
                } else if (fruit.equals("grapes")) {
                    price = amount * 3.85;
                }
                break;
            case "Saturday":
            case "Sunday":
                if (fruit.equals("banana")) {
                    price = amount * 2.7;
                } else if (fruit.equals("apple")) {
                    price = amount * 1.25;
                } else if (fruit.equals("orange")) {
                    price = amount * 0.90;
                } else if (fruit.equals("grapefruit")) {
                    price = amount * 1.60;
                } else if (fruit.equals("kiwi")) {
                    price = amount * 3.0;
                } else if (fruit.equals("pineapple")) {
                    price = amount * 5.6;
                } else if (fruit.equals("grapes")) {
                    price = amount * 4.2;
                }
                break;
        }
        if (price != 0) {

            System.out.printf("%.2f", price);
        } else {
            System.out.println("error");
        }
    }
}
