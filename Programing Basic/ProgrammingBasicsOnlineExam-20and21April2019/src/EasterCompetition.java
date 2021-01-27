import java.util.Scanner;

public class EasterCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maxPoint = Integer.MIN_VALUE;
        String maxPointsName = "";
        int cakes = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < cakes; i++) {
            int totalPoint = 0;
            String bakerName = scan.nextLine();
            String imput = scan.nextLine();
            while (!imput.equals("Stop")) {
                int points = Integer.parseInt(imput);
                totalPoint = totalPoint + points;
                imput = scan.nextLine();
            }
            System.out.printf("%s has %d points.%n", bakerName, totalPoint);
            if (totalPoint > maxPoint) {
                maxPoint = totalPoint;
                maxPointsName = bakerName;
                System.out.printf("%s is the new number 1!%n", maxPointsName);
            }
        }
        System.out.printf("%s won competition with %d points!", maxPointsName, maxPoint);
    }
}
