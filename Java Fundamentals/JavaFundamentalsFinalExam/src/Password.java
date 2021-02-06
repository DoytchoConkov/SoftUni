import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Pattern pattern = Pattern.compile("([^\\>]+)[>](?<numbers>[0-9]{3})[|](?<leters1>[a-z]{3})[|](?<leters2>[A-Z]{3})[|](?<symbols>[^\\<]{3})[<]\\1");
        for (int i = 0; i < n; i++) {
            String password = scan.nextLine();
            Matcher matcher = pattern.matcher(password);
            if (matcher.find()) {
                String result = matcher.group("numbers") + matcher.group("leters1") + matcher.group("leters2") + matcher.group("symbols");
                System.out.printf("Password: %s%n", result);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
