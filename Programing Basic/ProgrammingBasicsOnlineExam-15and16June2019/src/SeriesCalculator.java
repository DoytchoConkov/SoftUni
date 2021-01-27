import java.util.Scanner;

public class SeriesCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String serial = scan.nextLine();
        int seasons = Integer.parseInt(scan.nextLine());
        int episodes = Integer.parseInt(scan.nextLine());
        double duration = Double.parseDouble(scan.nextLine());
        double totalTime = duration * seasons * episodes * 1.2 + seasons * 10;
        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", serial, Math.floor(totalTime));
    }
}
