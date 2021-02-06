import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, List<String>> synonyms = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            String sinonim = scan.nextLine();
            synonyms.putIfAbsent(word, new ArrayList<>());
            synonyms.get(word).add(sinonim);
        }
        synonyms
                .forEach((k,v) -> {
                    System.out.printf("%s - %s%n",k, v.toString().replaceAll("[\\[\\]]", ""));
                });
    }
}