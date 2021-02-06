import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char startChar = scan.nextLine().charAt(0);
        char endChar = scan.nextLine().charAt(0);
        if (startChar < endChar) {
            printChars(startChar, endChar);
        } else {
            printChars(endChar, startChar);
        }
    }

    private static void printChars(char startChar, char endChar) {
        for (int i = startChar + 1; i < endChar; i++) {
            System.out.printf("%c ", i);
        }
    }
}
