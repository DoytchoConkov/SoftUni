import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        boolean isLenght = passwordLenght(password);
        boolean isLetterDigits = passwordLetersDigits(password);
        boolean isHave2Digits = password2Digits(password);
        if (isLenght&&isHave2Digits&&isLetterDigits){
            System.out.println("Password is valid");
        }
    }

    private static boolean password2Digits(String password) {
        int cnt = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                cnt++;
            }
        }
        if (cnt >= 2) {
            return true;
        }
        System.out.println("Password must have at least 2 digits");
        return false;
    }


    private static boolean passwordLetersDigits(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                System.out.println("Password must consist only of letters and digits");
                return false;
            }
        }
        return true;
    }

    private static boolean passwordLenght(String password) {
        int lengt = password.length();
        if (lengt >= 6 && lengt <= 10) {
            return true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }
}
