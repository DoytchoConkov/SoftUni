import java.util.Scanner;

public class E06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budjet = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        double price = 0;
        String country = "";
        String place = "Hotel";
        switch (season) {
            case "summer":
                if (budjet <= 100) {
                    price = budjet * 0.3;
                    country = "Bulgaria";
                    place = "Camp";
                } else if (budjet <= 1000) {
                    price = budjet * 0.4;
                    country = "Balkans";
                    place = "Camp";
                } else {
                    price = budjet * 0.9;
                    country = "Europe";
                }
                break;
            case "winter":
                if (budjet <= 100) {
                    price = budjet * 0.7;
                    country = "Bulgaria";
                } else if (budjet <= 1000) {
                    price = budjet * 0.8;
                    country = "Balkans";
                } else {
                    price = budjet * 0.9;
                    country = "Europe";
                }
                break;
        }

        System.out.printf("Somewhere in %s%n", country);
        System.out.printf("%s – %.2f", place, price);
    }
}
