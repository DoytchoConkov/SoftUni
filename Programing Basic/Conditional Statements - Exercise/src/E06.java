import java.util.Scanner;

public class E06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budjet = Double.parseDouble(scan.nextLine());
        int statists = Integer.parseInt(scan.nextLine());
        double clothingPrice = Double.parseDouble(scan.nextLine());
        double decors = budjet * 0.1;
        double totalClothingPrice = clothingPrice * statists;
        if (statists > 150) {
            totalClothingPrice = totalClothingPrice * 0.9;
        }
        if ((totalClothingPrice + decors) > budjet) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", (totalClothingPrice + decors - budjet));
        }else{
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budjet - totalClothingPrice - decors);
        }

    }
}
