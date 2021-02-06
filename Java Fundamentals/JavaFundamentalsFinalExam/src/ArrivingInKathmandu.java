import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!"Last note".equals(input)) {
            boolean flag = false;
            Pattern pattern = Pattern.compile("(?<name>[A-Za-z!@#$?]+)=(?<lenght>[0-9]+)");
            String[] tokens = input.split("<<", 2);
            Matcher matcher = pattern.matcher(tokens[0]);
            if (matcher.find() && tokens.length > 1) {
                int lenght = Integer.parseInt(matcher.group("lenght"));
                if (lenght == tokens[1].length()) {
                    String result = "";
                    String name = matcher.group("name");
                    for (int i = 0; i < name.length(); i++) {
                        if (Character.isLetter(name.charAt(i))) {
                            result += (char) name.charAt(i);
                        }
                    }
                    if (result.length() > 0) {
                        System.out.printf("Coordinates found! %s -> %s%n", result, tokens[1]);
                        flag = true;
                    }
                }
            }
            if (!flag) {
                System.out.println("Nothing found!");
            }
            input = scan.nextLine();
        }
    }
}
