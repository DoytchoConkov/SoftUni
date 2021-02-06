import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern=Pattern.compile("([$|%])(?<tag>[A-Z][a-z]{2,})\\1[:][ ][\\[](?<symbol1>[0-9]+)[\\]][\\|][\\[](?<symbol2>[0-9]+)[\\]][|][\\[](?<symbol3>[0-9]+)[\\]][\\|]");
        int n =Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher=pattern.matcher(input);
            if (matcher.find()){
                System.out.printf("%s: %c%c%c%n", matcher.group("tag"), Integer.parseInt(matcher.group("symbol1")), Integer.parseInt(matcher.group("symbol2")), Integer.parseInt(matcher.group("symbol3")));
            }else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
