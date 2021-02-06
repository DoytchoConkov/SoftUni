import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double journey = Double.parseDouble(scan.nextLine());
        int mounts = Integer.parseInt(scan.nextLine());
        double sum = 0;
        for (int i = 1; i <= mounts; i++) {
            if (i % 2 != 0 && i > 1) {
                sum -= sum * 0.16;
            }
            if (i % 4 == 0) {
                sum += sum * 0.25;
            }
            sum += journey * 0.25;
        }
        if (sum > journey) {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", sum - journey);
        } else {
            System.out.printf("Sorry. You need %.2flv. more.", journey - sum);
        }
    }
}
