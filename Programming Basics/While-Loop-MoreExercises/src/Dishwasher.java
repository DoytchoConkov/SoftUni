import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bottles = Integer.parseInt(scan.nextLine());
            int detergentInMl = bottles * 750;
        String imput = scan.nextLine();
        int dishesCnt = 0;
        int potsCnt = 0;
        int counter = 1;
        while (!imput.equals("End")) {
            int pieces = Integer.parseInt(imput);
            if (counter < 3) {
                detergentInMl = detergentInMl - pieces * 5;
                dishesCnt = dishesCnt + pieces;
                counter++;
            } else {
                detergentInMl = detergentInMl - pieces * 15;
                potsCnt = potsCnt + pieces;
                counter = 1;
            }
            if (detergentInMl < 0) {
                break;
            }
            imput = scan.nextLine();
        }
        if (detergentInMl < 0) {
              System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(detergentInMl));
        } else {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", dishesCnt, potsCnt);
            System.out.printf("Leftover detergent %d ml.", detergentInMl);
        }
    }
}
