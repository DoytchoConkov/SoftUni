import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String isDigit = "";
        String isLetter = "";
        String isOther = "";
        String input = scan.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                isDigit += String.valueOf(input.charAt(i));
            } else if (Character.isLetter(input.charAt(i))) {
                isLetter += String.valueOf(input.charAt(i));
            } else {
                isOther += String.valueOf(input.charAt(i));
            }
        }
        System.out.println(isDigit);
        System.out.println(isLetter);
        System.out.println(isOther);
    }
}
