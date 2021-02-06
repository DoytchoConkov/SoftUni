import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Pattern pattern = Pattern.compile("([#@]+)(?<left>[A-Za-z]{3,})\\1\\1(?<right>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);
        List<String> pairs = new ArrayList<>();
        int pairsCnt = 0;
        int cnt = 0;
        while (matcher.find()) {
            cnt++;
            boolean flag = true;
            if (matcher.group("left").length() == matcher.group("right").length()) {
                for (int i = 0; i < matcher.group("left").length(); i++) {
                    if (matcher.group("left").charAt(i) != matcher.group("right").charAt(matcher.group("right").length() - 1 - i)) {
                        flag = false;
                    }
                }
            } else {
                flag = false;
            }
            if (flag) {
                pairs.add(matcher.group("left") + " <=> " + matcher.group("right"));
                pairsCnt++;
            }
        }
        if (cnt == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", cnt);
        }
        if (pairsCnt > 0) {
            System.out.println("The mirror words are:");
            System.out.println(pairs.toString().replaceAll("[\\[\\]]", ""));
        } else {
            System.out.println("No mirror words!");
        }
    }
}
