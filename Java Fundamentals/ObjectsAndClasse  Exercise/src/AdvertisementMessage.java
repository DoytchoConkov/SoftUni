import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] prases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            String prase = prases[rnd.nextInt(prases.length)];
            String even = events[rnd.nextInt(events.length)];
            String author = authors[rnd.nextInt(authors.length)];
            String city = cities[rnd.nextInt(cities.length)];
            System.out.printf("%s %s %s - %s.%n", prase, even, author, city);
        }
    }
}
