import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, Integer> emogies = new LinkedHashMap<>();
        int cool = 1;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                cool = cool * Integer.parseInt(String.valueOf((char) input.charAt(i)));
            }
        }
        System.out.printf("Cool threshold: %d%n", cool);
        Pattern pattern = Pattern.compile("(?<emog>([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\2)");
        Matcher matcher = pattern.matcher(input);
        int cnt=0;
        while (matcher.find()) {
            String emogy = matcher.group("emog");
            int emogyCool = 0;
            for (int i = 0; i < emogy.length(); i++) {
                emogyCool += emogy.charAt(i);
            }
            if (emogyCool > cool) {
                emogies.put(emogy, emogyCool);
            }
            cnt++;
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n",cnt);
        emogies
                .entrySet()
                .stream()
                .forEach(e->{
            System.out.println(e.getKey());
        });
    }
}
