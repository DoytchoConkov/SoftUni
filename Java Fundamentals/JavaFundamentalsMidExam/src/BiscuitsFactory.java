import java.util.Scanner;

public class BiscuitsFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int biscuitsPerDayWorker = Integer.parseInt(scan.nextLine());
        int workers = Integer.parseInt(scan.nextLine());
        int otherFactory = Integer.parseInt(scan.nextLine());
        double biscuitsThirdDay = Math.floor(workers * biscuitsPerDayWorker * 0.75);
        double biscuitsPerMount = 20 * biscuitsPerDayWorker * workers + biscuitsThirdDay * 10;
        System.out.printf("You have produced %.0f biscuits for the past month.%n", biscuitsPerMount);
        if (biscuitsPerMount > otherFactory) {
            System.out.printf("You produce %.2f percent more biscuits.%n", 100.0 * (biscuitsPerMount - otherFactory) / otherFactory);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.%n", 100.0 * (otherFactory - biscuitsPerMount) / otherFactory);
        }
    }
}
