import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Integer> heroHit = new TreeMap<>();
        Map<String, Integer> heroMana = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] heroes = scan.nextLine().split("\\s+");
            heroHit.put(heroes[0], Integer.parseInt(heroes[1]));
            heroMana.put(heroes[0], Integer.parseInt(heroes[2]));
        }
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] commands = input.split(" - ");
            String heroName = commands[1];
            switch (commands[0]) {
                case "CastSpell":
                    if (heroMana.get(heroName) >= Integer.parseInt(commands[2])) {
                        heroMana.put(heroName, heroMana.get(heroName) - Integer.parseInt(commands[2]));
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, commands[3], heroMana.get(heroName));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, commands[3]);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commands[2]);
                    if (heroHit.get(heroName) - damage > 0) {
                        heroHit.put(heroName, heroHit.get(heroName) - damage);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                                , heroName, damage, commands[3], heroHit.get(heroName));
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, commands[3]);
                        heroHit.remove(heroName);
                        heroMana.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int mana = Integer.parseInt(commands[2]);
                    int currentMana = heroMana.get(heroName);
                    if (mana + currentMana > 200) {
                        mana = 200 - currentMana;
                    }
                    heroMana.put(heroName, mana + currentMana);
                    System.out.printf("%s recharged for %d MP!%n", heroName, mana);
                    break;
                case "Heal":
                    int hit = Integer.parseInt(commands[2]);
                    int currentHit = heroHit.get(heroName);
                    if (hit + currentHit > 100) {
                        hit = 100 - currentHit;
                    }
                    heroHit.put(heroName, hit + currentHit);
                    System.out.printf("%s healed for %d HP!%n", heroName, hit);
                    break;
            }
            input = scan.nextLine();
        }
        heroHit
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    System.out.printf("%s%n", e.getKey());
                    System.out.printf(" HP: %d%n", e.getValue());
                    System.out.printf(" MP: %d%n", heroMana.get(e.getKey()));
                });
    }
}
