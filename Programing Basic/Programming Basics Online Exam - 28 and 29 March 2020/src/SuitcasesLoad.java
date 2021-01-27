import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double totalVolume = Double.parseDouble(scan.nextLine());
        String imput = scan.nextLine();
        int suitcases = 0;
        int couunt = 0;
        while (!imput.equals("End")) {
            couunt++;
            if (couunt == 3) {
                couunt = 0;
                totalVolume = totalVolume - Double.parseDouble(imput) * 1.1;
            } else {
                totalVolume = totalVolume - Double.parseDouble(imput);
            }
            if (totalVolume < 0) {
                break;
            }
            suitcases++;
            imput = scan.nextLine();
        }
        if (totalVolume < 0) {
            System.out.println("No more space!");
        } else {
            System.out.println("Congratulations! All suitcases are loaded!");
        }
        System.out.printf("Statistic: %d suitcases loaded.", suitcases);
    }
}
