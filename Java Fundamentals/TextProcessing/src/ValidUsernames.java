import java.util.Scanner;


public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] usernames = scan.nextLine().split(", ");
        for (String username : usernames) {
            if (isValid(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValid(String username) {
        if (username.length() < 3 || username.length() > 16) {
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            if (!Character.isLetter(username.charAt(i)) && !Character.isDigit(username.charAt(i)) && username.charAt(i) != '-' && username.charAt(i) != '_') {
                return false;
            }
        }
        return true;
    }
}
