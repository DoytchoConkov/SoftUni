import java.util.Scanner;

public class Gymnastics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String country = scan.nextLine();
        String appliance = scan.nextLine();
        double dificult = 0;
        double mark = 0;
        switch (country) {
            case "Russia":
                switch (appliance) {
                    case "ribbon":
                        dificult = 9.1;
                        mark = 9.4;
                        break;
                    case "hoop":
                        dificult = 9.3;
                        mark = 9.8;
                        break;
                    case "rope":
                        dificult = 9.6;
                        mark = 9;
                        break;
                }
                break;
            case "Bulgaria":
                switch (appliance) {
                    case "ribbon":
                        dificult = 9.6;
                        mark = 9.4;
                        break;
                    case "hoop":
                        dificult = 9.55;
                        mark = 9.75;
                        break;
                    case "rope":
                        dificult = 9.5;
                        mark = 9.4;
                        break;
                }
                break;
            case "Italy":
                switch (appliance) {
                    case "ribbon":
                        dificult = 9.2;
                        mark = 9.5;
                        break;
                    case "hoop":
                        dificult = 9.45;
                        mark = 9.35;
                        break;
                    case "rope":
                        dificult = 9.7;
                        mark = 9.15;
                        break;
                }
                break;
        }
        System.out.printf("The team of %s get %.3f on %s.%n", country, dificult + mark, appliance);
        System.out.printf("%.2f%%", (20 - dificult - mark) * 5);
    }
}
