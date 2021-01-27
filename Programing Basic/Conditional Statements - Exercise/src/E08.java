import java.util.Scanner;

public class E08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double income = Double.parseDouble(scan.nextLine());
        double averageSuccess = Double.parseDouble(scan.nextLine());
        double minimumSalary = Double.parseDouble(scan.nextLine());

        double socialSolarship = 0;
        double solarship = 0;

        if (income < minimumSalary) {
            if (averageSuccess > 4.5) {
                socialSolarship = minimumSalary * 0.35;
            }
        }

        if (averageSuccess >= 5.50) {
            solarship = averageSuccess * 25;
        }
        if (socialSolarship + solarship == 0) {
            System.out.println("You cannot get a scholarship!");
        } else if (socialSolarship > solarship) {
            System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(socialSolarship));
        } else if (solarship >= socialSolarship) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(solarship));
        }
    }
}
