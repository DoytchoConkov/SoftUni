import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split("\\s+");
        int minLenght = Math.min(tokens[0].length(), tokens[1].length());
        int maxLenght = Math.max(tokens[0].length(), tokens[1].length());
        int result = 0;
        for (int i = 0; i < minLenght; i++) {
            result += tokens[0].charAt(i) * tokens[1].charAt(i);
        }
        if (maxLenght == tokens[0].length()) {
            for (int i = minLenght; i < maxLenght; i++) {
                result += tokens[0].charAt(i);
            }
        } else {
            for (int i = minLenght; i < maxLenght; i++) {
                result += tokens[1].charAt(i);
            }
        }
        System.out.println(result);
    }
}
