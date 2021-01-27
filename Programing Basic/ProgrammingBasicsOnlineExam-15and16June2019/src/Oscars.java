import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        double points = Double.parseDouble(scan.nextLine());
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String jury = scan.nextLine();
            double givePints = Double.parseDouble(scan.nextLine());
            points += jury.length() * givePints / 2;
            if (points > 1250.5) {
                break;
            }
        }
        if (points > 1250.5) {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", name, points);
        } else {
            System.out.printf("Sorry, %s you need %.1f more!", name, 1250.5 - points);
        }

    }
}
