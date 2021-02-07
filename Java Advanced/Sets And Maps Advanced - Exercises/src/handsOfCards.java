import java.util.*;

public class handsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("JOKER")) {
            String[] text = input.split(": ");
            String player = text[0];
            String[] cards = text[1].split(", ");
            players.putIfAbsent(player, new HashSet<>());
            for (String card : cards) {
                players.get(player).add(card);
            }
            input = scan.nextLine();
        }

        Map<String, Integer> convertor = new HashMap<>();
        convertor.put("2", 2);
        convertor.put("3", 3);
        convertor.put("4", 4);
        convertor.put("5", 5);
        convertor.put("6", 6);
        convertor.put("7", 7);
        convertor.put("8", 8);
        convertor.put("9", 9);
        convertor.put("J", 11);
        convertor.put("Q", 12);
        convertor.put("K", 13);
        convertor.put("A", 14);
        convertor.put("S", 4);
        convertor.put("H", 3);
        convertor.put("D", 2);
        convertor.put("C", 1);

        players.entrySet().stream().forEach(e -> {
            System.out.printf("%s: ", e.getKey());
            final int[] sum = {0};
            e.getValue().forEach(card -> {
                if (card.length() == 2) {
                    sum[0] += convertor.get("" + card.charAt(0)) * convertor.get("" + card.charAt(1));
                } else {
                    sum[0] += 10 * convertor.get("" + card.charAt(2));
                }
            });
            System.out.printf("%d\n", sum[0]);
        });
    }
}
