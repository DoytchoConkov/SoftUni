import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = scan.nextLine();
        String input = scan.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "TakeOdd":
                    StringBuilder newText = new StringBuilder();
                    for (int i = 1; i < password.length(); i += 2) {
                        newText.append(password.charAt(i));
                    }
                    password = newText.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int lenght = Integer.parseInt(tokens[2]);
                    StringBuilder removeText = new StringBuilder();
                    removeText.append(password);
                    removeText.delete(startIndex, startIndex + lenght);
                    password = removeText.toString();
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    StringBuilder replaceText = new StringBuilder();
                    replaceText.append(password);
                    boolean flag = true;
                    while (replaceText.indexOf(substring) >= 0) {
                        replaceText.replace(replaceText.indexOf(substring), replaceText.indexOf(substring) + substring.length(), substitute);
                        flag = false;
                    }
                    if (flag) {
                        System.out.println("Nothing to replace!");
                    } else {
                        password = replaceText.toString();
                        System.out.println(password);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}
