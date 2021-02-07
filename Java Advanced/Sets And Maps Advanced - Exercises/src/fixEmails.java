import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class fixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> validEmails = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("stop")) {
            String userEmail = scan.nextLine();
            String[] token = userEmail.split("\\.");
            if (!token[1].equalsIgnoreCase("uk") && !token[1].equalsIgnoreCase("us") && !token[1].equalsIgnoreCase("com")) {
                validEmails.put(input, userEmail);
            }
            input = scan.nextLine();
        }
        validEmails.entrySet().stream().forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));
    }
}
