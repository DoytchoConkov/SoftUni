import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String minRatingMovie = "";
        String maxRatingMovie = "";
        double avgRating = 0;
        double minRating = 11;
        double maxRating = 0;
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String movie = scan.nextLine();
            double rating = Double.parseDouble(scan.nextLine());
            avgRating += rating;
            if (rating > maxRating) {
                maxRating = rating;
                maxRatingMovie = movie;
            }
            if (rating < minRating) {
                minRating = rating;
                minRatingMovie = movie;
            }
        }
        System.out.printf("%s is with highest rating: %.1f%n", maxRatingMovie, maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n", minRatingMovie, minRating);
        System.out.printf("Average rating: %.1f", avgRating / n);
    }
}
