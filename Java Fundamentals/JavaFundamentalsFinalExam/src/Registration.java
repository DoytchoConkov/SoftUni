import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int cnt = 0;
        Pattern pattern = Pattern.compile("[U][$](?<name>[A-Z][a-z]{2,})[U][$][P][@][$](?<password>[A-Za-z]{5,}[0-9]+)[P][@][$]");
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                cnt++;
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", matcher.group("name"), matcher.group("password"));
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d", cnt);
    }
}
