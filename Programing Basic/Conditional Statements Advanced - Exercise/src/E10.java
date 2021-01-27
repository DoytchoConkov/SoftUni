import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String typeYear = scan.nextLine();
        int holidays = Integer.parseInt(scan.nextLine());
        int weekendsInProvince = Integer.parseInt(scan.nextLine());
        double dayInSofiaPlay = (48 - weekendsInProvince) * 3.0 / 4;
        double playWeekends = 2.0 / 3 * holidays;
        double dayForPlay = dayInSofiaPlay + playWeekends + weekendsInProvince;
        if (typeYear.equals("leap")) {
            dayForPlay = dayForPlay * 1.15;
        }
        System.out.printf("%.0f",Math.floor(dayForPlay));
    }
}
