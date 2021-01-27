import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        double totalFood = Double.parseDouble(scan.nextLine());
        int totalFoodDog = 0;
        int totalFoodCat = 0;
        double biscuits = 0;
        int count = 0;
        for (int i = 0; i < days; i++) {
            count++;
            int foodDog = Integer.parseInt(scan.nextLine());
            int foodCat = Integer.parseInt(scan.nextLine());
            if (count == 3) {
                count = 0;
                biscuits = biscuits + (foodCat + foodDog) * 0.1;
            }
            totalFoodCat = totalFoodCat + foodCat;
            totalFoodDog = totalFoodDog + foodDog;
        }
        System.out.printf("Total eaten biscuits: %dgr.%n", Math.round(biscuits));
        System.out.printf("%.2f%% of the food has been eaten.%n", (totalFoodDog + totalFoodCat) * 100.0 / totalFood);
        System.out.printf("%.2f%% eaten from the dog.%n", totalFoodDog * 100.0 / (totalFoodCat + totalFoodDog));
        System.out.printf("%.2f%% eaten from the cat.%n", totalFoodCat * 100.0 / (totalFoodCat + totalFoodDog));
    }
}
