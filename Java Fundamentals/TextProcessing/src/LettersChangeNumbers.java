import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] words = scan.nextLine().split("\\s+");
        double result = 0;
        for (String word : words) {
            char leftLeter = word.charAt(0);
            char rightLeter = word.charAt(word.length() - 1);
            String numberInString = word.substring(1, word.length() - 1);
            double number = Double.parseDouble(numberInString);
            if (Character.isLowerCase(leftLeter)) {
            int position = leftLeter - 'a' + 1;
                number = number * position;
            } else {
                int position = leftLeter - 'A' + 1;
                number = number / position;
            }
            if (Character.isLowerCase(rightLeter)) {
                number = number+rightLeter - 'a' + 1;
            } else {
                number = number-rightLeter + 'A' - 1;
            }
            result += number;
        }
        System.out.printf("%.2f", result);
    }
}
