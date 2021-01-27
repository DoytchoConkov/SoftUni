import java.util.Scanner;

public class OscarsCeremony {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rentPrice = Integer.parseInt(scan.nextLine());
        double statuettes = rentPrice * 0.7;
        double catering = statuettes * 0.85;
        double sound = catering / 2;
        System.out.printf("%.2f", rentPrice + statuettes + catering + sound);

    }
}
