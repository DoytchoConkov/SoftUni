import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char startLetter = scan.nextLine().charAt(0);
        char endLetter = scan.nextLine().charAt(0);
        String input = scan.nextLine();
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (letter >= startLetter && letter < endLetter) {
                sum += letter;
            }
        }
        System.out.println(sum
        );
    }
}
