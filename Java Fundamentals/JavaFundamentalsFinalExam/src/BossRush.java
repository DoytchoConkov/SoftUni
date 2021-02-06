import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[|](?<name>[A-Z]+)[|][:][#](?<title>[A-Za-z]+[ ][A-Za-z]+)[#]");
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.printf("%s, The %s%n", matcher.group("name"), matcher.group("title"));
                System.out.printf(">> Strength: %d%n", matcher.group("name").length());
                System.out.printf(">> Armour: %d%n", matcher.group("title").length());
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}
