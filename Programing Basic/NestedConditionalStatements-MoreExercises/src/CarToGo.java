import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String carType = "";
        double carPrice = 0;
        String carClass = "";
        if (budget <= 100) {
            carClass = "Economy class";
            if (season.equals("Summer")) {
                carType = "Cabrio";
                carPrice = 0.35 * budget;
            } else {
                carType = "Jeep";
                carPrice = 0.65 * budget;
            }
        } else if (budget <= 500) {
            carClass = "Compact class";
            if (season.equals("Summer")) {
                carType = "Cabrio";
                carPrice = 0.45 * budget;
            } else {
                carType = "Jeep";
                carPrice = 0.8 * budget;
            }
        } else {
            carClass = "Luxury class";
            carType = "Jeep";
            carPrice = 0.9 * budget;
        }
        System.out.println(carClass);
        System.out.printf("%s - %.2f", carType, carPrice);
    }
}
