import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([@|*])(?<tag>[A-Z][a-z]{2,})\\1[:][ ][\\[](?<symbol1>[A-Za-z]+)[\\]][\\|][\\[](?<symbol2>[A-Za-z]+)[\\]][|][\\[](?<symbol3>[A-Za-z]+)[\\]][\\|][\n]]");
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.printf("%s: %d %d %d%n", matcher.group("tag"), (int) matcher.group("symbol1").charAt(0), (int) matcher.group("symbol2").charAt(0), (int) matcher.group("symbol3").charAt(0));
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
