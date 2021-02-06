import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();
        String input = scan.nextLine();
        while (!"Complete".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Make":
                    if ("Upper".equals(tokens[1])) {
                        email = email.toUpperCase();
                    } else {
                        email = email.toLowerCase();
                    }
                    System.out.println(email);
                    break;
                case "GetDomain":
                    String domain = "";
                    for (int i = email.length() - Integer.parseInt(tokens[1]); i < email.length(); i++) {
                        domain += email.charAt(i);
                    }
                    System.out.println(domain);
                    break;
                case "GetUsername":
                    String userName = "";
                    boolean flag = false;
                    for (int i = 0; i < email.length(); i++) {
                        if (email.charAt(i) == '@') {
                            flag = true;
                            break;
                        }
                        userName += email.charAt(i);
                    }
                    if (flag) {
                        System.out.println(userName);
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    }
                    break;
                case "Replace":
                    String result = "";
                    for (int i = 0; i < email.length(); i++) {
                        if (email.charAt(i) == tokens[1].charAt(0)) {
                            result += "-";
                        } else {
                            result += email.charAt(i);
                        }
                    }
                    System.out.println(result);
                    break;
                case "Encrypt":
                    for (int i = 0; i < email.length(); i++) {
                        int code = email.charAt(i);
                        System.out.printf("%d ", code);
                    }
                    System.out.println();
                    break;
            }

            input = scan.nextLine();
        }
    }
}
