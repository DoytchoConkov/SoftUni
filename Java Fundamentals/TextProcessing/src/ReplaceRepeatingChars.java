import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder result = new StringBuilder();
        char comparator = input.charAt(0);
        result.append(comparator);
        for (int i = 1; i < input.length(); i++) {
            char leter = input.charAt(i);
            if (comparator != leter) {
                result.append(leter);
                comparator = leter;
            }
        }
        System.out.println(result);
    }
}
