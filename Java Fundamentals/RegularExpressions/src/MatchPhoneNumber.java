import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("\\+359([ -])2\\1[0-9]{3}\\1[0-9]{4}\\b");
        List<String > phoneNumbers=new ArrayList<>();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            phoneNumbers.add(matcher.group(0));
        }
        System.out.println(phoneNumbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
