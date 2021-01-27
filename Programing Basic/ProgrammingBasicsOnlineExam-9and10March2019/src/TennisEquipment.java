import java.util.Scanner;

public class TennisEquipment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double tennisRacetPrice = Double.parseDouble(scan.nextLine());
        int racets = Integer.parseInt(scan.nextLine());
        int maratonks = Integer.parseInt(scan.nextLine());
        double sum = (racets * tennisRacetPrice + maratonks * tennisRacetPrice / 6) * 1.2;
        System.out.printf("Price to be paid by Djokovic %.0f%n", Math.floor(Math.ceil(sum) / 8));
        System.out.printf("Price to be paid by sponsors %.0f", Math.ceil(sum * 7 / 8));
    }
}
