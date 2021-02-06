import java.util.*;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Integer>> dwarfs = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"Once upon a time".equals(input)) {
            String[] token = input.split(" <:> ");
            String name = token[1];
            String color = token[0];
            int physics = Integer.parseInt(token[2]);
            dwarfs.putIfAbsent(name, new LinkedHashMap<>());
            dwarfs.get(name).putIfAbsent(color, 0);
            if (dwarfs.get(name).get(color) < physics) {
                dwarfs.get(name).put(color, physics);
            }

            input = scan.nextLine();
        }
        Map<String, Integer> print = new LinkedHashMap<>();

        for(Map.Entry<String, Map<String, Integer>> entry : dwarfs.entrySet()) {
            for(Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                print.put(entry.getKey() + " " + subEntry.getKey(), subEntry.getValue());
            }
        }

        print.entrySet().stream().sorted((pair2, pair1) -> {
            int sort = Integer.compare(pair1.getValue(), pair2.getValue());
            if (sort == 0) {

                String[] sort1 = pair2.getKey().split(" ");
                String[] sort2 = pair1.getKey().split(" ");
                sort = sort1[0].compareTo(sort2[0]);
            }
            return sort;
        }).forEach(pair -> {
            String[] printing = pair.getKey().split(" ");
            System.out.printf("(%s) %s <-> %d%n", printing[0], printing[1], pair.getValue());
        });
    }
}
