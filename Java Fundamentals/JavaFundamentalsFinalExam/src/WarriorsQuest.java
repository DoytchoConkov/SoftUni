import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String input = scan.nextLine();
        while (!"For Azeroth".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "GladiatorStance":
                    StringBuilder textUp = new StringBuilder();
                    for (int i = 0; i < text.length(); i++) {
                        textUp.append(Character.toUpperCase((char) text.charAt(i)));
                    }
                    text = textUp.toString();
                    System.out.println(text);
                    break;
                case "DefensiveStance":
                    StringBuilder textLower = new StringBuilder();
                    for (int i = 0; i < text.length(); i++) {
                        textLower.append(Character.toLowerCase((char) text.charAt(i)));
                    }
                    text = textLower.toString();
                    System.out.println(text);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < text.length()) {
                        StringBuilder letterReplace = new StringBuilder();
                        for (int i = 0; i < text.length(); i++) {
                            if (i == index) {
                                letterReplace.append(tokens[2].charAt(0));
                            } else {
                                letterReplace.append((char) text.charAt(i));
                            }
                        }
                        text = letterReplace.toString();
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak.");
                    }
                    break;
                case "Target":
                    if ("Remove".equals(tokens[1])) {
                        StringBuilder removeString = new StringBuilder();
                        removeString.append(text);
                        int startIndex = removeString.indexOf(tokens[2]);
                        removeString.replace(startIndex, startIndex + tokens[2].length(), "");
                        text = removeString.toString();
                        System.out.println(text);
                    } else {
                        StringBuilder changeString = new StringBuilder();
                        changeString.append(text);
                        int beginIndex = changeString.indexOf(tokens[2]);
                        changeString.replace(beginIndex, beginIndex + tokens[2].length(), tokens[3]);
                        text = changeString.toString();
                        System.out.println(text);
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
            }
            input = scan.nextLine();
        }
    }
}
