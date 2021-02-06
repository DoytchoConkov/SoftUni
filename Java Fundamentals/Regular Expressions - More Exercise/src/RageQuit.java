import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Integer> letters = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("(?<text>\\D+)(?<cnt>\\d+)");
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            for (int i = 0; i < Integer.parseInt(matcher.group("cnt")); i++) {
                sb.append(matcher.group("text").toUpperCase());
            }
            for (int i = 0; i < matcher.group("text").length(); i++) {
                letters.putIfAbsent(String.valueOf(matcher.group("text").toUpperCase().charAt(i)), 1);
            }
        }
        System.out.printf("Unique symbols used: %d%n", letters.size());
        System.out.println(sb);
    }
}
