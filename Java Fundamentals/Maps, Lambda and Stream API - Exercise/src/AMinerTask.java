import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Integer> mining = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"stop".equals(input)) {
            int quantity = Integer.parseInt(scan.nextLine());
            mining.putIfAbsent(input, 0);
            mining.put(input, mining.get(input) + quantity);
            input = scan.nextLine();
        }
        mining.forEach((k, v) -> {
            System.out.printf("%s -> %d%n", k, v);
        });
    }
}
