import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Integer> chars = new LinkedHashMap<>();
        String[] input = scan.nextLine().split("");
        for (String charakter : input) {
            if (!charakter.equals(" ")) {
                chars.putIfAbsent(charakter, 0);
                chars.put(charakter, chars.get(charakter) + 1);
            }
        }
        chars.forEach((k, v) -> {
            System.out.printf("%s -> %d%n", k, v);
        });
    }
}
