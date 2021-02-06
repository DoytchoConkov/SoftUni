import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Integer> chars = new LinkedHashMap<>();
        String[] input = scan.nextLine().split("");
        for (String character : input) {
            if (!character.equals(" ")) {
                chars.putIfAbsent(character, 0);
                chars.put(character, chars.get(character) + 1);
            }
        }
        chars.forEach((k, v) -> {
            System.out.printf("%s -> %d%n", k, v);
        });
    }
}
