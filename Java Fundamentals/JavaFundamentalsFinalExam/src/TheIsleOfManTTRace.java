import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfManTTRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        while (!flag) {
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile("([#$%*&])(?<name>[A-Za-z]+)\\1=(?<lenght>[0-9]+)");
            String[] tokens = input.split("!!",2);
            Matcher matcher = pattern.matcher(tokens[0]);
            if (matcher.find()&&tokens.length>1) {
                int lenght = Integer.parseInt(matcher.group("lenght"));
                if (lenght == tokens[1].length()) {
                    String result = "";
                    for (int i = 0; i < tokens[1].length(); i++) {
                        result += (char) (tokens[1].charAt(i) + lenght);
                    }
                    System.out.printf("Coordinates found! %s -> %s", matcher.group("name"), result);
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("Nothing found!");
            }
        }
    }
}
