import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String input = scan.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        while (!"Travel".equals(input)) {
            String[] commands = input.split(":");
            switch (commands[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(commands[1]);
                    if (index >= 0 && index < text.length()) {
                        sb.insert(index, commands[2]);
                        text = sb.toString();
                    }
                    System.out.println(sb.toString());
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    if (startIndex >= 0 && startIndex < text.length() && endIndex >= 0 && endIndex < text.length()) {
                        sb.replace(startIndex, endIndex + 1, "");
                        text = sb.toString();
                    }
                    System.out.println(sb.toString());
                    break;
                case "Switch":
                    if (text.contains(commands[1])) {
                        text = text.replace(commands[1], commands[2]);
                    }
                    System.out.println(text);
                    break;
            }

            input = scan.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", text);
    }
}
