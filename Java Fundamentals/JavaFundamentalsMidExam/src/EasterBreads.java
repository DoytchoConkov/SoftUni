import java.util.Scanner;

public class EasterBreads {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        double floorPricePer1kg = Double.parseDouble(scan.nextLine());

        double eggPrice = floorPricePer1kg * 0.75;
        double milkPricePerLiter = floorPricePer1kg * 1.25;

        double easterBreadPrice = floorPricePer1kg + eggPrice + milkPricePerLiter / 4;

        int easterBread = (int) Math.floor(budget / easterBreadPrice);

        int eggs = 0;

        for (int i = 1; i <= easterBread; i++) {
            eggs = eggs + 3;
            if (i % 3 == 0) {
                eggs = eggs - (i - 2);
            }
        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", easterBread, eggs, budget - easterBreadPrice * easterBread);
    }
}
