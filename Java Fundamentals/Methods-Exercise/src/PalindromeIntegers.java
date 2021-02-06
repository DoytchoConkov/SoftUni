import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!"END".equals(input)) {
            if (palindrome(input)) {
                System.out.println(true);
            } else {
                System.out.println("false");
            }
            input = scan.nextLine();
        }
    }


    private static boolean palindrome(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
