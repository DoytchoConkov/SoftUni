import java.util.Scanner;

public class HoneyHarvest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String flowerType = scan.nextLine();
        int flowerCount = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        double honeyPerFlower = 0;
        switch (flowerType) {
            case "Sunflower":
                switch (season) {
                    case "Spring":
                        honeyPerFlower = 10;
                        break;
                    case "Summer":
                        honeyPerFlower = 8;
                        break;
                    case "Autumn":
                        honeyPerFlower = 12;
                        break;
                }
                break;
            case "Daisy":
            case "Lavender":
                switch (season) {
                    case "Spring":
                        honeyPerFlower = 12;
                        break;
                    case "Summer":
                        honeyPerFlower = 8;
                        break;
                    case "Autumn":
                        honeyPerFlower = 6;
                        break;
                }
                break;
            case "Mint":
                switch (season) {
                    case "Spring":
                        honeyPerFlower = 10;
                        break;
                    case "Summer":
                        honeyPerFlower = 12;
                        break;
                    case "Autumn":
                        honeyPerFlower = 6;
                        break;
                }
                break;
        }
        double totalHoney = honeyPerFlower * flowerCount;
        if ("Summer".equals(season)) {
            totalHoney = totalHoney * 1.1;
        }
        if ("Autumn".equals(season)) {
            totalHoney = totalHoney * 0.95;
        }
        if ("Spring".equals(season)) {
            if ("Daisy".equals(flowerType) || "Mint".equals(flowerType)) {
                totalHoney = totalHoney * 1.1;
            }
        }
        System.out.printf("Total honey harvested: %.2f", totalHoney);
    }
}
