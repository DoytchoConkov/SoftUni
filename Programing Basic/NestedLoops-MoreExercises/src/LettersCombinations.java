import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String letter1 = scan.nextLine();
        String letter2 = scan.nextLine();
        String letter = scan.nextLine();
        int counter = 0;
        for (int i = letter1.charAt(0); i <= letter2.charAt(0); i++) {
            for (int j = letter1.charAt(0); j <= letter2.charAt(0); j++) {
                for (int k = letter1.charAt(0); k <= letter2.charAt(0); k++) {
                    if (i != letter.charAt(0) && j != letter.charAt(0) && k != letter.charAt(0)) {
                        counter++;
                        System.out.printf("%c%c%c ", i, j, k);
                    }
                }
            }
        }
        System.out.println(counter);
    }
}
