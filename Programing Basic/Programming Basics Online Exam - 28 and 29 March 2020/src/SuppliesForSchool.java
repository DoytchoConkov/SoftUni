import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pencils = Integer.parseInt(scan.nextLine());
        int markers = Integer.parseInt(scan.nextLine());
        double litresCleaner = Double.parseDouble(scan.nextLine());
        double discountPrice = Double.parseDouble(scan.nextLine());
        double pencilsPrice = pencils * 5.80;
        double markersPrice = markers * 7.20;
        double cleamerPrice = litresCleaner * 1.20;
        double sum = pencilsPrice + markersPrice + cleamerPrice;
        sum = sum * (100 - discountPrice) / 100;
        System.out.printf("%.3f", sum);
    }
}
