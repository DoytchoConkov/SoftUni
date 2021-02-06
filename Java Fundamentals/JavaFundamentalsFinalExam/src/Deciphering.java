import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String code = scan.nextLine();
        String decodedText = "";
        for (int i = 0; i < text.length(); i++) {
            decodedText += ((char) (text.charAt(i) - 3));
        }
        String[] tokens = code.split(" ");
        decodedText = decodedText.replace(tokens[0], tokens[1]);
        Pattern pattern = Pattern.compile("[a-z\\{\\}\\|# ]+");
        Matcher matcher = pattern.matcher(decodedText);
        if (matcher.find() && matcher.group().length() == decodedText.length()) {
            System.out.println(decodedText);
        } else {
            System.out.println("This is not the book you are looking for.");
        }
    }
}
