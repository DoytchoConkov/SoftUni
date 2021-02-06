import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Pattern pattern = Pattern.compile("[!](?<comand>[A-Z][a-z]{2,})[!][:][\\[](?<text>[A-Za-z]{8,})[\\]]");
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.printf("%s:", matcher.group("command"));
                for (int j = 0; j < matcher.group("text").length(); j++) {
                    int value=matcher.group("text").charAt(j);
                    System.out.printf(" %d",value);
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
