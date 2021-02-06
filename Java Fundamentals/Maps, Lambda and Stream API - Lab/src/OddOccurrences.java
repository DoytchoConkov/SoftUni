import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        LinkedHashMap<String, Integer> words = new LinkedHashMap<>();
        String temp = "";
        for (String word : input) {
            temp = word.toLowerCase();
            words.putIfAbsent(temp, 0);
            words.put(temp, words.get(temp) + 1);
        }
        List<String> result = new ArrayList();
        for (Map.Entry<String, Integer> word : words.entrySet()) {
            if (word.getValue() % 2 == 1) {
                result.add(word.getKey());
            }
        }
        System.out.println(result.toString().replaceAll("[\\[\\]]", ""));
    }
}