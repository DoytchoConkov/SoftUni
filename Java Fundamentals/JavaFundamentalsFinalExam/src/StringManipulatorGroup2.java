import java.util.Scanner;

public class StringManipulatorGroup2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String input = scan.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Change":
                    text = text.replace(tokens[1].charAt(0), tokens[2].charAt(0));
                    System.out.println(text);
                    break;
                case "Includes":
                    if (text.contains(tokens[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    int lenght = tokens[1].length();
                    if (text.indexOf(tokens[0]) + lenght == text.length()) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    System.out.println(text.indexOf(tokens[1].charAt(0)));
                    break;
                case "Cut":
                    text = text.substring(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[1]) + Integer.parseInt(tokens[2]));
                    System.out.println(text);
                    break;
            }
            input = scan.nextLine();
        }
    }
}
