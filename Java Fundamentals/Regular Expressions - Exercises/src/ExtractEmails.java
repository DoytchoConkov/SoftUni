import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("(?<=\\s)([a-z]+|\\d+)(\\d+|\\w+|\\.+|-+)([a-z]+|\\d+)\\@[a-z]+\\-?[a-z]+\\.[a-z]+(\\.[a-z]+)?");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
