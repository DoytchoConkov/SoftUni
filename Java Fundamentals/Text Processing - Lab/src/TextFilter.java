import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(", ");
        String text = scan.nextLine();
        for (String token : tokens) {
            String filter = starsMask(token);
            text = text.replace(token, filter);
        }
        System.out.println(text);
    }

    private static String starsMask(String token) {
        String stars = "";
        for (int i = 0; i < token.length(); i++) {
            stars += "*";
        }
        return stars;
    }
}
