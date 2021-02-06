import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int key = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            StringBuilder decoded = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                decoded.append((char) (input.charAt(i) - key));
            }
            Pattern pattern = Pattern.compile("@(?<name>[A-Za-z]+)[^@\\-!:>]*!(?<status>[GN])!");
            Matcher matcher = pattern.matcher(decoded.toString());
            if (matcher.find()) {
                if (matcher.group("status").equals("G")) {
                    System.out.println(matcher.group("name"));
                }
            }
            input = scan.nextLine();
        }
    }
}
