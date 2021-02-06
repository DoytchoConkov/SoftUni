import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] demonsArray = input.split(",\\s+");
        Map<String, Integer> demonsHealth = new TreeMap<>();
        Map<String, Double> demonsDamage = new TreeMap<>();
        Pattern patternHealth = Pattern.compile("[A-Za-z]");
        Pattern patternDamage = Pattern.compile("[+-]?[0-9]+\\.*[0-9]*");
        Pattern patternComand = Pattern.compile("[\\/*]");
        for (String demon : demonsArray) {
            demon = demon.replaceAll(" ", "");
            Matcher matcherHealth = patternHealth.matcher(demon);
            Matcher matcherDamage = patternDamage.matcher(demon);
            Matcher matcherComand = patternComand.matcher(demon);
            int health = 0;
            double damage = 0;
            while (matcherHealth.find()) {
                health += matcherHealth.group(0).charAt(0);
            }
            while (matcherDamage.find()) {
                damage += Double.parseDouble(matcherDamage.group(0));
            }
            while (matcherComand.find()) {
                if (matcherComand.group(0).equals("*")) {
                    damage = damage * 2;
                } else {
                    damage = damage / 2;
                }
            }

            demonsHealth.put(demon, health);
            demonsDamage.put(demon, damage);
        }
        for (Map.Entry<String, Integer> demon : demonsHealth.entrySet()) {
            System.out.printf("%s - %d health, %.2f damage%n"
                    , demon.getKey(), demon.getValue(), demonsDamage.get(demon.getKey()));
        }
    }
}
