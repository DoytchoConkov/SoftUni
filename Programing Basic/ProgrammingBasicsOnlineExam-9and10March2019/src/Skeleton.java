import java.util.Scanner;

public class Skeleton {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int minutes = Integer.parseInt(scan.nextLine());
        int seconds = Integer.parseInt(scan.nextLine());
        double distance = Double.parseDouble(scan.nextLine());
        int timePer100 = Integer.parseInt(scan.nextLine());
        int time = minutes * 60 + seconds;
        double timeLost = distance / 120 * 2.5;
        double totalTime = distance / 100 * timePer100 - timeLost;
        if (totalTime <= time) {
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.", totalTime);
        } else {
            System.out.printf("No, Marin failed! He was %.3f second slower.", totalTime - time);
        }
    }
}
