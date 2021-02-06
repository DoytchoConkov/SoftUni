import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();
        String password = "";
        for (int i = userName.length() - 1; i >= 0; i--) {
            password = password + userName.charAt(i);
        }
        System.out.println(password);
    }
}
