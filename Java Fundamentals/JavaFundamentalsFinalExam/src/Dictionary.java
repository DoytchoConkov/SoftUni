import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> word = new TreeMap<>();
        String pairs = scan.nextLine();
        String words = scan.nextLine();
        String command = scan.nextLine();
        String[] pair = pairs.split(" \\| ");
        for (String s : pair) {
            String[] definisions = s.split(": ");
            word.putIfAbsent(definisions[0].trim(), new ArrayList<>());
            word.get(definisions[0]).add(definisions[1]);

        }
        String[] tokens = words.split(" | ");
        for (int i = 0; i < tokens.length; i++) {
            if (word.containsKey(tokens[i])) {
                System.out.println(tokens[i]);
                word.get(tokens[i]).stream().forEach(e -> {
                    System.out.printf(" -%s%n", e);
                });
            }
        }
        if ("List".equals(command)) {
            word.entrySet().stream().forEach(e -> {
                System.out.printf("%s ", e.getKey());
            });
        }
    }
}
