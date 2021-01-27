import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double recordInSecond = Double.parseDouble(scan.nextLine());
        double distanceInMeters = Double.parseDouble(scan.nextLine());
        double secondPerMeter = Double.parseDouble(scan.nextLine());

        double timeGeorgy = secondPerMeter * distanceInMeters + Math.floor(distanceInMeters / 50) * 30;
        if (timeGeorgy < recordInSecond) {
            System.out.printf(" Yes! The new record is %.2f seconds.", timeGeorgy);
        } else {
            System.out.printf("No! He was %.2f seconds slower.", timeGeorgy-recordInSecond);
        }
    }
}
