import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SongEncryption {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<name>[A-Z][a-z\\' ]+):(?<song>[A-Z ]+)");
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                if (matcher.group().equals(input)) {
                    int key = matcher.group("name").length();
                    String result = "";
                    for (int i = 0; i < matcher.group("name").length(); i++) {
                        int leter = 0;
                        if (Character.isLowerCase(matcher.group("name").charAt(i))) {
                            leter = (matcher.group("name").charAt(i) + key);
                            if (leter > 'z') {
                                leter -= 26;
                            }
                            result += (char) leter;
                        } else if (Character.isUpperCase(matcher.group("name").charAt(i))) {
                            leter = (matcher.group("name").charAt(i) + key);
                            if (leter > 'Z') {
                                leter -= 26;
                            }
                            result += (char) leter;
                        } else {
                            result += (char) (matcher.group("name").charAt(i));
                        }
                    }
                    result += "@";
                    for (int i = 0; i < matcher.group("song").length(); i++) {
                        int leter = 0;
                        if (Character.isUpperCase(matcher.group("song").charAt(i))) {
                            leter = (matcher.group("song").charAt(i) + key);
                            if (leter > 'Z') {
                                leter -= 26;
                            }
                            result += (char) leter;
                        } else {
                            result += (char) (matcher.group("song").charAt(i));
                        }
                    }
                    System.out.printf("Successful encryption: %s%n", result);
                }else{
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scan.nextLine();
        }
    }
}
