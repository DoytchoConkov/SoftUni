import java.util.Scanner;

public class StringManipulatorGroup1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Translate":
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
                case "Start":
                    if (text.indexOf(tokens[1]) == 0) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    System.out.println(text.lastIndexOf(tokens[1]));
                    break;
                case "Remove":
                    StringBuilder newText = new StringBuilder();
                    for (int i = 0; i < text.length(); i++) {
                        if (i >= Integer.parseInt(tokens[1]) && i < Integer.parseInt(tokens[1]) + Integer.parseInt(tokens[2])) {

                        } else
                            newText.append(text.charAt(i));
                    }
                    text = newText.toString();
                    System.out.println(text);
                    break;
            }
            input = scan.nextLine();
        }
    }
}
