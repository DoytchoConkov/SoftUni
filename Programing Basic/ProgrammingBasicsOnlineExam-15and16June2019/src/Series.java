import java.util.Scanner;

public class Series {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalPrice = 0;
        double budget = Double.parseDouble(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String serial = scan.nextLine();
            double price = Double.parseDouble(scan.nextLine());
            switch (serial) {
                case "Thrones":
                    price = price * 0.5;
                    break;
                case "Lucifer":
                    price = price * 0.6;
                    break;
                case "Protector":
                    price = price * 0.7;
                    break;
                case "TotalDrama":
                    price = price * 0.8;
                    break;
                case "Area":
                    price = price * 0.9;
                    break;
            }
            totalPrice += price;
        }
        if (budget >= totalPrice) {
            System.out.printf("You bought all the series and left with %.2f lv.", budget - totalPrice);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!", totalPrice - budget);
        }

    }
}
