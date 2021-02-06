import java.util.Scanner;

public class DistanceCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int steps = Integer.parseInt(scan.nextLine());
        double stepLength = Double.parseDouble(scan.nextLine());
        int distance = Integer.parseInt(scan.nextLine());
        double totalDistance = 0;
        for (int i = 1; i <= steps; i++) {
            if (i % 5 == 0) {
                totalDistance = totalDistance + 0.7 * stepLength;
            } else {
                totalDistance = totalDistance + stepLength;
            }
        }
        System.out.printf("You travelled %.2f%% of the distance!", totalDistance / distance);
    }
}
