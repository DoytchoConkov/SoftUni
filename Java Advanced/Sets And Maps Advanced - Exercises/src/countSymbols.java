import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class countSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> symbolsMap = new TreeMap<>();
        String text = scan.nextLine();
        for (int i = 0; i < text.length(); i++) {
            String currentSymbol = "" + text.charAt(i);
            symbolsMap.putIfAbsent(currentSymbol, 0);
            symbolsMap.put(currentSymbol, symbolsMap.get(currentSymbol) + 1);
        }
        symbolsMap.entrySet().stream().forEach(e -> System.out.printf("%s: %d time/s\n", e.getKey(), e.getValue()));
    }
}
