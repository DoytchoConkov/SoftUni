import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalFood = Integer.parseInt(scan.nextLine()) * 1000;
        String imput = scan.nextLine();
        while (!imput.equals("Adopted")) {
            totalFood = totalFood - Integer.parseInt(imput);
            imput = scan.nextLine();
        }
        if (totalFood >= 0 ) {
            System.out.printf("Food is enough! Leftovers: %d grams.", totalFood);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", Math.abs(totalFood));
        }
    }
}
