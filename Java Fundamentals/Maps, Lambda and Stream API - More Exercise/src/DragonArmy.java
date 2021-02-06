import java.lang.reflect.Array;
import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, int[]>> dragons = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            int[] status = new int[3];
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");
            dragons.putIfAbsent(tokens[0], new TreeMap<>());
            if (!tokens[2].equals("null")) {
                status[0] = Integer.parseInt(tokens[2]);
            } else status[0] = 45;
            if (!tokens[3].equals("null")) {
                status[1] = Integer.parseInt(tokens[3]);
            } else status[1] = 250;
            if (!tokens[4].equals("null")) {
                status[2] = Integer.parseInt(tokens[4]);
            } else status[2] = 10;
            dragons.get(tokens[0]).put(tokens[1], status);
        }
        dragons
                .entrySet()
                .stream()
                .forEach(e -> {
                    int damage = 0;
                    int health = 0;
                    int armor = 0;
                    double cnt = 0;
                    List<String> result = new ArrayList<>();
                    for (Map.Entry<String, int[]> dragon : e.getValue().entrySet()) {
                        damage += dragon.getValue()[0];
                        health += dragon.getValue()[1];
                        armor += dragon.getValue()[2];
                        cnt++;
                        result.add(String.format("-%s -> damage: %d, health: %d, armor: %d", dragon.getKey(), dragon.getValue()[0], dragon.getValue()[1], dragon.getValue()[2]));
                    }
                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n", e.getKey(), damage / cnt, health / cnt, armor / cnt);
                    for (String dragon : result) {
                        System.out.println(dragon);
                    }
                });


    }
}
