import java.util.Scanner;
import java.util.TooManyListenersException;

public class NikuldensCharity {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String massage = scan.nextLine();
        String input = scan.nextLine();
        while (!"Finish".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Replace":
                    StringBuilder replaceChar = new StringBuilder();
                    for (int i = 0; i < massage.length(); i++) {
                        if (massage.charAt(i) == tokens[1].charAt(0)) {
                            replaceChar.append((char) tokens[2].charAt(0));
                        } else {
                            replaceChar.append(massage.charAt(i));
                        }
                    }
                    massage = replaceChar.toString();
                    System.out.println(massage);
                    break;
                case "Cut":
                    StringBuilder cutSubstring = new StringBuilder();
                    cutSubstring.append(massage);
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]) + 1;
                    if (startIndex >= 0 && startIndex < massage.length() && endIndex > startIndex && endIndex >= 0 && endIndex < massage.length()) {
                        cutSubstring.replace(startIndex, endIndex, "");
                        massage = cutSubstring.toString();
                        System.out.println(massage);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;
                case "Make":
                    if ("Upper".equals(tokens[1])) {
                        massage = massage.toUpperCase();
                    } else {
                        massage = massage.toLowerCase();
                    }
                    System.out.println(massage);
                    break;
                case "Check":
                    if (massage.contains(tokens[1])) {
                        System.out.printf("Message contains %s%n", tokens[1]);
                    } else {
                        System.out.printf("Message doesn't contain %s%n", tokens[1]);
                    }
                    break;
                case "Sum":
                    int beginIndex = Integer.parseInt(tokens[1]);
                    int endIndex2 = Integer.parseInt(tokens[2]);
                    int sum = 0;
                    if (beginIndex >= 0 && beginIndex < massage.length() && endIndex2 >= beginIndex && endIndex2 >= 0 && endIndex2 < massage.length()) {
                        for (int i = beginIndex; i <= endIndex2; i++) {
                            sum += massage.charAt(i);
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indexes!");
                    }

                    break;
            }
            input = scan.nextLine();
        }
    }
}
