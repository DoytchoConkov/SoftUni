import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();
        String password = "";
        for (int i = userName.length() - 1; i >= 0; i--) {
            password = password + userName.charAt(i);
        }
        int counter = 0;
        String input = scan.nextLine();
        while (!input.equals(password)) {
            counter++;
            if (counter == 4) {
                System.out.println("User " + userName + " blocked!");
                break;
            }
            if (counter < 4) {
            System.out.println("Incorrect password. Try again.");}
            input = scan.nextLine();
        }
        if (counter < 4) {
            System.out.println("User " + userName + " logged in.");
        }
    }
}
