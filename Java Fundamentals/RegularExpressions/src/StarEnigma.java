import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Pattern pattern = Pattern.compile("[starSTARS]");
            Matcher matcher = pattern.matcher(input);
            int cnt = 0;
            while (matcher.find()) {
                cnt++;
            }
            String decryptedMasage = "";
            for (int j = 0; j < input.length(); j++) {
                decryptedMasage += (char) (input.charAt(j) - cnt);
            }
            Pattern patternDecoding = Pattern.compile("@(?<name>[A-Za-z]+)([^@\\-!:>])*:(?<population>[0-9]+)([^@\\-!:>])*!(?<mode>[AD])!([^@\\-!:>])*->(?<soldiers>[0-9]+)");
            Matcher matcherDecoding = patternDecoding.matcher(decryptedMasage);
            if (matcherDecoding.find()) {
                if ("A".equals(matcherDecoding.group("mode"))) {
                    attacked.add(matcherDecoding.group("name"));
                } else {
                    destroyed.add(matcherDecoding.group("name"));
                }
            }
        }
        System.out.printf("Attacked planets: %d%n", attacked.size());
        attacked.stream().sorted((p1, p2) -> p1.compareTo(p2)).forEach(p -> {
            System.out.printf("-> %s%n", p);
        });
        System.out.printf("Destroyed planets: %d%n", destroyed.size());
        destroyed.stream().sorted((p1, p2) -> p1.compareTo(p2)).forEach(p -> {
            System.out.printf("-> %s%n", p);
        });
    }
}
