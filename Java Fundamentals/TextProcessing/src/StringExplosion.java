import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder result = new StringBuilder();
        int power = 0;
        for (int i = 0; i < input.length(); i++) {
            char leter = input.charAt(i);
            if (leter == '>') {
                power += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                result.append(leter);
            } else {
                if (power > 0) {
                    power--;
                } else {
                    result.append(leter);
                }
            }
        }
        System.out.println(result);
    }
}