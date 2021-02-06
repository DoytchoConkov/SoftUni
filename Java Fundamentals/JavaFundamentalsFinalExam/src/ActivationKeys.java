import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String activationKey = scan.nextLine();
        String input = scan.nextLine();
        while (!"Generate".equals(input)) {
            String[] tokens = input.split(">>>");
            switch (tokens[0]) {
                case "Contains":
                    String substring = tokens[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    StringBuilder text = new StringBuilder();
                    int begin = Integer.parseInt(tokens[2]);
                    int end = Integer.parseInt(tokens[3]);
                    for (int i = 0; i < activationKey.length(); i++) {
                        if (i >= begin && i < end) {
                            if ("Upper".equals(tokens[1])) {
                                text.append(Character.toUpperCase(activationKey.charAt(i)));
                            } else {
                                text.append(Character.toLowerCase(activationKey.charAt(i)));
                            }
                        } else {
                            text.append((char) activationKey.charAt(i));
                        }
                    }
                    activationKey = text.toString();
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    StringBuilder slice = new StringBuilder();
                    slice.append(activationKey);
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    slice.replace(startIndex, endIndex, "");
                    activationKey = slice.toString();
                    System.out.println(activationKey);
                    break;
            }

            input = scan.nextLine();
        }
        System.out.printf("Your activation key is: %s",activationKey);
    }
}
