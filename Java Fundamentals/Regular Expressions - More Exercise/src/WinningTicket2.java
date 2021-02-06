import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("\\@{6,}|\\${6,}|\\^{6,}|\\#{6,}");
        String[] tikets = input.split("\\s*,\\s*");
        for (String tiket : tikets) {
            if (tiket.length() == 20) {
                String leftTiket = tiket.substring(0, 10);
                String rightTiket = tiket.substring(10);
                Matcher leftMatcher = pattern.matcher(leftTiket);
                Matcher rightMather = pattern.matcher(rightTiket);
                if (leftMatcher.find() && rightMather.find()) {
                    if (leftMatcher.group().equals(rightMather.group())) {
                        if (leftMatcher.group().length() == 10) {
                            System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", tiket, leftMatcher.group().length() , leftMatcher.group().charAt(0));
                        } else if (leftMatcher.group().length() >= 6) {
                            System.out.printf("ticket \"%s\" - %d%c%n", tiket, leftMatcher.group().length() , leftMatcher.group().charAt(0));
                        }
                    }
                }else {
                    System.out.printf("ticket \"%s\" - no match%n", tiket);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
