import java.util.Scanner;

public class E08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String fuelType = scan.nextLine();
        double literInTank = Double.parseDouble(scan.nextLine());
        boolean flag = false;
        if (literInTank < 25) {
            flag = true;
        }
        switch (fuelType) {
            case "Diesel":
                if (flag) {
                    System.out.println("Fill your tank with diesel!");
                } else {
                    System.out.println("You have enough diesel.");
                }
                break;
            case "Gasoline":
                if (flag) {
                    System.out.println("Fill your tank with gasoline!");
                } else {
                    System.out.println("You have enough gasoline.");
                }
                break;
            case "Gas":
                if (flag) {
                    System.out.println("Fill your tank with gas!");
                } else {
                    System.out.println("You have enough gas.");
                }
                break;
            default:
                System.out.println("Invalid fuel!");
                break;
        }

    }
}
