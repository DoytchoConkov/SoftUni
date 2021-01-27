import java.util.Scanner;

public class E06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int foodKilograms = Integer.parseInt(scan.nextLine());
        double foodForDogPerDay = Double.parseDouble(scan.nextLine());
        double foodForCatPerDay = Double.parseDouble(scan.nextLine());
        double foodForTurtlePerDay = Double.parseDouble(scan.nextLine());
        double petTotalFood = days * foodForDogPerDay + days * foodForCatPerDay + days * foodForTurtlePerDay / 1000;
        if (petTotalFood <= foodKilograms) {
            System.out.printf("%.0f kilos of food left.", Math.floor(foodKilograms - petTotalFood));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(petTotalFood - foodKilograms));
        }
    }
}
