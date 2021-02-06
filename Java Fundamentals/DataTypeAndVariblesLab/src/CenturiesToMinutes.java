import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int century = Integer.parseInt(scan.nextLine());
        int year = century * 100;
        int days = (int) (year * 365.2422);
        int hours = days * 24;
        int minutes = hours * 60;
        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", century, year, days, hours, minutes);
    }
}
