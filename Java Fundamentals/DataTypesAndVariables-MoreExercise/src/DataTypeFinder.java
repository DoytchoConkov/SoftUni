import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!input.equals("END")) {
            boolean flagInt = true;

            try {
                int integer = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                flagInt = false;
            }

            boolean flagDouble = true;
            try {
                double doubl = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                flagDouble = false;
            }
            if (flagInt) {
                System.out.printf("%s is integer type%n", input);
            } else if (flagDouble) {
                System.out.printf("%s is floating point type%n", input);
            } else if (input.length() == 1) {
                System.out.printf("%s is character type%n", input);
            } else if (input.equalsIgnoreCase("true") || (input.equalsIgnoreCase("false"))) {
                System.out.printf("%s is boolean type%n", input);
            } else {
                System.out.printf("%s is string type%n", input);
            }
            input = scan.nextLine();
        }

    }
}
