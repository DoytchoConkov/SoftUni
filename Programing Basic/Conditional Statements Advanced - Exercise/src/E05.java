import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int budjet = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        int peopels = Integer.parseInt(scan.nextLine());
        double price = 0;
        double discount = 1;

        switch (season) {
            case "Spring":
                price += 3000;
                break;
            case "Summer":
            case "Autumn":
                price += 4200;
                break;
            case "Winter":
                price += 2600;
                break;
        }
        if (!season.equals("Autumn") && peopels % 2 == 0) {
            discount = 0.95;
        }
        if (peopels < 7) {
            discount = discount * 0.9;
        } else if (peopels <= 11) {
            discount = discount * 0.85;
        } else {
            discount = discount * 0.75;
        }
        price = price * discount;
        if (budjet >= price) {
            System.out.printf("Yes! You have %.2f leva left.", budjet - price);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", price - budjet);
        }
    }
}
