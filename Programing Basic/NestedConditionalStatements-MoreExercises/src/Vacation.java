import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String placeType = "";
        double placePrice = 0;
        String placeClass = "";
        if (budget <= 1000) {
            placeClass = "Camp";
            if (season.equals("Summer")) {
                placeType = "Alaska";
                placePrice = 0.65 * budget;
            } else {
                placeType = "Morocco";
                placePrice = 0.45 * budget;
            }
        } else if (budget <= 3000) {
            placeClass = "Hut";
            if (season.equals("Summer")) {
                placeType = "Alaska";
                placePrice = 0.8 * budget;
            } else {
                placeType = "Morocco";
                placePrice = 0.6 * budget;
            }
        } else {
            placeClass = "Hotel";
            if (season.equals("Summer")) {
                placeType = "Alaska";
                placePrice = 0.9 * budget;
            } else {
                placeType = "Morocco";
                placePrice = 0.9 * budget;
            }
        }
        System.out.printf("%s - %s - %.2f", placeType, placeClass, placePrice);
    }
}
