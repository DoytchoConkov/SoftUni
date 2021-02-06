import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostOffice {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split("\\|");
        Pattern patternCode = Pattern.compile("([#$%*&])(?<code>[A-Z]+)\\1");
        Matcher matcherCode = patternCode.matcher(tokens[0]);
        if (matcherCode.find()) {
            for (int i = 0; i < matcherCode.group("code").length(); i++) {
                Pattern patternLocation = Pattern.compile("(?<asci>[0-9][0-9]):(?<lenght>[0-9][0-9])");
                Matcher matcherLocation = patternLocation.matcher(tokens[1]);
                String[] words = tokens[2].split("\\s+");
                while (matcherLocation.find()) {
                    if (matcherLocation.group("asci").equals(String.valueOf(matcherCode.group("code").charAt(i) + 0))) {
                        for (int j = 0; j < words.length; j++) {
                            // System.out.println(words[j].length() + " " + words[j] + " " + matcherCode.group("code").charAt(i)
                            // +" "+(Integer.parseInt(matcherLocation.group("lenght") )+ 1));
                            if (words[j].length() == (Integer.parseInt(matcherLocation.group("lenght") )+ 1) &&
                                    words[j].charAt(0) == matcherCode.group("code").charAt(i)) {
                                System.out.println(words[j]);
                                break;
                            }
                        }


                        break;
                    }
                }
            }
        }
        System.out.println();
    }
}
