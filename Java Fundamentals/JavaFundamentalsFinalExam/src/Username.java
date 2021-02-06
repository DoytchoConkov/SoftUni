import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String input = scan.nextLine();
        while (!"Sign up".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Case":
                    if ("lower".equals(tokens[1])) {
                        username = username.toLowerCase();
                    } else {
                        username = username.toUpperCase();
                    }
                    System.out.println(username);
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]) + 1;
                    if (startIndex >= 0 && startIndex < username.length() && startIndex < endIndex && endIndex > 0 && endIndex < username.length()) {
                        String result = username.substring(startIndex, endIndex);
                        for (int i = result.length() - 1; i >= 0; i--) {
                            System.out.printf("%c", result.charAt(i));
                            ;
                        }
                        System.out.println();
                    }
                    break;
                case "Cut":
                    if (username.contains(tokens[1])) {
                        username = username.replace(tokens[1], "");
                        System.out.println(username);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", username, tokens[1]);
                    }
                    break;
                case "Replace":
                    username = username.replace(tokens[1].charAt(0), '*');
                    System.out.println(username);
                    break;
                case "Check":
                    if (username.contains(tokens[1])) {
                        System.out.println("Valid");
                    } else {
                        System.out.printf("Your username must contain %s.%n", tokens[1]);
                    }
                    break;
            }

            input = scan.nextLine();
        }
    }
}
