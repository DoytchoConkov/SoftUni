import java.util.Scanner;

public class MovieDestination {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String destination = scan.nextLine();
        String season = scan.nextLine();
        int days = Integer.parseInt(scan.nextLine());
        double price = 0;
        switch (destination) {
            case "Dubai":
                switch (season) {
                    case "Winter":
                        price = 45000;
                        break;
                    case "Summer":
                        price = 40000;
                        break;
                }
                break;
            case "Sofia":
                switch (season) {
                    case "Winter":
                        price = 17000;
                        break;
                    case "Summer":
                        price = 12500;
                        break;
                }
                break;
            case "London":
                switch (season) {
                    case "Winter":
                        price = 24000;
                        break;
                    case "Summer":
                        price = 20250;
                        break;
                }
                break;
        }
        double totalPrice = price * days;
        if (destination.equals("Dubai")) {
            totalPrice = totalPrice * 0.7;
        }
        if (destination.equals("Sofia")) {
            totalPrice = totalPrice * 1.25;
        }
        if (totalPrice <= budget) {
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", budget - totalPrice);
        } else {
            System.out.printf("The director needs %.2f leva more!", totalPrice - budget);
        }
    }
}
