import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int group = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();
        String day = scan.nextLine();
        double price = 0;
        switch (type) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                if (group >= 30) {
                    price = price * 0.85;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16.00;
                        break;
                }
                if (group >= 100) {
                    price = price * (group-10)/group;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15.00;
                        break;
                    case "Saturday":
                        price = 20.00;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                if (group >= 10 && group <= 20) {
                    price = price * 0.95;
                }
                break;
        }
        double totalPrice = price * group;
        String text = String.format("Total price: %.2f", totalPrice);
        System.out.println(text);
    }
}
