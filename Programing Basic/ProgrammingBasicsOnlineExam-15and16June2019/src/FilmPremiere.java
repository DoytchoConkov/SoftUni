import java.util.Scanner;

public class FilmPremiere {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String movie = scan.nextLine();
        String packet = scan.nextLine();
        int tikets = Integer.parseInt(scan.nextLine());
        double price = 0;
        switch (movie) {
            case "John Wick":
                switch (packet) {
                    case "Drink":
                        price = 12;
                        break;
                    case "Popcorn":
                        price = 15;
                        break;
                    case "Menu":
                        price = 19;
                        break;
                }
                break;
            case "Star Wars":
                switch (packet) {
                    case "Drink":
                        price = 18;
                        break;
                    case "Popcorn":
                        price = 25;
                        break;
                    case "Menu":
                        price = 30;
                        break;
                }
                break;
            case "Jumanji":
                switch (packet) {
                    case "Drink":
                        price = 9;
                        break;
                    case "Popcorn":
                        price = 11;
                        break;
                    case "Menu":
                        price = 14;
                        break;
                }
                break;
        }
        double totalPrice = price * tikets;
        if (movie.equals("Star Wars") && tikets >= 4) {
            totalPrice = totalPrice * 0.7;
        }
        if (movie.equals("Jumanji") && tikets == 2) {
            totalPrice = totalPrice * 0.85;
        }
        System.out.printf("Your bill is %.2f leva.", totalPrice);
    }
}
